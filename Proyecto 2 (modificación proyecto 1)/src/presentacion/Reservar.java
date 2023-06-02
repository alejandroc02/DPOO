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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Reservar extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textInicio;
	private JTextField textFin;
	private JTextField textniños;
	private JTextField textnombre;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textadultos;
	private JLabel lblNewLabel_5;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textTipo;
	private JLabel lblNewLabel_8;
	private JTextField textIDpersona;
	private JLabel lblNewLabel_9;

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

		JLabel lblNewLabel = new JLabel("id habitacion");
		lblNewLabel.setBounds(10, 10, 96, 13);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idpers = Integer.parseInt(textIDpersona.getText());
				String idhab = textid.getText();
				String nombre = textnombre.getText();
				int cantidadAdultos = Integer.parseInt(textadultos.getText());
				int cantidadNinos = Integer.parseInt(textniños.getText());
				String correo = textCorreo.getText();
				String telefono = textTelefono.getText();
				String inicio = textInicio.getText();
				String final1 = textFin.getText();
				String tipo = textTipo.getText();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechainicial = LocalDate.parse(inicio, formatter);
				LocalDate fechafinal = LocalDate.parse(final1, formatter); 

				int monto = hotel.calcularReserva(tipo, fechainicial, fechafinal);

				boolean confirmar = hotel.reservacuarto(inicio, final1, Integer.parseInt(idhab));
				hotel.reserva(idhab, nombre, inicio, final1, cantidadAdultos, cantidadNinos, tipo);
				hotel.agregarHuesped(nombre, idpers, correo, telefono);
				if (!confirmar) {
					JOptionPane.showMessageDialog(null, "Intente de nuevo");
				} else {
					JOptionPane.showMessageDialog(null, "HECHO!");

						int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea pagar de una vez? (10% decuento)", "Selección",
								JOptionPane.YES_NO_OPTION);
						if (respuesta == JOptionPane.YES_OPTION) {
							monto= (int) (monto - monto*(0.10));
							PagoTarjeta n= new PagoTarjeta(monto, idhab, hotel);
							n.setVisible(true);
						} else if (respuesta == JOptionPane.NO_OPTION) {
							dispose();
						}
						if (cantidadAdultos > 1) {
							JOptionPane.showMessageDialog(null, "Debe agregar a los huéspedes adultos!");
	
							AgregarHuespedes p = new AgregarHuespedes(hotel);
							p.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBounds(143, 172, 96, 21);
		contentPane.add(btnNewButton);

		textInicio = new JTextField();
		textInicio.setBounds(143, 63, 96, 19);
		contentPane.add(textInicio);
		textInicio.setColumns(10);

		textFin = new JTextField();
		textFin.setBounds(143, 100, 96, 19);
		contentPane.add(textFin);
		textFin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("fecha inicio");
		lblNewLabel_1.setBounds(143, 52, 85, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(143, 87, 71, 13);
		contentPane.add(lblNewLabel_2);

		textniños = new JTextField();
		textniños.setBounds(10, 188, 96, 19);
		contentPane.add(textniños);
		textniños.setColumns(10);

		textnombre = new JTextField();
		textnombre.setBounds(10, 63, 96, 19);
		contentPane.add(textnombre);
		textnombre.setColumns(10);

		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 52, 45, 13);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Cantidad de niños");
		lblNewLabel_4.setBounds(10, 176, 96, 13);
		contentPane.add(lblNewLabel_4);

		textadultos = new JTextField();
		textadultos.setBounds(143, 23, 96, 19);
		contentPane.add(textadultos);
		textadultos.setColumns(10);

		lblNewLabel_5 = new JLabel("Cantidad de adultos");
		lblNewLabel_5.setBounds(143, 10, 96, 13);
		contentPane.add(lblNewLabel_5);

		textTelefono = new JTextField();
		textTelefono.setBounds(10, 100, 96, 19);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		textCorreo = new JTextField();
		textCorreo.setBounds(10, 140, 96, 19);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);

		lblNewLabel_6 = new JLabel("Teléfono");
		lblNewLabel_6.setBounds(10, 87, 45, 13);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Correo");
		lblNewLabel_7.setBounds(10, 129, 45, 13);
		contentPane.add(lblNewLabel_7);

		textTipo = new JTextField();
		textTipo.setBounds(143, 140, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);

		lblNewLabel_8 = new JLabel("Tipo habitación");
		lblNewLabel_8.setBounds(143, 129, 96, 13);
		contentPane.add(lblNewLabel_8);

		textIDpersona = new JTextField();
		textIDpersona.setBounds(10, 234, 96, 19);
		contentPane.add(textIDpersona);
		textIDpersona.setColumns(10);

		lblNewLabel_9 = new JLabel("ID persona");
		lblNewLabel_9.setBounds(10, 217, 96, 13);
		contentPane.add(lblNewLabel_9);
	}
}
