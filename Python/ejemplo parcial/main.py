import random #Se elije una mesa aleatoria

"""Un bar va a proyectar en una pantalla gigante los partidos del mundial y necesita tomar la
reserva de las mesas. En total dispone de 20 mesas (numeradas de la 0 a 19)
Se nos pide hacer un programa que tome las reservas de los clientes, los cuales dejan una
seña de $500 a $750 (el cliente elige el valor) para apartar la mesa, que luego se bonificará
en el consumo.
La pantalla de reserva debe permitirle al cliente dejar su DNI y el monto de la reserva, a la
vez que se muestran las mesas disponibles y las reservadas con una “x”. El cliente puede
reservar de 1 a 4 mesas como máximo. Si otro usuario reservó mesas, no se debe mostrar
el DNI por pantalla, sino que ese valor debe quedar almacenado internmente para control de
la empresa en las mesas que hayan sido reservadas.
Las mesas se asigan a los clientes de manera aleatoria (pueden quedar contiguas o no),
avisándole al confirmar la reserva, la o las mesas que se le han asignado. En caso que las
mesas a resevar sean mayores que las disponibles se debe mostrar un error por pantalla.
Al finalizar el programa. Imprimir el total recaudado por seña de reservas así como el listado
de mesas con su correspondiente DNI de reserva.
El programa debe estructurarse con el siguiente menú:
1- Reservar mesa
print("3- Resetear para nuevas reservas")
opcion = input("Seleccione la opcion: ")

if opcion == "1":
    dni = input("Ingrese su DNI: ")
    seña = int(input("Ingrese el monto de la seña: "))
    cantidadMesas = int(input("Ingrese la cantidad de mesas que desea reservar: "))
    if cantidadMesas <= mesasDisponibles():
        for i in range(0, cantidadMesas):
            mesa = random.choice(mesas)
            mesasReservadas.append(mesa)
            mesas.remove(mesa)
            print("Su mesa es la: ", mesa)
    else:
        print("No hay mesas disponibles")

elif opcion == "2":
    print("El total recaudado por seña de reservas es: ", seña)
    print("El listado de mesas con su correspondiente DNI de reserva es: ", mesasReservadas)

elif opcion == "3":
    mesas = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
    mesasReservadas = []
    print("Se han reseteado las mesas")




#FUNCIONES

def mesasDisponibles():
2- Fin reservas e imprimir
3- Resetear para nuevas reservas"""

mesasDisponibles = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
mesasReservadas = []

print("1- Reservar mesa")
print("2- Fin reservas e imprimir")
    cantidad = 0
    for i in range(0, 19):
        if mesas[i] != "x":
            cantidad = cantidad + 1
    return cantidad

def numeroMesa(posicionMesa):
    posicion = 0
    for i in mesas:
        if i != "x":
            posicion = posicion + 1
            if posicion == posicionMesa:
                return i
    return -1

"""""#PROGRAMA PRINCIPAL

mesas = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19] #Se crea una lista con las mesas disponibles
mesasReservadas = [] #Se crea una lista vacia para las mesas reservadas

    
dni = input("Para reservar una mesa, ingrese su DNI: ")
monto = int(input("Ingrese el monto de la seña para la reserva (entre $500 y $750): "))
cantidadMesas = int(input("Ingrese la cantidad de mesas que desea reservar: "))

if cantidadMesas > mesasDisponibles():
    print("No hay mesas disponibles para la cantidad que desea reservar")
else:

    for i in range(0, cantidadMesas):

    print("El monto de la seña es: ", monto)
    print("El DNI del cliente es: ", dni)

    opcion = input("Seleccione la opcion: ")
random.randint(1,mesasDisponibles) #Se elije una mesa aleatoria

mesasReservadas.append(cantidadMesas) #Se agregan las mesas reservadas a la lista mesasReservadas

for cantidadMesas in mesas:
    if cantidadMesas in mesas:
        print("x")"""











