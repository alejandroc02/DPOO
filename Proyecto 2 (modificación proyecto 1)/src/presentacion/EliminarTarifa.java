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

public class EliminarTarifa extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textTipo;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EliminarTarifa(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(21, 21, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(21, 73, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(21, 126, 251, 19);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(21, -2, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(21, 50, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite fecha asi dd/MM/yyyyInicial-dd/MM/yyyyFinal");
		lblNewLabel_2.setBounds(21, 103, 251, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id= textID.getText();
				String tipo = textTipo.getText();
				String fecha = textFecha.getText();
				boolean hecho=hotel.eliminarTarifa(id, fecha, tipo);
				if (hecho) {
					JOptionPane.showMessageDialog(null, "HECHO!");
				}else {
					JOptionPane.showMessageDialog(null, "No existe ese tipo de habitación");
				}
				
			}
		});
		btnNewButton.setBounds(21, 170, 85, 21);
		contentPane.add(btnNewButton);
	}

}
