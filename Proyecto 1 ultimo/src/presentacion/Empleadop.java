package presentacion;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
		this.plano= new Plano();
		plano.CargarArchivos();
		this.hotel = this.plano.hotel;

		setTitle("Bienvenido Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JButton btnConsultarInventario = new JButton("Inventario y Habitaciones");
		btnConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConsultarInventario.setBounds(62, 60, 300, 28);
		contentPane.add(btnConsultarInventario);
		
	
		JButton btnRegistrarConsumo = new JButton("Registrar Consumo");
		btnRegistrarConsumo.setBounds(62, 100, 300, 28);
		contentPane.add(btnRegistrarConsumo);
		
		JButton btnRegistrarHuesped = new JButton("Registrar Huesped");
		btnRegistrarHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarHuesped.setBounds(62, 140, 300, 28);
		contentPane.add(btnRegistrarHuesped);
		/**/
		
		JButton btnConsultarHabitacion = new JButton("Consultar Habitaciones");
		btnConsultarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarHabitacion consultarh = new ConsultarHabitacion(hotel);
				consultarh.setVisible(true);
			}
		});
		btnConsultarHabitacion.setBounds(62, 180, 300, 28);
		contentPane.add(btnConsultarHabitacion);
	}
}
