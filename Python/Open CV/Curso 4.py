#Manipulacion de imagenes

import numpy as np
import matplotlib
matplotlib.use('TkAgg')  # o 'Qt5Agg' dependiendo de tu sistema
import matplotlib.pyplot as plt

import cv2

imagen = cv2.imread("/home/valentinawerle/Documentos/Imagenes/perrito.jpg")

if imagen is not None:
    print(f"Tipo de la imagen: {type(imagen)}")
    print(f"Dimensiones de la imagen: {imagen.shape}")

    imagen2 = cv2.cvtColor(imagen, cv2.COLOR_BGR2RGB)
    imagen2_rgb = cv2.resize(imagen2, (300, 300))

    # Muestra la imagen usando matplotlib
    plt.imshow(imagen2_rgb)
    plt.title("Perrito")
    plt.axis('off')  # Oculta los ejes
    plt.show()


else:
    print(f"No se pude cargar la imagen")




