
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazGrafica {

    private Tabla tabla;

    public InterfazGrafica() {
        JFrame frame = new JFrame("Tabla Hash Interfaz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton buttonCrearTabla = new JButton("1. Crear tabla");
        JButton buttonInsertar = new JButton("2. Insertar elemento");
        JButton buttonEliminar = new JButton("3. Eliminar elemento");
        JButton buttonBuscar = new JButton("4. Buscar elemento");
        JButton buttonImprimir = new JButton("5. Imprimir tabla");
        JButton buttonSalir = new JButton("6. Salir");

        buttonCrearTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabla == null) {
                    int size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la tabla (potencia de 10): "));
                    if (esPotenciaDeDiez(size)) {
                        tabla = new Tabla(size);
                        JOptionPane.showMessageDialog(null, "Tabla creada exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El tamaño debe ser una potencia de 10");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La tabla ya ha sido creada");
                }
            }
        });

        buttonInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {
                    String nombre = JOptionPane.showInputDialog("Nombre: ");
                    String apellido = JOptionPane.showInputDialog("Apellido: ");
                    int dni = Integer.parseInt(JOptionPane.showInputDialog("DNI: "));
                    Elemento elemento = new Elemento(nombre, apellido, dni);
                    tabla.insertar(elemento, tabla.hash(elemento));
                    JOptionPane.showMessageDialog(null, "Elemento insertado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Primero crea una tabla");
                }
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {
                    int dniAEliminar = Integer.parseInt(JOptionPane.showInputDialog("DNI del elemento a eliminar: "));
                    if (tabla.eliminar(dniAEliminar)) {
                        JOptionPane.showMessageDialog(null, "Elemento eliminado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el elemento a eliminar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Primero crea una tabla");
                }
            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {
                    int dniABuscar = Integer.parseInt(JOptionPane.showInputDialog("DNI del elemento a buscar: "));
                    int posicionABuscar = tabla.buscar(dniABuscar);
                    if (posicionABuscar != -1) {
                        JOptionPane.showMessageDialog(null, "El elemento se encuentra en la posición: " + posicionABuscar);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el elemento");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Primero crea una tabla");
                }
            }
        });

        buttonImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {
                    JOptionPane.showMessageDialog(null, tabla.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Primero crea una tabla");
                }
            }
        });

        buttonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(buttonCrearTabla);
        panel.add(buttonInsertar);
        panel.add(buttonEliminar);
        panel.add(buttonBuscar);
        panel.add(buttonImprimir);
        panel.add(buttonSalir);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public boolean esPotenciaDeDiez(int numero) {
        double logBaseDiez = Math.log10(numero);
        return logBaseDiez == (int) logBaseDiez;
    }

    public static void main(String[] args) {
        new InterfazGrafica();
    }
}
