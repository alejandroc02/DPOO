package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Container;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Main.hotel;
import Persistencia.Plano;

public class Empleadop extends JFrame {
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
					Empleadop frame = new Empleadop();
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
	public Empleadop() {
		this.plano = new Plano();
		plano.CargarArchivos();
		this.hotel = this.plano.hotel;

		setTitle("Bienvenido Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Aplicación Empleado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 30, 421, 13);
		contentPane.add(lblNewLabel);

		JButton btnConsultarInventario = new JButton("Inventario y Habitaciones");
		btnConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog inventario = new JDialog();
				inventario.setTitle("Inventario");
				inventario.setLayout(null);
				inventario.setSize(430, 200);
				//tranaja aqui Pablo
				JLabel labelHabitaciones = new JLabel("Inventario Y Habitaciones");
				labelHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelHabitaciones.setHorizontalAlignment(SwingConstants.CENTER);
				labelHabitaciones.setBounds(0, 20, 421, 13);
				inventario.add(labelHabitaciones);

				JButton btnConsultarHabitacion = new JButton("Consultar Habitaciones");
				btnConsultarHabitacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConsultarHabitacion consultarh = new ConsultarHabitacion(hotel);
						consultarh.setVisible(true);
					}
				});
				btnConsultarHabitacion.setBounds(62, 60, 300, 28);
				inventario.add(btnConsultarHabitacion);
			
				JButton btnConsultarDisponibilidad = new JButton("Consultar Inventario");
				btnConsultarDisponibilidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Inventario inventario = new Inventario(hotel);
						inventario.setVisible(true);
					}
				});
				btnConsultarDisponibilidad.setBounds(62, 100, 300, 28);
				inventario.add(btnConsultarDisponibilidad);
				
				inventario.setVisible(true);
			}
		});
		btnConsultarInventario.setBounds(62, 60, 300, 28);
		contentPane.add(btnConsultarInventario);

		JButton btnRegistrarConsumo = new JButton("Registrar Servicio");
		btnRegistrarConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEditarServicio agregarS = new AgregarEditarServicio(hotel);
				agregarS.setVisible(true);
			}
		});
		btnRegistrarConsumo.setBounds(62, 100, 300, 28);
		contentPane.add(btnRegistrarConsumo);

		JButton btnRegistrarHuesped = new JButton("Registrar Huesped");
		btnRegistrarHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHuespedes agregarh = new AgregarHuespedes(hotel);
				agregarh.setVisible(true);
			}
		});
		btnRegistrarHuesped.setBounds(62, 140, 300, 28);
		contentPane.add(btnRegistrarHuesped);

		/**/
		
}

	public class TablaOcupacion extends JFrame {

		private JTable tabla;
		private DefaultTableModel modelo;

		public TablaOcupacion() {
			super("Tabla de Ocupacion");
			setSize(500, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Container container = getContentPane();
			container.setLayout(new BorderLayout());

			String[] columnas = { "Fecha", "ID" };
			modelo = new DefaultTableModel(columnas, 0);

			tabla = new JTable(modelo);
			JScrollPane scroll = new JScrollPane(tabla);
			container.add(scroll, BorderLayout.CENTER);

			List<LocalDate> fechas = new ArrayList<>();
			fechas.add(LocalDate.of(2023, 5, 1));
			fechas.add(LocalDate.of(2023, 5, 2));
			fechas.add(LocalDate.of(2023, 5, 3));
			fechas.add(LocalDate.of(2023, 5, 4));
			fechas.add(LocalDate.of(2023, 5, 5));

			List<Integer> ids = new ArrayList<>();
			ids.add(1);
			ids.add(2);
			ids.add(3);
			ids.add(4);
			ids.add(5);

			for (LocalDate fecha : fechas) {
				for (int id : ids) {
					Object[] fila = { fecha, id };
					modelo.addRow(fila);
				}
			}

			setVisible(true);
		}
	}
}
