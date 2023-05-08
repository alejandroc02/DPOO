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
import java.awt.GridLayout;

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
	}
}
