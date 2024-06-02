package net.cipsa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz de usuario de una calculadora.
 * Contiene métodos y manejadores de eventos para las operaciones de la calculadora.
 */
public class Aplicacion {
    // Declaración de componentes de la interfaz de usuario
    private JPanel root;
    private JPanel cabezera;
    private JPanel botonera;
    private JButton btnReset;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton btnPunto;
    private JButton a8Button;
    private JButton a9Button;
    private JButton btnDivision;
    private JButton a5Button;
    private JButton a6Button;
    private JButton btnMultiplicacion;
    private JButton a2Button;
    private JButton a3Button;
    private JButton btnResta;
    private JButton a0Button;
    private JButton btnIgual;
    private JButton btnSuma;
    private JLabel lblDisplay;

    /**
     * Constructor de la clase Aplicacion.
     * Inicializa los manejadores de eventos para los botones de la calculadora.
     */
    public Aplicacion() {
        // Manejador de eventos para el botón de reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia el texto del display
                lblDisplay.setText("");
            }
        });

        // Manejador de eventos para los botones de dígitos y el punto
        ActionListener listenerDigitos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agrega el texto del botón presionado al display
                String texto = lblDisplay.getText() + ((JButton)e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        };

        // Asignar el manejador de eventos a los botones de dígitos y el punto
        a7Button.addActionListener(listenerDigitos);
        a4Button.addActionListener(listenerDigitos);
        a1Button.addActionListener(listenerDigitos);
        btnPunto.addActionListener(listenerDigitos);
        a8Button.addActionListener(listenerDigitos);
        a9Button.addActionListener(listenerDigitos);
        a5Button.addActionListener(listenerDigitos);
        a6Button.addActionListener(listenerDigitos);
        a2Button.addActionListener(listenerDigitos);
        a3Button.addActionListener(listenerDigitos);
        a0Button.addActionListener(listenerDigitos);

        // Manejador de eventos para los botones de operaciones
        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcula el resultado de la operación actual en el display
                String resultado = calcular(lblDisplay.getText());
                lblDisplay.setText(resultado);

                // Si el botón presionado no es el de igual, agrega el operador al display
                if (e.getSource() != btnIgual) {
                    String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                    lblDisplay.setText(texto);
                }
            }
        };

        // Asignar el manejador de eventos a los botones de operaciones
        btnDivision.addActionListener(listenerOperaciones);
        btnMultiplicacion.addActionListener(listenerOperaciones);
        btnResta.addActionListener(listenerOperaciones);
        btnIgual.addActionListener(listenerOperaciones);
        btnSuma.addActionListener(listenerOperaciones);
    }

    /**
     * Método para calcular el resultado de una operación aritmética.
     * @param operacion La cadena que representa la operación aritmética.
     * @return El resultado de la operación como cadena.
     */
    public String calcular(String operacion){
        String resultado;
        // Divide la cadena de operación en operandos
        String[] ops = operacion.split("[\\+\\-X\\/]");

        // Si solo hay un operando, devuelve ese operando
        if (ops.length == 1){
            resultado = ops[0];
        } else {
            // Convierte los operandos a números flotantes
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;

            // Realiza la operación aritmética correspondiente
            if (operacion.contains("+")){
                r = v1 + v2;
            } else if (operacion.contains("-")){
                r = v1 - v2;
            } else if (operacion.contains("x")) {
                r = v1 * v2;
            } else {
                r = v1 / v2;
            }
            // Convierte el resultado a cadena
            resultado = String.valueOf(r);
        }
        return resultado;
    }

    /**
     * Método principal para ejecutar la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crea y muestra el marco de la aplicación
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
