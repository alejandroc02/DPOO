package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.hotel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarHuespedes extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textID;
	private JTextField textCorreo;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AgregarHuespedes(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 33, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 20, 45, 13);
		contentPane.add(lblNewLabel);
		
		textID = new JTextField();
		textID.setBounds(10, 81, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 62, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(10, 124, 96, 19);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Correo");
		lblNewLabel_2.setBounds(10, 110, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(10, 164, 96, 19);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 153, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre= textNombre.getText();
				int id = Integer.parseInt(textID.getText());
				String correo = textCorreo.getText();
				String telefono = textTelefono.getText();
				Boolean respuesta=hotel.agregarHuespedAReserva(nombre, id, correo, telefono);
				if (respuesta){
					JOptionPane.showMessageDialog(null, "HECHO!");
				}else{
					JOptionPane.showMessageDialog(null, "Ya está agregado!");
				}
				
			}
		});
		btnNewButton.setBounds(10, 193, 85, 21);
		contentPane.add(btnNewButton);
	}
}
