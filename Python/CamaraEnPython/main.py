import cv2

cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("Error: No se puede abrir la cámara")
    exit()

while True:
    ret, frame = cap.read()

    if not ret:
        print("No se puede recibir frame (fin del stream?). Saliendo ...")
        break

    cv2.imshow('Frame', frame)

    if cv2.waitKey(1) == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
