import random #Se importa la libreria random para generar numeros aleatorios

mesas = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19] #Se crea una lista con las mesas disponibles
mesasReservadas = [] #Se crea una lista vacia para las mesas reservadas

print("1- Reservar mesa")
print("2- Fin reservas e imprimir")
print("3- Resetear para nuevas reservas")
opcion = input("Seleccione la opcion: ")

while True:
    if opcion in ["1", "2", "3"]:
        continue

    if opcion == "1":
        dni = input("Ingrese su DNI: ")
        seña = int(input("Ingrese el monto de la seña: "))
        cantidadMesas = int(input("Ingrese la cantidad de mesas que desea reservar: "))

        while cantidadMesas != 0:

            if cantidadMesas > len(mesas):
                print("No hay esa cantidad de mesas disponibles")
            else:
                numeroMesa = random.randint(0,19)

                if numeroMesa in mesas:
                    mesasReservadas.append(numeroMesa)

                    reserva = (f"Su mesa es la {numeroMesa} y su dni es {dni}")

                mesas[numeroMesa] = "X"

                cantidadMesas = cantidadMesas - 1

                print(reserva)

    if opcion == "2":
        print(mesas)

    if opcion == "3":
        mesas = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
        mesasReservadas = []


