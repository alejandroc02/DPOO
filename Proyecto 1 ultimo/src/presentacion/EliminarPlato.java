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

public class EliminarPlato extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;

	/**
	 * Create the frame.
	 */
	public EliminarPlato(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 229, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 46, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 27, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				boolean hecho=hotel.EliminarProducto(nombre);
				if (hecho){
					JOptionPane.showMessageDialog(null, "Plato eliminado!");
				}else{
					JOptionPane.showMessageDialog(null, "Plato no existe!");
				}
				
			}
		});
		btnConfirmar.setBounds(10, 89, 85, 21);
		contentPane.add(btnConfirmar);
	}

}
