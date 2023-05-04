package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Reserva {
	String fechaCheckin;
	String fechaCheckout;
	HashMap<Integer,Habitacion> MapaHabitaciones;
	int cantidadAdultos;
	int cantidadNinos;
	static int contadorId;
	int idReserva;
	HashMap<Integer,Huesped> MapaHuespedes;
	boolean Estado;
	ArrayList<Factura> listaFacturas=new ArrayList<Factura>();
	Random rand = new Random();
	
	public Reserva(String fechaCheckin, String fechaCheckout, HashMap<Integer, Habitacion> mapaHabitaciones,
			int cantidadAdultos, int cantidadNinos,  HashMap<Integer, Huesped> mapaHuespedes) {
		
		this.fechaCheckin = fechaCheckin;
		this.fechaCheckout = fechaCheckout;
		MapaHabitaciones = mapaHabitaciones;
		this.cantidadAdultos = cantidadAdultos;
		this.cantidadNinos = cantidadNinos;
		int valorRandom=generarID();
		Reserva.contadorId+=1;
		this.idReserva = Reserva.contadorId+valorRandom;
		MapaHuespedes = mapaHuespedes;
		this.Estado=false;
	}
	public int generarID() {
		return rand.nextInt(16);
	}
	public int cantidadHabitaciones() {
		return  MapaHabitaciones.size();
	}
	public void agregarFactura(Factura factura) {
		this.listaFacturas.add(factura);
	}
	public boolean getEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	public String getFechaCheckin() {
		return fechaCheckin;
	}

	public String getFechaCheckout() {
		return fechaCheckout;
	}

	public HashMap<Integer, Habitacion> getMapaHabitaciones() {
		return MapaHabitaciones;
	}

	public int getCantidadAdultos() {
		return cantidadAdultos;
	}

	public int getCantidadNinos() {
		return cantidadNinos;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public HashMap<Integer, Huesped> getMapaHuespedes() {
		return MapaHuespedes;
	}

	public void setFechaCheckin(String fechaCheckin) {
		this.fechaCheckin = fechaCheckin;
	}

	public void setFechaCheckout(String fechaCheckout) {
		this.fechaCheckout = fechaCheckout;
	}

	public void setMapaHabitaciones(HashMap<Integer, Habitacion> mapaHabitaciones) {
		MapaHabitaciones = mapaHabitaciones;
	}

	public void setCantidadAdultos(int cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}

	public void setCantidadNinos(int cantidadNinos) {
		this.cantidadNinos = cantidadNinos;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setMapaHuespedes(HashMap<Integer, Huesped> mapaHuespedes) {
		MapaHuespedes = mapaHuespedes;
	}
	
	
	
	
}
