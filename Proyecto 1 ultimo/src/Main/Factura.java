package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Factura {
	static double contadorId;
	private double idFactura;
	private int total;
	private HashMap<String,Integer> mapaServiciosSolicitados;
	Random rand = new Random();
	servicio servicio=new servicio();
	
	
	public Factura() {
		double valorRandom= generarID();
		Factura.contadorId+=1;
		this.idFactura=Factura.contadorId+valorRandom;
	
	}
	public double generarID() {
		return rand.nextInt(16);
	}
	
	public double getId() {
		return this.idFactura;
	}
	
	public void agregarServicio(String serivicioSolicitado) {
		boolean isPresente = servicio.isPresenteServicio(serivicioSolicitado);
		if(isPresente) {
			int precioServicio=servicio.getServicioEspecifico(serivicioSolicitado);
			mapaServiciosSolicitados.put(serivicioSolicitado,precioServicio);
		}else {
			System.out.println("No se econtro ese servicio");
		}
	}
	public int obtenerTotal() {
		Iterator<Map.Entry<String,Integer>> iterador = mapaServiciosSolicitados.entrySet().iterator();
		while(iterador.hasNext()) {
			System.out.println("Todos los servicios solicitados fueron");
			Map.Entry<String, Integer> entry=iterador.next();
			String Servicio=entry.getKey();
			Integer precio = entry.getValue();
			System.out.println("Nombre: "+Servicio+"Precio"+precio);
			this.total+=precio;
		}
		return this.total;
	}
	}
	







