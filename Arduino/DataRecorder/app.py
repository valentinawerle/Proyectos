import serial
import sqlite3
import time
import threading

# Configuración de la base de datos SQLite
DATABASE = 'data.db'

# Constante de tipo string
CONSTANT_STRING = "RPI1"  # Cambia esto según lo que necesites

# Lista de puertos a leer (proporcionada por el usuario)
PORTS = ['/dev/ttyUSB0', '/dev/ttyUSB1', '/dev/ttyUSB2', '/dev/ttyUSB3']  # Cambia esto según tus puertos


def create_table():
    conn = sqlite3.connect(DATABASE)
    cursor = conn.cursor()
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS data (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            timestamp TEXT,
            port_name TEXT,
            constant_string TEXT,
            value REAL
        )
    ''')
    conn.commit()
    conn.close()


def insert_data(port, value):
    conn = sqlite3.connect(DATABASE)
    cursor = conn.cursor()
    cursor.execute('INSERT INTO data (timestamp, port_name, constant_string, value) VALUES (?, ?, ?, ?)',
                   (time.strftime('%Y-%m-%d %H:%M:%S'), port, CONSTANT_STRING, value))
    conn.commit()
    conn.close()


def read_serial(port):
    try:
        ser = serial.Serial(port, 9600)
        while True:
            if ser.in_waiting > 0:
                line = ser.readline().decode('utf-8').strip()
                try:
                    value = float(line)  # Convertir el valor a float
                    print(f"Received from {port}: {value}")
                    insert_data(port, value)
                except ValueError:
                    print(f"Invalid value received from {port}: {line}")
    except serial.SerialException as e:
        print(f"Error opening {port}: {e}")


if __name__ == "__main__":
    create_table()

    print(f"Ports to read: {PORTS}")

    threads = []
    for port in PORTS:
        try:
            # Intentar abrir el puerto para comprobar si está disponible
            ser = serial.Serial(port, 9600, timeout=1)
            ser.close()
            # Si se abre correctamente, lanzar un hilo para leer de este puerto
            thread = threading.Thread(target=read_serial, args=(port,))
            thread.start()
            threads.append(thread)
        except serial.SerialException as e:
            print(f"Cannot open port {port}: {e}")



