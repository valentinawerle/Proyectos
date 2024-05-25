/*
  Blink

  Turns an LED on for one second, then off for one second, repeatedly.

  Most Arduinos have an on-board LED you can control. On the UNO, MEGA and ZERO
  it is attached to digital pin 13, on MKR1000 on pin 6. LED_BUILTIN is set to
  the correct LED pin independent of which board is used.
  If you want to know what pin the on-board LED is connected to on your Arduino
  model, check the Technical Specs of your board at:
  https://www.arduino.cc/en/Main/Products

  modified 8 May 2014
  by Scott Fitzgerald
  modified 2 Sep 2016
  by Arturo Guadalupi
  modified 8 Sep 2016
  by Colby Newman

  This example code is in the public domain.

  https://www.arduino.cc/en/Tutorial/BuiltInExamples/Blink
*/

unsigned long previousMillis1 = 0;  // Variable para almacenar el último tiempo de cambio de estado del LED 1
unsigned long previousMillis2 = 0;  // Variable para almacenar el último tiempo de cambio de estado del LED 2

const long interval1 = 200;  // Intervalo para el LED 1 (200 ms)
const long interval2 = 300;  // Intervalo para el LED 2 (300 ms)

int ledState1 = LOW;  // Estado inicial del LED 1
int ledState2 = LOW;  // Estado inicial del LED 2

void setup() {
  // Inicializar el pin LED_BUILTIN y 10 como una salida.
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(10, OUTPUT);
}

void loop() {
  unsigned long currentMillis = millis();

  // Control del LED_BUILTIN con un intervalo de 200 ms
  if (currentMillis - previousMillis1 >= interval1) {
    previousMillis1 = currentMillis;
    // Cambiar el estado del LED
    ledState1 = !ledState1;
    digitalWrite(LED_BUILTIN, ledState1);
  }

  // Control del LED del pin 10 con un intervalo de 300 ms
  if (currentMillis - previousMillis2 >= interval2) {
    previousMillis2 = currentMillis;
    // Cambiar el estado del LED
    ledState2 = !ledState2;
    digitalWrite(10, ledState2);
  }
}
