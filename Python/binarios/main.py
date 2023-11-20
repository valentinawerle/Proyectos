import email.header

while True:

    valor1 = int(input("Ingrese un numero entero: "))
    valor2 = int(input("Ingrese un otro numero entero: "))

    if valor2 > valor1:
        break
    else:
        print("El primer valor debe ser menor que el segundo")

print("DECIMAL\tBINARIO\tHEXADECIMAL")
for x in range(valor1, valor2 + 1,1):
    print(str(x) + "\t" + str(bin(x)) + "\t" + str(hex(x)))
















