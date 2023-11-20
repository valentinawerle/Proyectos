
lista = []

while True:
    nombre = input("Ingrese nombre de un alumno: ").lower()
    if nombre == "fin":
        break


    lista.append(nombre)



lista.sort()

for i in range(0, len(lista)):


    print(lista[i].capitalize())