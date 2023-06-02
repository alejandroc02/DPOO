package presentacion;
import javax.swing.*;

import Main.hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PagoTarjeta extends JFrame{

    private JTextField propietarioField;
    private JTextField numeroTarjetaField;
    private JTextField csvField;
    private JLabel resultadoLabel;
    private JComboBox<String> pasarelasComboBox; // Agregamos el JComboBox

    public PagoTarjeta(int monto, String idreserva, hotel hotel) {

        setTitle("Validación de Tarjeta de Crédito");
        setSize(460, 264);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 2)); // Aumentamos la cantidad de filas a 5
        getContentPane().add(panelPrincipal);
        
        ArrayList<String> listaPasarelas = hotel.cargarConfiguracionPasarelas();

        JLabel propietarioLabel = new JLabel("Nombre del Propietario:");
        propietarioField = new JTextField();
        JLabel numeroTarjetaLabel = new JLabel("Número de Tarjeta:");
        numeroTarjetaField = new JTextField();
        JLabel csvLabel = new JLabel("CSV:");
        csvField = new JTextField();
        JButton validarButton = new JButton("Pagar");
        validarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = propietarioField.getText();
                int csv = Integer.parseInt(csvField.getText());
                String numero = numeroTarjetaField.getText();
                String pasarelaSeleccionada = (String) pasarelasComboBox.getSelectedItem();
                Boolean confirmar=hotel.PagoTarjetaCredito(pasarelaSeleccionada, monto, idreserva, numero, nombre, csv);
                if(confirmar){
                    JOptionPane.showMessageDialog(null, "HECHO!");
                }else{
                    JOptionPane.showMessageDialog(null, "Hubo un error en su pago");
                }
                
            }
        });
        resultadoLabel = new JLabel();
        
        JLabel pasarelasLabel = new JLabel("Pasarelas:");
        pasarelasComboBox = new JComboBox<>(); // Creamos el JComboBox

        // Creamos el modelo y agregamos los elementos de listaPasarelas al modelo
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String pasarela : listaPasarelas) {
            model.addElement(pasarela);
        }

        // Asignamos el modelo al JComboBox
        pasarelasComboBox.setModel(model);

        panelPrincipal.add(propietarioLabel);
        panelPrincipal.add(propietarioField);
        panelPrincipal.add(numeroTarjetaLabel);
        panelPrincipal.add(numeroTarjetaField);
        panelPrincipal.add(csvLabel);
        panelPrincipal.add(csvField);
        panelPrincipal.add(pasarelasLabel);
        panelPrincipal.add(pasarelasComboBox); // Agregamos el JComboBox al panel
        panelPrincipal.add(validarButton);
        panelPrincipal.add(resultadoLabel);
    }
}

