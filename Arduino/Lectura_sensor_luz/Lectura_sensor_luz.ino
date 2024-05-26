
// Configuración del sensor y comunicación serie
void setup() {
  Serial.begin(9600); // Inicializa la comunicación serie a 9600 baudios
  pinMode(A0, INPUT); // Configura el pin A0 como entrada
}

void loop() {
  int sensorValue = analogRead(A0); // Lee el valor analógico del sensor en A0

  // Convertir la lectura del sensor a voltaje (0-1023 a 0-5V)
  float voltage = sensorValue * (3.3 / 1023.0);

  // Enviar los datos al monitor serie
 
  Serial.println(voltage);

  delay(1000); // Espera 1 segundo antes de la siguiente lectura
}
