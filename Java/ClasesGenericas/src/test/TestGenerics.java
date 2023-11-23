package test;

import genericos.ClaseGenerica;

public class TestGenerics {

    public static void main(String[] args){

        ClaseGenerica<Integer> objetoInt = new ClaseGenerica(15); //
        objetoInt.obtenerTipo();

        ClaseGenerica<String> objetoString = new ClaseGenerica("Hola");
        objetoString.obtenerTipo();

    }

}
