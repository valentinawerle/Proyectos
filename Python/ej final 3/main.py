import random
"""vos haces un if, si la mesa que saco el random.randint ya esta ocupada,debe volver arriba y realizar de nuevo el sorteo"""
mesasDisponibles = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
mesasReservadas = []
informacionReservas = []

print("1- Reservar mesa")
print("2- Fin reservas e imprimir")
print("3- Resetear para nuevas reservas")

opcion = int(input("SELECCIONE UNA OPCION: "))

while True:
    if opcion == 1:
        dni = input("Para reservar una mesa, escriba su dni: ")
        monto = int(input("Escriba el valor de la seña que dejara ($500 a $750) "))
        while True:
            if monto > 500 and monto < 750:
                break
        print("Mesas disponibles: " + str(mesasDisponibles))
        CantidadMesas = int(input("Cuantas mesas desea reservar? "))

        if CantidadMesas < len(mesasDisponibles) - len(mesasReservadas):
            for i in range(1, CantidadMesas -1):
                mesaAsignada = random.randint(0,19)
                print("Mesa asignada: " + str(mesaAsignada))

                if mesaAsignada in mesasDisponibles:
                    mesasDisponibles[mesaAsignada] = "X"
                informacionReservas.append(f"DNI: " + str(dni) +"MESA/S:" + str(mesaAsignada) + "SEÑA: " + str(monto))


        else:
            print("No hay suficientes mesas disponibles")






    elif opcion == 2:
        print(informacionReservas)
        break
    elif opcion == 3:
        resetear = ("Desea resetear para nuevas reservas? (si/no) ")
        if resetear == "si":
            mesasDisponibles = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
            mesasReservadas = []
            informacionReservas = []

        else:
            print("Gracias por utilizar el sistema")
            break
        break
    else:
        print("Opcion invalida")
        break



