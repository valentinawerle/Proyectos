import pandas as pd
import pyarrow.parquet as pq


# Leer el archivo CSV
df = pd.read_csv('film_reviews_result.csv')

# Mostrar las primeras filas del DataFrame
print(df.head())

# Guardar el DataFrame en formato Parquet
df.to_parquet('ruta/archivo.parquet', engine='pyarrow')
