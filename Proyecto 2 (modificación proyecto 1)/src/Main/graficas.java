package Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class graficas {
	String bmw = "BMW";
	String audi = "AUDI";
	String ford = "FORD";
    
	String vel = "Velocidad";
	String millas = "Millas";
	String usuarios = "Usuarios";
	String seguro = "Seguridad";
	
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
	public void agregarInfoDataset() {
		dataset.addValue(1, bmw, vel);
		dataset.addValue(3, bmw, usuarios);
		dataset.addValue(5, bmw, millas);
		dataset.addValue(5, bmw, seguro);
		
		dataset.addValue(5, audi, vel);
		dataset.addValue(6, audi, usuarios);
		dataset.addValue(10, audi, millas);
		dataset.addValue(4, audi, seguro);
		
		dataset.addValue(4, ford, vel);
		dataset.addValue(2, ford, usuarios);
		dataset.addValue(5, ford, millas);
		dataset.addValue(5, ford, seguro);
		JFreeChart barChart = ChartFactory.createBarChart(
				"Grafica de Barras",
				"Categoria",
				"Puntuacion",
				dataset,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		
		JFrame ventana = new JFrame("Grafica");
		ventana.setVisible(true);
		ventana.setSize(600, 800);
		ventana.add(panel);
		
	}
	public graficas() {
		this.agregarInfoDataset();
	}
}
