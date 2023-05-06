package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.hotel;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarHabitacion extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textTipo;
	private JTextField textUbi;
	private JTextField textCapacidad;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AgregarHabitacion(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(10, 28, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(10, 84, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textUbi = new JTextField();
		textUbi.setBounds(10, 139, 96, 19);
		contentPane.add(textUbi);
		textUbi.setColumns(10);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(10, 197, 96, 19);
		contentPane.add(textCapacidad);
		textCapacidad.setColumns(10);
		
		JCheckBox chckbxBalcon = new JCheckBox("Balcón");
		chckbxBalcon.setBounds(215, 27, 93, 21);
		contentPane.add(chckbxBalcon);
		
		JCheckBox chckbxCocina = new JCheckBox("Cocina");
		chckbxCocina.setBounds(215, 83, 93, 21);
		contentPane.add(chckbxCocina);
		
		JCheckBox chckbxVista = new JCheckBox("Vista");
		chckbxVista.setBounds(215, 138, 93, 21);
		contentPane.add(chckbxVista);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 5, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(10, 61, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicación");
		lblNewLabel_2.setBounds(10, 116, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(10, 174, 76, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textID.getText().equals("") || textTipo.getText().equals("") || textUbi.getText().equals("") || textCapacidad.getText().equals("")){
					JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS!");
				}else {
					int id= Integer.parseInt(textID.getText());
					String tipo = textTipo.getText();
					String ubi = textUbi.getText();
					int capacidad = Integer.parseInt(textCapacidad.getText());
					Boolean balcon = chckbxBalcon.isSelected();
					Boolean cocina = chckbxCocina.isSelected();
					Boolean vista = chckbxVista.isSelected();
					hotel.agregarHabitacion(id, tipo, ubi, capacidad, vista, balcon, cocina, false);
					JOptionPane.showMessageDialog(null, "HECHO!");
					textID.setText("");
					textTipo.setText("");
					textCapacidad.setText("");
					textUbi.setText("");
				}
			}
		});
		btnConfirmar.setBounds(193, 196, 85, 21);
		contentPane.add(btnConfirmar);
	}
}
