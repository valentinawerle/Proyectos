import cv2
import face_recognition

# Inicializar la captura de video
captura = cv2.VideoCapture(0)

while True:
    # Capturar frame por frame
    res, frame = captura.read()

    # Convertir la imagen a RGB
    rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Encontrar todas las ubicaciones de rostro
    ubicaciones_rostros = face_recognition.face_locations(rgb_frame)

    # Obtener los encodings para cada rostro
    encodings_rostros = face_recognition.face_encodings(rgb_frame, ubicaciones_rostros)

    # Procesa cada encoding encontrado
    for encoding in encodings_rostros:
        # Aquí podrías hacer procesamiento adicional, como almacenar los encodings
        # o usarlos para reconocimiento de rostros comparando con encodings conocidos.
        pass

    # Mostrar el frame con cualquier modificación que hayas hecho
    cv2.imshow('Video', frame)

    # Romper el loop presionando 'Esc'
    tecla = cv2.waitKey(1)
    if tecla == 27:  # Esc key
        break

captura.release()
cv2.destroyAllWindows()
