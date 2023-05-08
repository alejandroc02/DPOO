package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.hotel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarTarifa extends JFrame {

	private JPanel contentPane;
	private JTextField textFecha;
	private JTextField textTipo;
	private JTextField textPrecio;
	private JTextField textDias;
	private JTextField textid;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param hotel 
	 */
	public AgregarTarifa(hotel hotel) {
		setTitle("Agregar o Editar tarifas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFecha = new JTextField();
		textFecha.setBounds(10, 41, 239, 19);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(10, 98, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(10, 160, 96, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textDias = new JTextField();
		textDias.setBounds(10, 218, 153, 19);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPrecio.getText().equals("") || textTipo.getText().equals("") || textDias.getText().equals("") || textFecha.getText().equals("")){
					JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS!");
				}else {
					String id= textid.getText();
					String tipo = textTipo.getText();
					String dias = textDias.getText();
					int precio = Integer.parseInt(textPrecio.getText());
					String fecha = textFecha.getText();
					hotel.agregarTarifa(id, fecha, dias, precio, tipo);
					JOptionPane.showMessageDialog(null, "HECHO!");
					textPrecio.setText("");
					textTipo.setText("");
					textFecha.setText("");
					textDias.setText("");
				}
			}
		});
		btnNewButton.setBounds(10, 296, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Digite fecha asi dd/MM/yyyyInicial-dd/MM/yyyyFinal");
		lblNewLabel.setBounds(10, 18, 290, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(10, 75, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 137, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Digite dias semana asi L-M-MI-J-V");
		lblNewLabel_3.setBounds(10, 195, 182, 13);
		contentPane.add(lblNewLabel_3);
		
		textid = new JTextField();
		textid.setBounds(10, 267, 96, 19);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(10, 244, 45, 13);
		contentPane.add(lblNewLabel_4);
	}
}
