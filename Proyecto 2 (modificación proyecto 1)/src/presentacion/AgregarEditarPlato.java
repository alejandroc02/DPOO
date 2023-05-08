package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.hotel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEditarPlato extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;

	/**
	 * Create the frame.
	 */
	public AgregarEditarPlato(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 46, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(10, 103, 96, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JCheckBox chckbxHabitacion = new JCheckBox("Apto para consumo en habitación");
		chckbxHabitacion.setBounds(10, 145, 195, 21);
		contentPane.add(chckbxHabitacion);
		
		JButton btnPrecio = new JButton("Confirmar");
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPrecio.getText().equals("") || textPrecio.getText().equals("")){
					JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS!");
				}else {
					String nombre = textNombre.getText();
					int precio = Integer.parseInt(textPrecio.getText());
					boolean habitacion= chckbxHabitacion.isSelected();
					hotel.AgregarProducto(nombre, precio, habitacion);
					JOptionPane.showMessageDialog(null, "Hecho!");
			}
		}
		});
		
		btnPrecio.setBounds(10, 187, 96, 19);
		contentPane.add(btnPrecio);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 23, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 85, 45, 13);
		contentPane.add(lblNewLabel_1);
	}
}
