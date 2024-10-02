#Dibujamos figuras en una imagen

import numpy as np
import matplotlib.pyplot as plt
import cv2

imagen = np.zeros(shape= (500, 500, 3), dtype= np.int16)

print(imagen.shape)
print(plt.imshow(imagen))