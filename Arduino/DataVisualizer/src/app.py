
import tkinter as tk
from tkinter import ttk
import sqlite3
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import datetime

# Configuración de la base de datos SQLite
DATABASE = '../../DataRecorder/src/data.db'

class DataPlotter(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Data Plotter")
        self.geometry("800x600")

        # Crear el marco para la gráfica
        self.frame = ttk.Frame(self)
        self.frame.pack(fill=tk.BOTH, expand=1)

        self.figure, self.ax = plt.subplots()
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
            self.ax.plot(timestamps, values, marker='o', linestyle='-')
            self.ax.set_xlabel('Timestamp')
            self.ax.set_ylabel('Value')
            self.ax.set_title('Data over Time')

            self.figure.autofmt_xdate()
            self.canvas.draw()

    def fetch_data(self):
        conn = sqlite3.connect(DATABASE)
        cursor = conn.cursor()
        ten_minutes_ago = datetime.datetime.now() - datetime.timedelta(minutes=10)
        query = 'SELECT timestamp, value FROM data WHERE timestamp >= ? ORDER BY timestamp'
        cursor.execute(query, (ten_minutes_ago,))
        rows = cursor.fetchall()
        conn.close()
        return rows

def main():
    app = DataPlotter()
    app.mainloop()

if __name__ == "__main__":
    main()
