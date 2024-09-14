from flask import Flask, render_template, jsonify
import sqlite3
import datetime
import matplotlib.pyplot as plt
import matplotlib.dates as mdates
import io
import base64

# Configuración de la base de datos SQLite
DATABASE = '../DataRecorder/data.db'

app = Flask(__name__)

def fetch_data():
    conn = sqlite3.connect(DATABASE, check_same_thread=False)
    cursor = conn.cursor()
    one_minute_ago = datetime.datetime.now() - datetime.timedelta(minutes=1)
    query = 'SELECT timestamp, value FROM data WHERE timestamp >= ? ORDER BY timestamp'
    cursor.execute(query, (one_minute_ago,))
    rows = cursor.fetchall()
    conn.close()

    # Convertir timestamps a objetos datetime
    data = [(datetime.datetime.strptime(row[0], '%Y-%m-%d %H:%M:%S'), row[1]) for row in rows]
    return data

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/data')
def get_data():
    data = fetch_data()
    timestamps, values = zip(*data) if data else ([], [])
    return jsonify({'timestamps': [t.strftime('%Y-%m-%d %H:%M:%S') for t in timestamps], 'values': values})

@app.route('/plot.png')
def plot_png():
    data = fetch_data()
    if data:
        # Crear figura y eje
        fig, ax = plt.subplots()
        ax.set_facecolor('#ffe6f0')
        ax.plot([t for t, v in data], [v for t, v in data], marker='o', linestyle='-', color='#ff007f', markerfacecolor='#ff007f')
        ax.set_xlabel('Tiempo', fontweight='bold')
        ax.set_ylabel('Valores', fontweight='bold')
        ax.set_title('Monitoreo de Luz', fontweight='bold')
        ax.xaxis.set_major_formatter(mdates.DateFormatter('%H:%M:%S'))
        fig.autofmt_xdate()

        # Convertir la figura a PNG en memoria
        img = io.BytesIO()
        fig.savefig(img, format='png')
        img.seek(0)
        plot_url = base64.b64encode(img.getvalue()).decode()

        # Cerrar la figura explícitamente para liberar memoria
        plt.close(fig)

        return '<img src="data:image/png;base64,{}">'.format(plot_url)

    return 'No data available'

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)
