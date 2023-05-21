package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Main.hotel;
import Persistencia.Plano;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class LoginHuesped extends JFrame {
	Plano plano;
	hotel hotel;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField jpassClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginHuesped frame = new LoginHuesped();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginHuesped() {
		this.plano= new Plano();
		plano.CargarArchivos();
		this.hotel = this.plano.hotel;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 142, 63);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(147, 5, 142, 63);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(289, 5, 142, 63);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setBounds(43, 49, 142, 63);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 69, 142, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setBounds(299, 92, 137, 39);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario= txtUsuario.getText();
				char[] clave=jpassClave.getPassword();
				String contraseña = new String(clave);
				boolean confirmar = hotel.verificarUsuario(usuario, contraseña);
				if (confirmar) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido", "INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
					Usuariop p = new Usuariop(hotel);
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					txtUsuario.setText("");
					jpassClave.setText("");
					txtUsuario.requestFocus();
				}
				}
		});
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(284, 171, 142, 63);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(207, 194, 142, 63);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(147, 131, 142, 20);
		contentPane.add(label_4);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setBounds(43, 111, 142, 63);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(147, 131, 142, 26);
		contentPane.add(jpassClave);
		
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(289, 194, 142, 63);
		contentPane.add(label_5);
		
		JLabel lblNewLabel_3 = new JLabel("¿No tienes un usuario?");
		lblNewLabel_3.setBounds(10, 221, 121, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearContraseña p = new CrearContraseña(hotel);
				p.setVisible(true);
			}
		});
		btnCrear.setBounds(20, 236, 85, 17);
		contentPane.add(btnCrear);
	}
}
