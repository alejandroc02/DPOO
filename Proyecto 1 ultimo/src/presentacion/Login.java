package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 22, 93, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 66, 59, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 89, 88, 13);
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(106, 63, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(106, 86, 96, 19);
		contentPane.add(jpassClave);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] clave=jpassClave.getPassword();
				String claveFinal = new String(clave);
				if(txtUsuario.getText().equals("Admin") && claveFinal.equals("Admin")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
					Adminp p = new Adminp();
					p.setVisible(true);
				}else if (txtUsuario.getText().equals("Empleado") && claveFinal.equals("Empleado")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
					Empleadop p = new Empleadop();
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					txtUsuario.setText("");
					jpassClave.setText("");
					txtUsuario.requestFocus();
				}
			}
		});
		btnIngresar.setBounds(223, 81, 85, 21);
		contentPane.add(btnIngresar);
	}
}
