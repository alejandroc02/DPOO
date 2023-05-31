package Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.ChartPanel;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class graficas {
	
	HashMap<String, Integer> productosCantidad = new HashMap<String, Integer>();
	DefaultCategoryDataset datasetproductosCantidad = new DefaultCategoryDataset();
	
	HashMap<String, Integer> productosCosto = new HashMap<String, Integer>();
	DefaultCategoryDataset datasetproductosCosto = new DefaultCategoryDataset();
	
	HashMap<String, Integer> restauranteCostoHabitacion = new HashMap<String, Integer>();
	DefaultCategoryDataset datasetRestauranteCostoHabitacion = new DefaultCategoryDataset();
	
	HashMap<String, int[]> ventasPorHabitacion = new HashMap<String, int[]>();
	
	HashMap<String, Integer> habitacionGastosTotales = new HashMap<String, Integer>();
	DefaultCategoryDataset datasetHabitacionGastosTotales = new DefaultCategoryDataset();
	
	
	public void cargarArchivoGraficas(String Archivo) {
		try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+Archivo))) {
        	String line;
        	String[] elementos;
        	boolean Check1 = true;

            while ((line = br.readLine()) != null) {
            	if (Check1) {

					Check1 = false;
					continue;
				}
                elementos = line.split(",");
                if (productosCantidad.containsKey(elementos[0])) {
                	productosCantidad.put(elementos[0], productosCantidad.get(elementos[0])+1);
                }else {
                	productosCantidad.put(elementos[0], 1);
     
                }
                
                if (productosCosto.containsKey(elementos[0])) {
                	productosCosto.put(elementos[0], productosCosto.get(elementos[0])+Integer.parseInt(elementos[1]));
                }else {
                	productosCosto.put(elementos[0], Integer.parseInt(elementos[1]));
                }
                
                if (elementos[5].contains("restaurante")) {
                	
                	if (restauranteCostoHabitacion.containsKey(elementos[3])) {
                		restauranteCostoHabitacion.put(elementos[3], restauranteCostoHabitacion.get(elementos[3])+Integer.parseInt(elementos[1]));
                	}else {
                		restauranteCostoHabitacion.put(elementos[3], Integer.parseInt(elementos[1]));
                		
                	}
                }
//                int consumoProductos;
//                int valorPorNoche;
//                int[] datos = new int[2];
//                
//                if(ventasPorHabitacion.containsKey(elementos[3])) {
//                	datos = ventasPorHabitacion.get(elementos[3]);
//                	consumoProductos = datos[0];
//                	consumoProductos += Integer.parseInt(elementos[1]);
//                	datos[0] = consumoProductos;
//                	
//                	ventasPorHabitacion.put(elementos[3], datos);
//                }else {
//                	consumoProductos = Integer.parseInt(elementos[1]);
//                	valorPorNoche = Integer.parseInt(elementos[4]);
//                	datos[0] = consumoProductos;
//                	datos[1] = valorPorNoche;
//                	ventasPorHabitacion.put(elementos[3], datos);
//                }
                
                if (habitacionGastosTotales.containsKey(elementos[3])) {
                	habitacionGastosTotales.put(elementos[3], habitacionGastosTotales.get(elementos[3])+Integer.parseInt(elementos[1]));
            	}else {
            		habitacionGastosTotales.put(elementos[3], Integer.parseInt(elementos[1]));
            		
            	}
                
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();}
	}

    public void agregarInfoProductosCantidad() {
    	for(String clave:productosCantidad.keySet()) {
    		datasetproductosCantidad.addValue(productosCantidad.get(clave),clave,"");
    	}
    }
    
    public ChartPanel agregarInfoDatasetProductosCantidad() {
		agregarInfoProductosCantidad();
		JFreeChart barChart = ChartFactory.createBarChart(
				"Grafica Producto vs NumVentas",
				"Producto",
				"NumVentas",
				datasetproductosCantidad,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		
		return panel;
		
    }
		
    
    
    public void agregarInfoProductosCosto() {
    	for(String clave:productosCosto.keySet()) {
    		datasetproductosCosto.addValue(productosCosto.get(clave),clave,"");
    	}
    }
	
	public ChartPanel agregarInfoDatasetProductosCosto() {
		agregarInfoProductosCosto();
		JFreeChart barChart = ChartFactory.createBarChart(
				"Grafica Producto vs Venta total",
				"Producto",
				"Venta Total",
				datasetproductosCosto,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		
		return panel;
		
	}
	
	
	
	public void agregarInfoRestauranteCostoHabitacion() {
    	for(String clave:restauranteCostoHabitacion.keySet()) {
    		datasetRestauranteCostoHabitacion.addValue(restauranteCostoHabitacion.get(clave),clave,"");
    	}
    }
	
	public ChartPanel agregarInfoDatasetRestauranteCostoHabitacion() {
		agregarInfoRestauranteCostoHabitacion();
		JFreeChart barChart = ChartFactory.createBarChart(
				"Grafica Tipo Habitacion vs Consumo Restaurante",
				"Tipo Habitacion",
				"Consumo Restaurante",
				datasetRestauranteCostoHabitacion,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		
		return panel;
		
	}
	
	//habitacionGastosTotales
	
	public void agregarInfoHabitacionGastosTotales() {
    	for(String clave:habitacionGastosTotales.keySet()) {
    		datasetHabitacionGastosTotales.addValue(habitacionGastosTotales.get(clave),clave,"");
    	}
    }
	
	public ChartPanel agregarInfoDatasetHabitacionGastosTotales() {
		agregarInfoHabitacionGastosTotales();
		JFreeChart barChart = ChartFactory.createBarChart(
				"Grafica Tipo Habitacion vs Consumo Total",
				"Tipo Habitacion",
				"Consumo Total",
				datasetHabitacionGastosTotales,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		
		return panel;
		
	}
	
	
	public graficas() {
		cargarArchivoGraficas("Facturas.csv");
		ChartPanel panel_1 = agregarInfoDatasetProductosCantidad();
		ChartPanel panel_2 = agregarInfoDatasetProductosCosto();
    	ChartPanel panel_3 = agregarInfoDatasetRestauranteCostoHabitacion();
    	ChartPanel panel_4 = agregarInfoDatasetHabitacionGastosTotales();
    	JFrame ventana = new JFrame("Graficas Negocio");
    	ventana.setLayout(new GridLayout(2,2));
		ventana.setVisible(true);
		ventana.setSize(600, 800);
    	ventana.add(panel_1);
    	ventana.add(panel_2);
    	ventana.add(panel_3);
    	ventana.add(panel_4);
	}
}
