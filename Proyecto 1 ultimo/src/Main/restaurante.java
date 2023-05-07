package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class restaurante {
	private HashMap<String,Integer> listaMenu= new HashMap<String,Integer>();// Hashmap donde la llave es el producto y el valor es el valor del producto
	private HashMap<String,Boolean> listaMenuAutorizada= new HashMap<String,Boolean>();//HashMap en donde tiene por llave el nombre del producto y como valor si esta autorizado para ir a la habitacion
	public Pedido pedido;
	
	
	
	public restaurante(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+archivo))) {
        	String line = "";
        	String cvsSplitBy = ",";
			boolean Check1 = true;

            while ((line = br.readLine()) != null) {
                if (Check1) {

					Check1 = false;
					continue;
				}
                String[] fields = line.split(cvsSplitBy);
                
           

                listaMenu.put(fields[0], Integer.parseInt(fields[1]));
                listaMenuAutorizada.put(fields[0], Boolean.parseBoolean(fields[2]));
                
                
            }

        } catch (IOException e) {
            e.printStackTrace();}
	}
	public AgregarProducto(String nombre, int precio, boolean habitacion){
		listaMenu.put(nombre, precio);
		listaMenuAutorizada.put(nombre, habitacion);
	}
	public boolean EliminarProducto(String nombre) {
		boolean existe=listaMenu.containsKey(nombre);
		if(existe){
			listaMenu.remove(nombre);
			listaMenuAutorizada.remove(nombre);
			return true;
		}else{
			return false;
		}
		
	}
	
	public void getMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Desea consultar el menu habilitado para las habitaciones ?(SI o NO)");
		String respuesta = sc.next();
		Iterator<Map.Entry<String,Integer>> iterador = listaMenu.entrySet().iterator();
		while(iterador.hasNext()) {
			Map.Entry<String, Integer> entry=iterador.next();
			String prducto=entry.getKey();
			Integer precio = entry.getValue();
			System.out.println("Nombre: "+prducto+"Precio"+precio);
		}
		if (respuesta.equals("SI")) {
			Iterator<Map.Entry<String,Boolean>> iterador2 = listaMenuAutorizada.entrySet().iterator();
			while(iterador2.hasNext()) {
				Map.Entry<String, Boolean> entry=iterador2.next();
				String prducto=entry.getKey();
				Boolean precio = entry.getValue();
				System.out.println("Nombre: "+prducto+"Precio"+precio);
			}
		}
	}
	public void crearPedido(boolean Hab) {
		pedido= new Pedido(Hab);
		
	}
	public void agregarAPedido(String Producto) {
		if(this.pedido.Habitacion) {
			Boolean productoAutorizado=listaMenuAutorizada.containsKey(Producto);
			if (productoAutorizado) {
				Integer precioProducto=listaMenu.get(Producto);
				this.pedido.agregar(Producto, precioProducto);
				
		}else {
			System.out.println("Producto no autorizado para consumo en habitacion o producto no existe");

		}
			
	}else {
		Integer precioProducto=listaMenu.get(Producto);
		this.pedido.agregar(Producto, precioProducto);
	}
	}
	
	 public void eliminarAPedido(String Producto) {
		 Integer Res=this.pedido.eliminar(Producto);
		 if (Res != null) {
			 System.out.println("Producto eleminado del pedido");
		 }else {
			 System.out.println("El producto nunca fue agregado al pedido o se escribio incorrectamente el nombre del producto");
		 }
	    }
	 public void finalizarPedido() {
		 HashMap<String,Integer> pedidoAFinalizar=this.pedido.GetPedido();
		 System.out.println("Su pedido es");
		 Integer totalAPagar=0;
		 Iterator<Map.Entry<String,Integer>> iterador = pedidoAFinalizar.entrySet().iterator();
			while(iterador.hasNext()) {
				Map.Entry<String, Integer> entry=iterador.next();
				String prducto=entry.getKey();
				Integer precio = entry.getValue();
				System.out.println("Nombre: "+prducto+"Precio"+precio);
				totalAPagar+=precio;
			}
		System.out.println("El total a pagar es "+ totalAPagar);
		pedido=null;
	 }


	    }
	
	