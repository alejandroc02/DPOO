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

public class CrearContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField textCrearUsuario;
	private JTextField textCrear_Contraseña;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CrearContraseña(hotel hotel) {
		setTitle("Crear Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCrearUsuario = new JTextField();
		textCrearUsuario.setBounds(10, 52, 96, 19);
		contentPane.add(textCrearUsuario);
		textCrearUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 35, 45, 13);
		contentPane.add(lblNewLabel);
		
		textCrear_Contraseña = new JTextField();
		textCrear_Contraseña.setBounds(10, 95, 96, 19);
		contentPane.add(textCrear_Contraseña);
		textCrear_Contraseña.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(10, 81, 74, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCrearUsuario = new JButton("Crear");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contraseña = textCrear_Contraseña.getText();
				String usuario= textCrearUsuario.getText();
				if (contraseña.equals("") || usuario.equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos");
				}else{
					boolean confirmar = hotel.crearUsuario(usuario, contraseña);
					if (confirmar==false) {
						JOptionPane.showMessageDialog(null, "Usuario existente");
					}else{
						JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
					}
				}
			}
		});
		btnCrearUsuario.setBounds(10, 135, 85, 21);
		contentPane.add(btnCrearUsuario);
	}
}
