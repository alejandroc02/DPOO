package Main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;


import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Pruebas {
	private hotel Hotel;
	
	@BeforeEach
	public void setUp() {
		 this.Hotel= new hotel("InventarioHabitaciones.csv","Menu.csv","Tarifas,csv","Servicios.csv","Usuarios.csv");
	}

	public void pruebaReserva() {
		HashMap<Integer,Habitacion> mapaHab=new HashMap<Integer, Habitacion>();
		ArrayList<Habitacion> listaHab = this.Hotel.ListaHabitaciones;
		for (Habitacion habiAt:listaHab) {
			mapaHab.put(habiAt.getId(), habiAt);
		}
		assertTrue(this.Hotel.crearReserva("Alejandro", "05/05/2022", "10/05/2022", mapaHab, 3, 4, this.Hotel.mapaHuesped));
	}
	
	public void cargarArchivos() {

		assertTrue(this.Hotel.CargarArchivos("InventarioHabitaciones.csv","Menu.csv","Tarifas,csv","Servicios.csv","Usuarios.csv"));
	}
	
}
