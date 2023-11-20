

lineaSanMartin = ["Formación 011", "Formación 012", "Formación 013", "Formación 014"]
lineaUrquiza = ["Formacion 017", "Formacion 002", "Formacion 015", "Formacion 014", "Formación 001", "Formación 004", "Formación 005"]
lineaMitreA =  ["Formacion 018", "Formacion 028", "Formacion 058", "Formacion 048", "Formacion 089", "Formacion 009", "Formacion 005"]
lineaMitreB = ["Formacion 018", "Formacion 028", "Formacion 058", "Formacion 048", "Formacion 089"]

trenesRepetidos = []


print("LINEA SAN MARTIN-------------------")
for i in range(len(lineaSanMartin)):
    print(lineaSanMartin[i])

print("LINEA URQUIZA-------------------")
for i in range(len(lineaUrquiza)):
    print(lineaUrquiza[i])

print("LINEA MITRE A-------------------")
for i in range(len(lineaMitreA)):
    print(lineaMitreA[i])

print("LINEA MITRE B-------------------")
for i in range(len(lineaMitreB)):
    print(lineaMitreB[i])


for i in range(1, len(lineaSanMartin)):
    if lineaSanMartin[i] in lineaUrquiza:
        trenesRepetidos.append(lineaSanMartin[i])
    if lineaSanMartin[i] in lineaMitreA:
        trenesRepetidos.append(lineaSanMartin[i])
    if lineaSanMartin[i] in lineaMitreB:
        trenesRepetidos.append(lineaSanMartin[i])

for i in range(1, len(lineaUrquiza)):
    if lineaUrquiza[i] in lineaMitreA:
        trenesRepetidos.append(lineaUrquiza[i])
    if lineaUrquiza[i] in lineaMitreB:
        trenesRepetidos.append(lineaUrquiza[i])

for i in range(1, len(lineaMitreA)):
    if lineaMitreA[i] in lineaMitreB:
        trenesRepetidos.append(lineaMitreA[i])



print("TRENES REPETIDOS-------------------")
for i in range(len(trenesRepetidos)):
    print(trenesRepetidos[i])


