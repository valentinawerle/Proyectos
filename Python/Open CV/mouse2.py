import cv2
import numpy as np


#Variables globales
dibujando = False
valorx= 0
valory= 0

#Definimos nuestra funcion para dibujar

def dibujar(event, x, y, etiquetas, parametros):
    global dibujando, valorx, valory

    if event == cv2.EVENT_LBUTTONDOWN:
        dibujando = True
        valorx = x
        valory = y

    elif event == cv2.EVENT_MOUSEMOVE:
        if dibujando == True:
            cv2.rectangle(imagen, (valorx, valory), (x,y), (255,0,0), -1)

    elif event == cv2.EVENT_LBUTTONUP:
        dibujando = False
        cv2.rectangle(imagen, (valorx, valory) (x,y), (255, 0,0), -1)


#Conectar funcion dibujar con la imagen
cv2.namedWindow(winname='mi_imagen')
cv2.setMouseCallback('mi_imagen', dibujar)



#Mostrar la imagen donde vamos a dibujar

imagen = np.zeros((500, 500,3), np.int8)

while True:

    cv2.imshow('mi_imagen', imagen)

    if cv2.waitKey(10) & 0xFF == 27:

        break

cv2.destroyAllWindows()





