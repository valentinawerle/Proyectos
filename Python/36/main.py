
"""
Función especial para cargar desde un archivo de texto plano una matriz
El archivo debe tener los valores a cargar en la matriz organizados con la misma estructura (n filas por m columnas).
Para una correcta carga de las columnas, los valores de cada fila del archivo deben estar separados por comas.
PARÁMETROS:
    mat:
    rutaArchivo: Nombre del archivo a leer, incluyendo la ruta completa al archivo.
SALIDA:
    Lista de elementos strings conteniendo cada línea del archivo.
    Los caracteres de terminación de línea se descartan.
"""
import random


def cargarMatrizDesdeArchivo(rutaArchivo):
    archivo = open(rutaArchivo, encoding='utf8', mode='r')
    listaDeLineas = []
    linea = archivo.readline().replace('\n','').split(',')
    while linea != [""]:
        listaDeLineas.append(linea)
        linea = archivo.readline().replace('\n','').split(',')
    archivo.close()
    return listaDeLineas

matriz = cargarMatrizDesdeArchivo("C:/ub/tarjeta.txt")

print("SELECCIONE LA OPCIÓN DEL MENÚ:")
print("1 - Imprimir tarjeta")
print("2 - Probar ingreso de clave")
print("0 - Salir del sistema")

opcion = input("Opcion: ")



if opcion == "0":
    exit()



elif opcion == "1":
    for columna in matriz[0]:
        print(str(columna) + "\t", end="")
    print("\n")
    for fila in matriz:
        for columna in fila:
            print(str(columna) + "\t", end="")
        print("\n")

elif opcion == "2":
    fila = random.randint(0, 5)
    print(fila)
    columna = random.randint(0, 8)
    print(columna)
    clave = matriz[fila][columna]
    print(clave)
    ingreso = input("Ingrese el valor que se encuentra en la fila: " + str(fila + 1) +" y la columna: " + str(columna + 1))
    if ingreso == clave:
        print("La contraseña es correcta")

    else:
        print("La contraseña es incorrecta")