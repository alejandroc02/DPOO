package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class hotel {

	private HashMap<Integer,Habitacion> Habitaciones=new HashMap<Integer,Habitacion>();
	
	private HashMap<String,String> listaPersonal= new HashMap<String,String>();
	private HashMap<String,Boolean> listaPersonalAutorizado= new HashMap<String,Boolean>();
	
	private HashMap<String,Integer> listaMenu= new HashMap<String,Integer>();
	private HashMap<String,Boolean> listaMenuAutorizada= new HashMap<String,Boolean>();
	
	public hotel(String ArchivoHabitaciones,String ArchivoMenu,String ArchivoEmpleados) {
		this.CargarArchivos(ArchivoHabitaciones,ArchivoMenu,ArchivoEmpleados);
	}
	
	private void CargarArchivos(String ArchivoHabitaciones,String ArchivoMenu,String ArchivoEmpleados) {
		String line = "";
		String line2 = "";
		String line3 = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoHabitaciones))) {
        	boolean Check1=true;

            while ((line = br.readLine()) != null) {
            	if (Check1) {
            		
            		Check1=false;
            		continue;
            	}
                
                String[] fields = line.split(cvsSplitBy);
                
           
                
                
                Habitaciones.put(Integer.parseInt(fields[0]), new Habitacion(Integer.parseInt(fields[0]),fields[1],fields[2],Integer.parseInt(fields[3]),Boolean.parseBoolean(fields[4]),Boolean.parseBoolean(fields[5]),Boolean.parseBoolean(fields[6]),Boolean.parseBoolean(fields[7])));
           

            }

        } catch (IOException e) {
            e.printStackTrace();   }
        
        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoMenu))) {
        	boolean Check2=true;

            while ((line2 = br.readLine()) != null) {
            	if (Check2) {
            		
            		Check2=false;
            		continue;
            	}
                
                String[] fields = line2.split(cvsSplitBy);
                
           

                listaMenu.put(fields[0], Integer.parseInt(fields[1]));
                listaMenuAutorizada.put(fields[0], Boolean.parseBoolean(fields[2]));
                
                

            }

        } catch (IOException e) {
            e.printStackTrace();}
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoMenu))) {
        	boolean Check3=true;

            while ((line3 = br.readLine()) != null) {
            	if (Check3) {
            		
            		Check3=false;
            		continue;
            	}
                
                String[] fields = line3.split(cvsSplitBy);
                
                
                
                
                listaPersonal.put(fields[0], fields[1]);
                listaPersonalAutorizado.put(fields[0], Boolean.parseBoolean(fields[2]));
                
                

            }

        } catch (IOException e) {
            e.printStackTrace();
}
        Integer iddd=2024;
        
        Set<Integer> n=Habitaciones.keySet();
        Set<String> k=listaPersonal.keySet();
        
        for (Integer x:n) {
        	System.out.println("Aquitoy");
        	System.out.println(x);
        }
        
        for (String u:k) {
        	System.out.println("Aquitoy2");
        	System.out.println(u);
        }
        System.out.println(listaPersonal.get("A.sar"));
        
        Habitacion hab=Habitaciones.get(iddd);
        System.out.println(hab);
    	hab.consultarHabitacionPorId(iddd);
}

	public HashMap<String,Boolean> consultarPersonalAutorizado(){
		return this.listaPersonalAutorizado;
	}
	
	public HashMap<String,String> consultarPersonal(){
		return this.listaPersonal;
	}
	
	public void agregarHabitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina, boolean EstaOcupada) {
		Habitacion hab=new Habitacion(id,tipo,ubicacion,capacidad,vista,balcon,cocina,EstaOcupada) ;
		Habitaciones.put(id, hab);
	}
}
