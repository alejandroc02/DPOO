package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.Plano;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import Main.hotel;

public class Adminp extends JFrame {
	Plano plano;
	hotel hotel;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminp frame = new Adminp();
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
	public Adminp() {
		this.plano= new Plano();
		plano.CargarArchivos();
		this.hotel = this.plano.hotel;

		setTitle("BIENVENIDO ADMINISTRADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminarMenu = new JButton("Eliminar plato");
		btnEliminarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPlato eliminarp= new EliminarPlato(hotel);
				eliminarp.setVisible(true);
			}
		});
		btnEliminarMenu.setBounds(43, 125, 186, 28);
		contentPane.add(btnEliminarMenu);
		
		JButton btnEliminarProducto = new JButton("Eliminar Servicio");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarServicio eliminars = new EliminarServicio(hotel);
				eliminars.setVisible(true);
			}
		});
		btnEliminarProducto.setBounds(266, 125, 198, 28);
		contentPane.add(btnEliminarProducto);
		
		JLabel lblNewLabel = new JLabel("RESTAURANTE Y SERVICIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 44, 421, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TARIFAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(43, 291, 421, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregarTarifas = new JButton("Agregar o Editar tarifa");
		btnAgregarTarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTarifa agregart = new AgregarTarifa(hotel);
				agregart.setVisible(true);
			}
		});
		btnAgregarTarifas.setBounds(144, 314, 208, 21);
		contentPane.add(btnAgregarTarifas);
		
		JLabel lblNewLabel_2 = new JLabel("HABITACIONES");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(43, 183, 421, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAgregarHabitaciones = new JButton("Agregar Habitaciones");
		btnAgregarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabitacion agregarh = new AgregarHabitacion(hotel);
				agregarh.setVisible(true);
			}
		});
		btnAgregarHabitaciones.setBounds(43, 215, 186, 28);
		contentPane.add(btnAgregarHabitaciones);
		
		JButton btnEditarHabitacion = new JButton("Editar Habitaciones");
		btnEditarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarHabitacion editarh = new EditarHabitacion(hotel);
				editarh.setVisible(true);
			}
		});
		btnEditarHabitacion.setBounds(266, 215, 198, 28);
		contentPane.add(btnEditarHabitacion);
		
		JButton btnConsultarHabitacion = new JButton("Consultar Habitaciones");
		btnConsultarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarHabitacion consultarh = new ConsultarHabitacion(hotel);
				consultarh.setVisible(true);
			}
		});
		btnConsultarHabitacion.setBounds(166, 253, 160, 28);
		contentPane.add(btnConsultarHabitacion);
		
		JButton btnNewButton = new JButton("Eliminar Tarifa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarTarifa eliminart= new EliminarTarifa(hotel);
				eliminart.setVisible(true);
			}
		});
		btnNewButton.setBounds(186, 345, 126, 21);
		contentPane.add(btnNewButton);
		
		JButton btnAgregarPlato = new JButton("Agregar o editar plato");
		btnAgregarPlato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEditarPlato agregaredplato = new AgregarEditarPlato(hotel);
				agregaredplato.setVisible(true);
			}
		});
		btnAgregarPlato.setBounds(43, 69, 186, 28);
		contentPane.add(btnAgregarPlato);
		
		JButton btnAgregarServicio = new JButton("Agregar o editar servicio");
		btnAgregarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEditarServicio agregaredserv = new AgregarEditarServicio(hotel);
				agregaredserv.setVisible(true);
			}
		});
		btnAgregarServicio.setBounds(266, 67, 198, 28);
		contentPane.add(btnAgregarServicio);
	}
}
