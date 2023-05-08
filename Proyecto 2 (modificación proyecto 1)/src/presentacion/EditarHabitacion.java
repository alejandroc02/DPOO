package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.hotel;
import Persistencia.Plano;
public class EditarHabitacion extends JFrame {

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
	public EditarHabitacion(hotel hotel) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(25, 35, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(25, 86, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textUbi = new JTextField();
		textUbi.setBounds(25, 140, 96, 19);
		contentPane.add(textUbi);
		textUbi.setColumns(10);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(25, 190, 96, 19);
		contentPane.add(textCapacidad);
		textCapacidad.setColumns(10);
		
		JCheckBox chckbxBalcon = new JCheckBox("¿Tiene balcón?");
		chckbxBalcon.setBounds(206, 34, 122, 20);
		contentPane.add(chckbxBalcon);
		
		JCheckBox chckbxCocina = new JCheckBox("¿Tiene cocina?");
		chckbxCocina.setBounds(206, 85, 93, 21);
		contentPane.add(chckbxCocina);
		
		JCheckBox chckbxVista = new JCheckBox("¿Tiene vista?");
		chckbxVista.setBounds(206, 139, 93, 21);
		contentPane.add(chckbxVista);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
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
					Boolean bool=hotel.editarHabitacion(id, tipo, ubi, capacidad, vista, balcon, cocina);
					if (bool){
						JOptionPane.showMessageDialog(null, "HECHO!");
					}else{
						JOptionPane.showMessageDialog(null, "Error, no existe esa habitación");
					}
					textID.setText("");
					textTipo.setText("");
					textCapacidad.setText("");
					textUbi.setText("");
				}
			}
		});
		btnNewButton.setBounds(206, 206, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(25, 12, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(25, 63, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicación");
		lblNewLabel_2.setBounds(25, 117, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(25, 167, 75, 13);
		contentPane.add(lblNewLabel_3);
	}
}
