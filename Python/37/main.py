
"""
-----------------------------------------------------------------------------------------------
Programa para la empresa de colectivos de la ciudad
Gestiona la entrada y salida de coches y la asignación de choferes
-----------------------------------------------------------------------------------------------
"""
# IMPORTACIÓN DE MÓDULOS
import sys      # Necesario para invocar el sys.exit() y terminar correctamente el programa
import time # Necesario para registrar la hora de la salida de los colectivos. Usar time.strftime('%H:%M:%S')

# DECLARACIÓN DE FUNCIONES
# No es necesario declarar funciones para este programa

# PROGRAMA PRINCIPAL
# Declaración de variables tipo lista
colectivos = []
choferes = []
asignaciones = []

# Cuerpo del programa
while True:
    while True:
        print()
        print("---------------------------")
        print("MENÚ DEL SISTEMA DE GESTIÓN")
        print("---------------------------")
        print("1 - Registrar ingreso de unidad")
        print("2 - Registrar ingreso de chofer")
        print("3 - Asignar unidades y listar")
        print("4 - Listado resumen diario")
        print("5 - Iniciar jornada")
        print("0 - Salir del sistema")
        print("Seleccione una opción: ")
        opcion = int(input())
        if opcion in range(0, 6, 1): # Sólo continua si se elije una opcion de menú válida
            break

    if opcion == 0: # Opción salir del programa
        exit()
        sys.exit()  # Cierro la aplicación

    elif opcion == 1: # Opción registro de ingreso de unidad al estacionamiento
        numeroColectivo = input \
            ("Ingrese numero del colectivo ingresado: ") # Pedir número de unidad y luego cargarla en la lista
        colectivos.append(numeroColectivo)


    elif opcion == 2:   # Opción registro de ingreso de chofer por la mañana
        nombreChofer = input("Ingrese el nombre del chofer: "  )# Pedir nombre de chofer y luego cargarlo en la lista
        choferes.append(nombreChofer)


    elif opcion == 3:   # Opción registro de asignación de unidades a choferes y listado por pantalla
        while choferes != [] and colectivos != []:
            ultimoColectivo = colectivos.pop()
            print("Colectivo: " + str(ultimoColectivo))
            primerChofer = choferes.pop(0)
            print("Chofer: " + str(primerChofer))
            hora = time.strftime('%H:%M:%S')
            print("Hora de salida: " + str(hora))
            asignacion = ultimoColectivo + primerChofer + hora
            print("Asignacion" + asignacion)
            asignaciones.append(asignacion)




        # Mientras haya choferes, registrar la hora y asignarles una unidad. Cargar todo esto en la lista y mostrar por pantall # ...


    elif opcion == 4:
        print(asignaciones) # Opción listado resumen diario



    elif opcion == 5:   # opción reset para inicio de jornada
        confimacion = input("Desea iniciar la jornada? (si/no) ")
        if confimacion == "si":
            colectivos = []
            choferes = []
            asignaciones = []
            print("Se han eliminado los datos del dia anterior!")

        else:
            continue
