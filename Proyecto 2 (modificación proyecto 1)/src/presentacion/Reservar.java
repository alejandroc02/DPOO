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

public class Reservar extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textInicio;
	private JTextField textFin;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Reservar(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textid = new JTextField();
		textid.setBounds(10, 23, 96, 19);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textid.getText());
				String inicio=textInicio.getText();
				String final1=textFin.getText();
				boolean confirmar=hotel.reserva(inicio, final1, id);
				if (!confirmar) {
					JOptionPane.showMessageDialog(null, "Intente de nuevo");
				}else{
					JOptionPane.showMessageDialog(null, "HECHO!");
				}
			}
		});
		btnNewButton.setBounds(10, 52, 85, 21);
		contentPane.add(btnNewButton);
		
		textInicio = new JTextField();
		textInicio.setBounds(132, 23, 96, 19);
		contentPane.add(textInicio);
		textInicio.setColumns(10);
		
		textFin = new JTextField();
		textFin.setBounds(263, 23, 96, 19);
		contentPane.add(textFin);
		textFin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("fecha inicio");
		lblNewLabel_1.setBounds(132, 10, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(263, 10, 71, 13);
		contentPane.add(lblNewLabel_2);
	}

}
