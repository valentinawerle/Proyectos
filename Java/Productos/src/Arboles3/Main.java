package Arboles3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private ArbolBinario arbol;
    private JTextArea menuTextArea;
    private JComboBox<String> operationComboBox;
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton executeButton;

    public Main() {
        arbol = new ArbolBinario();

        setTitle("Árbol ABB - Interfaz Gráfica");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuTextArea = new JTextArea(
                "MENU DEL ARBOL ABB\n" +
                "---------------------------\n" +
                "[1] Crear arbol\n" +
                "[2] Agregar Hoja\n" +
                "[3] Buscar Elemento\n" +
                "[4] Mostrar Preorden\n" +
                "[5] Mostrar Inorden\n" +
                "[6] Mostrar Postorden\n" +
                "[7] Eliminar Nodo\n" +
                "[0] Salir\n"
        );
        menuTextArea.setEditable(false);
        menuTextArea.setPreferredSize(new Dimension(380, 170));
        add(menuTextArea, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel operationLabel = new JLabel("Operación:");
        String[] operations = {"Seleccione una operación", "Crear arbol", "Agregar Hoja", "Buscar Elemento",
                "Mostrar Preorden", "Mostrar Inorden", "Mostrar Postorden", "Eliminar Nodo", "Salir"};
        operationComboBox = new JComboBox<>(operations);
        inputField = new JTextField(10);
        executeButton = new JButton("Ejecutar");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        panel.setLayout(new BorderLayout());
        panel.add(operationLabel, BorderLayout.WEST);
        panel.add(operationComboBox, BorderLayout.CENTER);
        panel.add(inputField, BorderLayout.EAST);
        panel.add(executeButton, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
        add(resultArea, BorderLayout.SOUTH);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation();
            }
        });
    }

    private void executeOperation() {
        int selectedOperationIndex = operationComboBox.getSelectedIndex();
        if (selectedOperationIndex == 0) {
            resultArea.setText("Seleccione una operación.");
            return;
        }

        int value = 0;
        try {
            value = Integer.parseInt(inputField.getText());
        } catch (NumberFormatException e) {
            resultArea.setText("Ingrese un valor numérico.");
            return;
        }

        switch (selectedOperationIndex) {
            case 1: // Crear arbol
                arbol.insertar(value);
                resultArea.setText("Árbol creado con raíz " + value);
                break;

            case 2: // Agregar Hoja
                arbol.insertar(value);
                resultArea.setText("Hoja agregada con valor " + value);
                break;

            case 3: // Buscar Elemento
                NodoArbol resultadoBusqueda = arbol.buscar(value);
                if (resultadoBusqueda != null)
                    resultArea.setText("El nodo " + value + " fue encontrado en el árbol.");
                else
                    resultArea.setText("El nodo " + value + " no fue encontrado en el árbol.");
                break;

            case 4: // Mostrar Preorden
                resultArea.setText("Recorrido en preorden:\n");
                arbol.preorden(resultArea);
                break;

            case 5: // Mostrar Inorden
                resultArea.setText("Recorrido en inorden:\n");
                arbol.inorden(resultArea);
                break;

            case 6: // Mostrar Postorden
                resultArea.setText("Recorrido en postorden:\n");
                arbol.postorden(resultArea);
                break;

            case 7: // Eliminar Nodo
                arbol.eliminarNodo(value);
                resultArea.setText("Nodo con valor " + value + " eliminado.");
                break;

            case 8: // Salir
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }
}
