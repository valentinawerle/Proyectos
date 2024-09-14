import tkinter as tk
from tkinter import ttk
import sqlite3
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import datetime
import matplotlib.dates as mdates

# Configuración de la base de datos SQLite
DATABASE = '../DataRecorder/data.db'


class DataPlotter(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Data Plotter")
        self.geometry("800x600")

        # Crear el marco para la gráfica
        self.frame = ttk.Frame(self)
        self.frame.pack(fill=tk.BOTH, expand=1)

        self.figure, self.ax = plt.subplots()
        self.ax.set_facecolor('#ffe6f0')  # Fondo de un rosa muy claro
        self.canvas = FigureCanvasTkAgg(self.figure, self.frame)
        self.canvas.get_tk_widget().pack(fill=tk.BOTH, expand=1)

        self.start_plotting()

    def start_plotting(self):
        self.update_plot()
        self.after(1000, self.start_plotting)  # Actualizar cada 1 segundo

    def update_plot(self):
        data = self.fetch_data()

        if data:
            timestamps, values = zip(*data)

            self.ax.clear()
            self.ax.set_facecolor('#ffe6f0')  # Fondo de un rosa muy claro
            self.ax.plot(timestamps, values, marker='o', linestyle='-', color='#ff007f',
                         markerfacecolor='#ff007f')  # Línea y puntos de un rosa oscuro
            self.ax.set_xlabel('Tiempo', fontweight='bold')
            self.ax.set_ylabel('Valores', fontweight='bold')
            self.ax.set_title('Monitoreo de Luz', fontweight='bold')

            # Formatear las etiquetas del eje X para mostrar hora, minutos y segundos
            self.ax.xaxis.set_major_formatter(mdates.DateFormatter('%H:%M:%S'))

            self.figure.autofmt_xdate()
            self.canvas.draw()

    def fetch_data(self):
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


def main():
    app = DataPlotter()
    app.mainloop()


if __name__ == "__main__":
    main()
