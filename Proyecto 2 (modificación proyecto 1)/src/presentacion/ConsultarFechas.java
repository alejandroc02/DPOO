package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.hotel;

import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ConsultarFechas extends JFrame {

	private JPanel contentPane;
	private JTextField textFechas;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollPane;
	private JTextField textFinal;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnLimpiar;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ConsultarFechas(hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fechaInicio = textFechas.getText();
				String fechaFinal = textFinal.getText();
				ArrayList<String> resultList = hotel.consultarFechas(fechaInicio, fechaFinal);
				
				
				for (String result : resultList) {
		            listModel.addElement(result);
		        }
				
			}
		});
		btnNewButton.setBounds(244, 74, 102, 21);
		contentPane.add(btnNewButton);
		
		textFechas = new JTextField();
		textFechas.setBounds(203, 45, 123, 19);
		contentPane.add(textFechas);
		textFechas.setColumns(10);
		
		listModel = new DefaultListModel<>();

        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 31, 165, 212);

        contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Fechas a consultar dd/MM/yyyy");
		lblNewLabel.setBounds(261, 10, 190, 13);
		contentPane.add(lblNewLabel);
		
		textFinal = new JTextField();
		textFinal.setBounds(359, 45, 123, 19);
		contentPane.add(textFinal);
		textFinal.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Fecha inicio");
		lblNewLabel_1.setBounds(203, 33, 94, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fecha final");
		lblNewLabel_2.setBounds(359, 33, 106, 13);
		contentPane.add(lblNewLabel_2);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
			}
		});
		btnLimpiar.setBounds(356, 74, 109, 21);
		contentPane.add(btnLimpiar);
		

	}
}
