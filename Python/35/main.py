


"""
Función que lee un archivo de texto plano y devuelve su contenido como lista de líneas.
PARÁMETROS:
    rutaArchivo: Nombre del archivo a leer, incluyendo la ruta completa al archivo.
SALIDA:
    Lista de elementos strings conteniendo cada línea del archivo.
    Los caracteres de terminación de línea se descartan.
"""
def leerArchivoTXT(rutaArchivo):
    archivo = open(rutaArchivo, encoding='utf8', mode='r')
    listaDeLineas = []
    linea = archivo.readline().replace('\n','')
    while linea != "":
        listaDeLineas.append(linea)
        linea = archivo.readline().replace('\n','')
    archivo.close()
    return listaDeLineas

listaPartieron =  leerArchivoTXT("C:/ub/partieron.txt")
listaLlegaron = leerArchivoTXT("C:/ub/llegaron.txt")

for corredor in listaPartieron:
    if corredor in listaLlegaron:
        print("Tiempo empleado a determinar " + str(corredor))
    else:
        print("Abandono " + str(corredor))


