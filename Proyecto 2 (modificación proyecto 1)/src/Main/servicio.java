package Main;

import java.util.HashMap;


public class servicio {
	private HashMap<String,Integer> MapaSerivicios=new HashMap<>();

	public Integer getServicioEspecifico(String tipoServicio) {
		return this.MapaSerivicios.get(tipoServicio);
		
	}
	public Boolean isPresenteServicio(String servicio) {
		Boolean isPresente=MapaSerivicios.containsKey(servicio);
		return isPresente;
	}
	public void agregarServicio(String nombre,int precio){
		MapaSerivicios.put(nombre, precio);
	}
	public boolean eliminarServicio(String nombre) {
		if(this.isPresenteServicio(nombre)) {
			MapaSerivicios.remove(nombre);
			return true;
		}else {
			return false;
		}
	}
		
	}
	
	
	


