
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazGrafica {

    private Tabla tabla;

    public InterfazGrafica() {
        JFrame frame = new JFrame("Tabla Hash Interfaz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Cambiar el color de fondo de la interfaz
        frame.getContentPane().setBackground(new Color(255, 182, 193)); // Rosa claro

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.setBackground(new Color(238, 130, 238)); // Violeta



        panel.setLayout(new GridLayout(6, 2));

        JLabel labelSize = new JLabel("Tamaño de la Tabla (Potencia de 10): ");
        JTextField textFieldSize = new JTextField();
        JButton buttonCrearTabla = new JButton("Crear Tabla");
        JButton buttonInsertar = new JButton("Insertar Elemento");
        JButton buttonEliminar = new JButton("Eliminar Elemento");
        JButton buttonBuscar = new JButton("Buscar Elemento");
        JButton buttonImprimir = new JButton("Imprimir Tabla");

        buttonCrearTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int size = Integer.parseInt(textFieldSize.getText());
                if (esPotenciaDeDiez(size)) {
                    tabla = new Tabla(size);
                    JOptionPane.showMessageDialog(null, "Tabla creada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "El tamaño debe ser una potencia de 10");
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

        panel.add(labelSize);
        panel.add(textFieldSize);
        panel.add(buttonCrearTabla);
        panel.add(buttonInsertar);
        panel.add(buttonEliminar);
        panel.add(buttonBuscar);
        panel.add(buttonImprimir);

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
