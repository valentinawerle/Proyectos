import cv2
import face_recognition # type: ignore

# Inicializar la captura de video
captura = cv2.VideoCapture(0)

# Esto almacenará encodings únicos de rostros ya vistos
rostros_encontrados = []

while True:
    res, frame = captura.read()
    
    # Convertir la imagen de BGR (openCV) a RGB (face_recognition)
    # rgb_frame = frame[:, :, ::-1]
    rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    
    # Encontrar todas las ubicaciones y encodings de rostros en el frame actual
    ubicaciones_rostros = face_recognition.face_locations(rgb_frame)
    encodings_rostros = face_recognition.face_encodings(rgb_frame, ubicaciones_rostros)
    
    for (ubicacion, encoding_actual) in zip(ubicaciones_rostros, encodings_rostros):
        # Inicialmente asumimos que estamos viendo un nuevo rostro
        igual_que_face      = False
        numero = len(rostros_encontrados) + 1
        
        # Comparamos el encoding actual con todos los encodings que hemos visto antes
        for i, encoding_conocido in enumerate(rostros_encontrados):
            coincide = face_recognition.compare_faces([encoding_conocido], encoding_actual, tolerance=0.6)
            if coincide[0]:
                igual_que_face = True
                numero = i + 1
                break
        
        # Si no coincide con ninguno anterior, agregamos este nuevo encoding a nuestra lista
        if not igual_que_face:
            rostros_encontrados.append(encoding_actual)
        
        # Dibujar un rectángulo alrededor del rostro y asignar un número identificativo
        top, right, bottom, left = ubicacion
        cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
        cv2.putText(frame, f'Persona {numero}', (left + 6, bottom + 30), cv2.FONT_HERSHEY_DUPLEX, 0.6, (255, 255, 255), 1)
    
    cv2.imshow('Video', frame)
    
    tecla = cv2.waitKey(1)
    if tecla == 27:  # Esc key to stop
        break

captura.release()
cv2.destroyAllWindows()
