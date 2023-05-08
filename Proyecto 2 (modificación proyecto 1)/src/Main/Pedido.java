package Main;

import java.util.HashMap;

public class Pedido {
	public HashMap<String,Integer> Pedido;
	public Boolean Habitacion;

	public Pedido(Boolean Habitacion) {
		this.Habitacion=Habitacion;
		
	}
	
	public Boolean getHabitacion() {
		return Habitacion;
	}


	public void agregar(String producto,Integer precio) {
		Pedido.put(producto, precio);
	}
	
	public Integer eliminar(String producto) {
		Integer Res=Pedido.remove(producto);
		return Res;
	}

	public HashMap<String,Integer> GetPedido() {
		return this.Pedido;
	}
	
	

}
