package Persistencia;

import Main.hotel;

public class Plano {
	public hotel hotel;
	public void CargarArchivos() {
		String ArchivoHabitaciones="InventarioHabitaciones.csv";
		String ArchivoMenu="Menu.csv";
		String ArchivoTarifas="Tarifas.csv";
		String ArchivoServicios="Servicios.csv";
		this.hotel=new hotel(ArchivoHabitaciones,ArchivoMenu,ArchivoTarifas, ArchivoServicios);
	}
}
