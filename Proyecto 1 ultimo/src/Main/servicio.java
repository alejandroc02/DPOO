package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class servicio {
	private HashMap<String,Integer> MapaSerivicios=new HashMap<>();
	
	
	public servicio() {
			
	}
	public void getServicios() {
		Iterator<Map.Entry<String,Integer>> iterador = MapaSerivicios.entrySet().iterator();
		while(iterador.hasNext()) {
			Map.Entry<String, Integer> entry=iterador.next();
			String servicio =entry.getKey();
			Integer precio = entry.getValue();
			System.out.println("Servicio: "+servicio+"Precio"+precio);
		}
	}
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
	public void eliminarServicio(String nombre) {
		if(this.isPresenteServicio(nombre)) {
			MapaSerivicios.remove(nombre);
		}else {
			System.out.println("El servicio no existe ");
		}
	}
		
	}
	
	
	


