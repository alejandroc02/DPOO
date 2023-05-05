package Persistencia;

import Main.hotel;

public class Plano {
	public hotel hotel;
	public void CargarArchivos() {
		String ArchivoHabitaciones="InventarioHabitaciones.csv";
		String ArchivoMenu="Empleados.csv";
		String ArchivoEmpleados="Menu.csv";
		String ArchivoTarifas="Tarifas.csv";
		this.hotel=new hotel(ArchivoHabitaciones,ArchivoMenu,ArchivoEmpleados,ArchivoTarifas);
	}
}
