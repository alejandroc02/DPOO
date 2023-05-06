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
		setBounds(100, 100, 430, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarMenu = new JButton("Cargar Menu");
		btnCargarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCargarMenu.setBounds(62, 72, 119, 28);
		contentPane.add(btnCargarMenu);
		
		JButton btnEditarMenu = new JButton("Editar Menu");
		btnEditarMenu.setBounds(62, 125, 119, 28);
		contentPane.add(btnEditarMenu);
		
		JButton btnEliminarMenu = new JButton("Eliminar Menu");
		btnEliminarMenu.setBounds(62, 181, 119, 28);
		contentPane.add(btnEliminarMenu);
		
		JButton btnCargarProducto = new JButton("Cargar Producto");
		btnCargarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargarProducto.setBounds(211, 72, 138, 28);
		contentPane.add(btnCargarProducto);
		
		JButton btnEditarProducto = new JButton("Editar Producto");
		btnEditarProducto.setBounds(211, 125, 138, 28);
		contentPane.add(btnEditarProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(211, 181, 138, 28);
		contentPane.add(btnEliminarProducto);
		
		JLabel lblNewLabel = new JLabel("RESTAURANTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 49, 160, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TARIFAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(136, 363, 126, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregarTarifas = new JButton("Agregar Tarifas");
		btnAgregarTarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTarifa agregart = new AgregarTarifa(hotel);
				agregart.setVisible(true);
			}
		});
		btnAgregarTarifas.setBounds(136, 386, 126, 21);
		contentPane.add(btnAgregarTarifas);
		
		JLabel lblNewLabel_2 = new JLabel("HABITACIONES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(136, 240, 135, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAgregarHabitaciones = new JButton("Agregar Habitaciones");
		btnAgregarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabitacion agregarh = new AgregarHabitacion(hotel);
				agregarh.setVisible(true);
			}
		});
		btnAgregarHabitaciones.setBounds(62, 273, 135, 28);
		contentPane.add(btnAgregarHabitaciones);
		
		JButton btnEditarHabitacion = new JButton("Editar Habitaciones");
		btnEditarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarHabitacion editarh = new EditarHabitacion(hotel);
				editarh.setVisible(true);
			}
		});
		btnEditarHabitacion.setBounds(211, 273, 138, 28);
		contentPane.add(btnEditarHabitacion);
		
		JButton btnConsultarHabitacion = new JButton("Consultar Habitaciones");
		btnConsultarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarHabitacion consultarh = new ConsultarHabitacion(hotel);
				consultarh.setVisible(true);
			}
		});
		btnConsultarHabitacion.setBounds(120, 325, 160, 28);
		contentPane.add(btnConsultarHabitacion);
	}
}
