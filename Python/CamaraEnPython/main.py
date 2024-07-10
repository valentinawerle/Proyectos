import cv2

# Iniciar la captura de video (por defecto, el índice 0 es la cámara integrada)
cap = cv2.VideoCapture(0)

# Verificar si la cámara se abrió correctamente
if not cap.isOpened():
    print("Error: No se puede abrir la cámara")
    exit()

while True:
    # Capturar frame por frame
    ret, frame = cap.read()

    # Si la captura es exitosa, ret será True
    if not ret:
        print("No se puede recibir frame (fin del stream?). Saliendo ...")
        break

    # Mostrar el frame capturado
    cv2.imshow('Frame', frame)

    # Salir del loop si se presiona la tecla 'q'
    if cv2.waitKey(1) == ord('q'):
        break

# Liberar el objeto de captura y cerrar las ventanas
cap.release()
cv2.destroyAllWindows()
