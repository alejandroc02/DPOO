package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.time.LocalDate;

import Main.hotel;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarHuesped extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textID;
	private JTextField textTelefono;
	private JTextField textFecha;
	private JTextField textTipo;
	private JTextField textadultos;
	private JTextField textninos;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AgregarHuesped(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 28, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textID = new JTextField();
		textID.setBounds(10, 84, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(10, 139, 96, 19);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(10, 197, 96, 19);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(10, 197, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);

		textadultos = new JTextField();
		textadultos.setBounds(10, 197, 96, 19);
		contentPane.add(textadultos);
		textadultos.setColumns(10);
		
		textninos = new JTextField();
		textninos.setBounds(10, 197, 96, 19);
		contentPane.add(textninos);
		textninos.setColumns(10);
		

		
		JLabel lblNewLabel = new JLabel("Nombre y Apellido");
		lblNewLabel.setBounds(10, 5, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 61, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(10, 116, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Digite fecha asi dd/MM/yyyyInicial-dd/MM/yyyyFinal");
		lblNewLabel_3.setBounds(10, 174, 76, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de Habitacion");
		lblNewLabel_3.setBounds(10, 174, 76, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad de Adultos");
		lblNewLabel_3.setBounds(10, 174, 76, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad de Ninos");
		lblNewLabel_3.setBounds(10, 174, 76, 13);
		contentPane.add(lblNewLabel_6);
		
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText().equals("") || textID.getText().equals("") || textTelefono.getText().equals("") || textFecha.getText().equals("") || textTipo.getText().equals("") || textadultos.getText().equals("") || textninos.getText().equals("") ){
					JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS!");
				}else {
					String Nombre= textNombre.getText();
					int ID = Integer.parseInt(textID.getText());
					int Telefono = Integer.parseInt(textTelefono.getText());
					String Fecha = textFecha.getText();
					String tipo = textTipo.getText();
					int adultos = Integer.parseInt(textadultos.getText());
					int ninos = Integer.parseInt(textninos.getText());
					hotel.agregarHuespedAReserva(Nombre, ID, Fecha, tipo);
					JOptionPane.showMessageDialog(null, "HECHO!");
					textNombre.setText("");
					textID.setText("");
					textTelefono.setText("");
					textFecha.setText("");
					textTipo.setText("");
					textadultos.setText("");
					textninos.setText("");
				}
			}
		});
		btnConfirmar.setBounds(193, 196, 85, 21);
		contentPane.add(btnConfirmar);
	}
}