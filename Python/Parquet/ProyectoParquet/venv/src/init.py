import pandas as pd
import pyarrow.parquet as pq
import tkinter as tk
from tkinter import ttk


# Lee el archivo CSV
df_In = pd.read_csv('film_reviews_result.csv', sep='|', quotechar='"', decimal=',')

# Setear el tipo de dato de cada columna
df_In['film_name'] = df_In['film_name'].astype('str')
df_In['gender'] = df_In['gender'].astype('str')
df_In['film_avg_rate'] = df_In['film_avg_rate'].astype('float16')
df_In['review_rate'] = df_In['review_rate'].astype('uint8')
df_In['review_title'] = df_In['review_title'].astype('str')
df_In['review_text'] = df_In['review_text'].astype('str')

# Guarda el DataFrame como un archivo Parquet
df_In.to_parquet('reviews.parquet', engine='pyarrow', compression='snappy')

# Lee el archivo Parquet utilizando PyArrow
table = pq.read_table('reviews.parquet')

# Convierte la tabla de PyArrow a un DataFrame de Pandas
df_Out = table.to_pandas()

# Agrupa los datos por 'film_name' y 'gender' y calcula el promedio de 'film_avg_rate'
df_promedios = df_Out.groupby(['film_name'])['film_avg_rate'].mean().reset_index()

# Ordenar el DataFrame por 'film_name' de forma ascendente
df_sorted = df_promedios.sort_values(by='film_name', ascending=True)

# Crear la ventana principal con Tkinter
root = tk.Tk()
root.title("Films Data")

# Establecer el tamaño inicial de la ventana a 640x480
root.geometry("640x480")

# Crear el widget Treeview para mostrar los datos
tree = ttk.Treeview(root, columns=list(df_promedios.columns), show='headings')
tree.pack(side='top', fill='both', expand=True)

# Añadir encabezados de columna
tree.heading('film_name', text='Film Name')
tree.heading('film_avg_rate', text='Film Average Rate')

# Configurar el orden y formato de los datos
for index, row in df_sorted.iterrows():
    # Formatear la columna 'film_average_name' para tener un solo decimal
    film_name = row['film_name']
    film_average_name = f"{row['film_avg_rate']:.1f}"
    
    tree.insert("", "end", values=(film_name, film_average_name))

# Establecer los anchos de columna y alineaciones
tree.column('film_name', anchor='w', width=300)  # Alineación a la izquierda
tree.column('film_avg_rate', anchor='e', width=100)  # Alineación a la derecha

# Lanzar la aplicación
root.mainloop()
