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

public class AgregarEditarServicio extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	/**
	 * Create the frame.
	 */
	public AgregarEditarServicio(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 214, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 36, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(10, 85, 96, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 62, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				int precio = Integer.parseInt(textPrecio.getText());
				hotel.agregarServicio(nombre, precio);
				JOptionPane.showMessageDialog(null, "Hecho!");
				
			}
		});
		btnNewButton.setBounds(10, 124, 85, 21);
		contentPane.add(btnNewButton);
	}

}
