package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Habitacion;
import Main.hotel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	public class Inventario extends JFrame {

		private JPanel contentPane;
		private JTextField textID;
		private JTextField textTipo;


		/**
		 * Launch the application.
		 */

		/**
		 * Create the frame.
		 */
		public Inventario(hotel hotel) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textID = new JTextField();
			textID.setBounds(20, 36, 96, 19);
			contentPane.add(textID);
			textID.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Ingrese el ID ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(20, 13, 96, 13);
			contentPane.add(lblNewLabel);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textID.getText()!="" && textTipo.getText()!="") {
						int id= Integer.parseInt(textID.getText());
						String tipo = textTipo.getText();
						Habitacion habitacion=hotel.consultarhabitacion(id, tipo);
						if (habitacion ==null) {
							JOptionPane.showMessageDialog(null, "No se encontró la habitación");
						}else {
							String cadena="Ocupada" +String.valueOf(habitacion.isOcupada());
							JOptionPane.showMessageDialog(null, cadena);
						}
						
					}
				}
				
			});
	btnConfirmar.setBounds(20, 124, 85, 21);
	contentPane.add(btnConfirmar);
	
	textTipo = new JTextField();
	textTipo.setBounds(20, 80, 96, 19);
	contentPane.add(textTipo);
	textTipo.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Ingrese tipo");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel_1.setBounds(20, 65, 96, 13);
	contentPane.add(lblNewLabel_1);}}
