#Abrir una imagen con Open CV

import numpy as np
import matplotlib.pyplot as plt
import cv2
import shape

imagen = cv2.imread("/home/valentinawerle/Documentos/Imagenes/perrito.jpg")

if imagen is not None:
    print(f"Tipo de la imagen: {type(imagen)}")
    print(f"Dimensiones de la imagen: {imagen.shape}")
    # Convierte la imagen de BGR (formato por defecto de OpenCV) a RGB
    imagen_rgb = cv2.cvtColor(imagen, cv2.COLOR_BGR2RGB)

    # Muestra la imagen usando matplotlib
    plt.imshow(imagen_rgb)
    plt.title("Perrito")
    plt.axis('off')  # Oculta los ejes
    plt.show()


else:
    print(f"No se pude cargar la imagen")

