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
				String añadir="ID "+habitacionactual.getId()+", Tipo: "+habitacionactual.getTipo()+
                		", Capacidad: "+habitacionactual.getCapacidad()+", Ubicación: "+habitacionactual.getUbicacion();
				respuesta.add(añadir);
			}else{
				LocalDate fechaFinal2=listaClaves.get(0);
				LocalDate fechaInicial2=listaClaves.get(listaClaves.size()-1);
				if (!(fechaInicial2.isAfter(fechaInicio) && fechaFinal2.isBefore(fechafin))) {
                	String añadir="ID "+habitacionactual.getId()+", Tipo: "+habitacionactual.getTipo()+
                			", Capacidad: "+habitacionactual.getCapacidad()+", Ubicación: "+habitacionactual.getUbicacion();
                	respuesta.add(añadir);
            	}
			}
		}
		return respuesta;
		
	}
}
