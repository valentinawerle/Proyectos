#Autor: Valentina Werle

ventas = int(input("Ingrese numero de ventas: "))

ventasA = 0
ventasB = 0
ventasC = 0

subTotalA = 0
subTotalB = 0
subTotalC = 0

total = 0
contador = 1

while contador <= ventas:
    monto = int(input("Ingrese el dinero recaudado: "))

    if monto > 1000:
        ventasA = ventasA + 1
        subTotalA = subTotalA + monto

    elif monto > 500:
        ventasB = ventasB + 1
        subTotalB = subTotalB + monto

    else:
        ventasC = ventasC + 1
        subTotalC = subTotalC + monto

    total = total + monto
    contador = contador + 1

print(" La venta A vendio " + str(ventasA) + " objeto/s y recaudo " + str(subTotalA) + "$.")
print(" La venta B vendio " + str(ventasB) + " objeto/s y recaudo " + str(subTotalB) + "$.")
print(" La venta C vendio " + str(ventasC) + " objeto/s y recaudo " + str(subTotalC) + "$.")




