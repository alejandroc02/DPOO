package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Usuario {
	public HashMap<String,ArrayList<String>> MapaUsuarios=new HashMap<>();
	
	public boolean CrearUsuario(String usuario, String contraseña) {
		if (this.MapaUsuarios.containsKey(usuario)) {
			return false;
		}else {
			ArrayList<String> infoUsuario = new ArrayList<>();
			infoUsuario.add(usuario);
			infoUsuario.add(contraseña);
			this.MapaUsuarios.put(usuario, infoUsuario);
			return true;
		}	
	}
	public boolean VerificarUsuario(String usuario, String contraseña) {
		if(this.MapaUsuarios.containsKey(usuario)) {
			ArrayList<String> mapa=this.MapaUsuarios.get(usuario);
			if(mapa.contains(contraseña)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public ArrayList<String> consultarFechas(String fechaInicial, String fechaFinal, ArrayList<Habitacion> habitaciones){
		ArrayList<String> respuesta= new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaInicio = LocalDate.parse(fechaInicial, formatter);
		LocalDate fechafin = LocalDate.parse(fechaFinal, formatter);
		HashMap<LocalDate, Boolean> fechasOcupadas = new HashMap<LocalDate, Boolean>();
		for (Habitacion habitacionactual:habitaciones) {
			fechasOcupadas=habitacionactual.GetMapaFechas();
			Set<LocalDate> conjuntoclaves=fechasOcupadas.keySet();
			ArrayList<LocalDate> listaClaves = new ArrayList<>(conjuntoclaves);
			if (listaClaves.size()==0){
				String añadir="ID "+habitacionactual.getId()+"\n"+", Ubicación: " + habitacionactual.getUbicacion() + "\n" + ", Tipo: "
				+ habitacionactual.getTipo() + "\n" +
				", Capacidad: " + java.lang.String.valueOf(habitacionactual.getCapacidad()) + "\n" + ", Vista: "
				+ java.lang.String.valueOf(habitacionactual.isVista()) + "\n" + ", Balcon: "
				+ java.lang.String.valueOf(habitacionactual.isBalcon()) + "\n" + ", Cocina: "
				+ java.lang.String.valueOf(habitacionactual.isCocina())+ "\n" + ", Aire: "
				+ java.lang.String.valueOf(habitacionactual.getAire())+ "\n" + ", Calefacción: "
				+ java.lang.String.valueOf(habitacionactual.getCalefaccion())+ "\n" + "Tv: "
				+ java.lang.String.valueOf(habitacionactual.getTv())+ "\n" + ", Cafetera: "
				+ java.lang.String.valueOf(habitacionactual.getCafetera())+ "\n" + ", Ropa y tapetes: "
				+ java.lang.String.valueOf(habitacionactual.getRopaYTapetes())+ "\n" + ", Plancha: "
				+ java.lang.String.valueOf(habitacionactual.getPlancha())+ "\n" + ", Secador: "
				+ java.lang.String.valueOf(habitacionactual.getSecador())+ "\n" + ", Voltaje AC: "
				+ java.lang.String.valueOf(habitacionactual.getVoltajeAc())+ "\n" + ", Toma USB A: "
				+ java.lang.String.valueOf(habitacionactual.getTomaUSBA())+ "\n" + ", Toma USB C: "
				+ java.lang.String.valueOf(habitacionactual.getTomaUSBC())+ "\n" + ", Desayuno: "
				+ java.lang.String.valueOf(habitacionactual.getDesayuno())+ "\n" + ", Parqueadero Pago: "
				+ java.lang.String.valueOf(habitacionactual.getParqueaderoPagoH())+ "\n" + ", Parqueadero gratis: "
				+ java.lang.String.valueOf(habitacionactual.getParqueaderoGratisH())+ "\n" + ", Piscina: "
				+ java.lang.String.valueOf(habitacionactual.getPiscina())+ "\n" + ", Zonas Humedas: "
				+ java.lang.String.valueOf(habitacionactual.getZonasHumedas())+ "\n" + ", BBQ: "
				+ java.lang.String.valueOf(habitacionactual.getBQQ())+ "\n" + ", Wifi: "
				+ java.lang.String.valueOf(habitacionactual.getWifi())+ "\n" + ", Recepción 24/7: "
				+ java.lang.String.valueOf(habitacionactual.getRecepcion24H())+ "\n" + ", Mascotas: "
				+ java.lang.String.valueOf(habitacionactual.getMascotas());
				respuesta.add(añadir);
			}else{
				LocalDate fechaFinal2=listaClaves.get(0);
				LocalDate fechaInicial2=listaClaves.get(listaClaves.size()-1);
				if (!(fechaInicial2.isAfter(fechaInicio) && fechaFinal2.isBefore(fechafin))) {
                	String añadir="ID "+habitacionactual.getId()+"\n"+", Ubicación: " + habitacionactual.getUbicacion() + "\n" + ", Tipo: "
							+ habitacionactual.getTipo() + "\n" +
							", Capacidad: " + java.lang.String.valueOf(habitacionactual.getCapacidad()) + "\n" + ", Vista: "
							+ java.lang.String.valueOf(habitacionactual.isVista()) + "\n" + ", Balcon: "
							+ java.lang.String.valueOf(habitacionactual.isBalcon()) + "\n" + ", Cocina: "
							+ java.lang.String.valueOf(habitacionactual.isCocina())+ "\n" + ", Aire: "
							+ java.lang.String.valueOf(habitacionactual.getAire())+ "\n" + ", Calefacción: "
							+ java.lang.String.valueOf(habitacionactual.getCalefaccion())+ "\n" + "Tv: "
							+ java.lang.String.valueOf(habitacionactual.getTv())+ "\n" + ", Cafetera: "
							+ java.lang.String.valueOf(habitacionactual.getCafetera())+ "\n" + ", Ropa y tapetes: "
							+ java.lang.String.valueOf(habitacionactual.getRopaYTapetes())+ "\n" + ", Plancha: "
							+ java.lang.String.valueOf(habitacionactual.getPlancha())+ "\n" + ", Secador: "
							+ java.lang.String.valueOf(habitacionactual.getSecador())+ "\n" + ", Voltaje AC: "
							+ java.lang.String.valueOf(habitacionactual.getVoltajeAc())+ "\n" + ", Toma USB A: "
							+ java.lang.String.valueOf(habitacionactual.getTomaUSBA())+ "\n" + ", Toma USB C: "
							+ java.lang.String.valueOf(habitacionactual.getTomaUSBC())+ "\n" + ", Desayuno: "
							+ java.lang.String.valueOf(habitacionactual.getDesayuno())+ "\n" + ", Parqueadero Pago: "
							+ java.lang.String.valueOf(habitacionactual.getParqueaderoPagoH())+ "\n" + ", Parqueadero gratis: "
							+ java.lang.String.valueOf(habitacionactual.getParqueaderoGratisH())+ "\n" + ", Piscina: "
							+ java.lang.String.valueOf(habitacionactual.getPiscina())+ "\n" + ", Zonas Humedas: "
							+ java.lang.String.valueOf(habitacionactual.getZonasHumedas())+ "\n" + ", BBQ: "
							+ java.lang.String.valueOf(habitacionactual.getBQQ())+ "\n" + ", Wifi: "
							+ java.lang.String.valueOf(habitacionactual.getWifi())+ "\n" + ", Recepción 24/7: "
							+ java.lang.String.valueOf(habitacionactual.getRecepcion24H())+ "\n" + ", Mascotas: "
							+ java.lang.String.valueOf(habitacionactual.getMascotas());
                	respuesta.add(añadir);
            	}
			}
		}
		return respuesta;
		
	}
}
