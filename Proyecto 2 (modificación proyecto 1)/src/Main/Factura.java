package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Factura {
	static double contadorId;
	private double idFactura;
	private int total;
	private HashMap<String,servicio> mapaServiciosSolicitados;
	Random rand = new Random();
	servicio servicio=new servicio();
	private boolean estaPago;
	
	
	public Factura() {
		double valorRandom= generarID();
		Factura.contadorId+=1;
		this.idFactura=Factura.contadorId+valorRandom;
		this.estaPago=false;
	
	}
	
	public boolean isEstaPago() {
		return estaPago;
	}

	public void setEstaPago() {
		this.estaPago=true;
		
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
			mapaServiciosSolicitados.put(serivicioSolicitado,servicio);
		}else {
			System.out.println("No se econtro ese servicio");
		}
	}
	public int obtenerTotal() {
		Iterator<Map.Entry<String,servicio>> iterador = mapaServiciosSolicitados.entrySet().iterator();
		while(iterador.hasNext()) {
			System.out.println("Todos los servicios solicitados fueron");
			Map.Entry<String, servicio> entry=iterador.next();
			String servicioNombre=entry.getKey();
			servicio Servicio = entry.getValue();
			int precio=Servicio.getServicioEspecifico(servicioNombre);
			System.out.println("Nombre: "+Servicio+"Precio"+precio);
			this.total+=precio;
		}
		return this.total;
	}
	
	public void Pago(String idReserva) {
		
	}
	}
	







