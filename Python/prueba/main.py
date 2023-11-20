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
2- Fin reservas e imprimir
3- Resetear para nuevas reservas"""

mesas = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20] #Se crea una lista con las mesas disponibles
mesasReservadas = [] #Se crea una lista vacia para las mesas reservadas

print("1- Reservar mesa")
print("2- Fin reservas e imprimir")
print("3- Resetear para nuevas reservas")
opcion = input("Seleccione la opcion: ")

dni = input("Para reservar una mesa, ingrese su DNI: ")
monto = int(input("Ingrese el monto de la seña para la reserva (entre $500 y $750): "))
cantidadMesas = int(input("Ingrese la cantidad de mesas que desea reservar: ")).random.randint(1,20) #Se elije una mesa aleatoria



