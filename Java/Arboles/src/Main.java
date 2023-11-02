public class Main {

    Nodo nodo1 = new Nodo("A");
    Nodo nodo2 = new Nodo("B");
    nodo1.agregarHijo(nodo2);

    String resultado = padre(nodo1);
    System.out.println(resultado);



}
