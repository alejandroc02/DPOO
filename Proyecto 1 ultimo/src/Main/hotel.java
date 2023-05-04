package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class hotel {

	private HashMap<String,ArrayList<Habitacion>> Habitaciones=new HashMap<String,ArrayList<Habitacion>>();//
	private HashMap<String,String> listaPersonal= new HashMap<String,String>();//hashMap donde el valor es el usuario del empleado y el valor la contrasena
	private HashMap<String,Boolean> listaPersonalAutorizado= new HashMap<String,Boolean>();//HashMap en donde tiene por llave el nombre del empelado y como valor si esta autorizado
	private HashMap<String,Calendario> listaTarifa =new HashMap<>();//Hashmap en donde la llave es el tipo y el valor otro hashmap en donde la llave es la fecha de la tarifa y el valor es una Tarif
	private HashMap<Integer,Huesped> mapaHuesped = new HashMap<>();
	private HashMap<Integer,Reserva> mapaReserva=new HashMap<>();

	public hotel(String ArchivoHabitaciones,String ArchivoMenu,String ArchivoEmpleados, String ArchivoTarifas) {
		this.CargarArchivos(ArchivoHabitaciones,ArchivoMenu,ArchivoEmpleados,ArchivoTarifas);
	}
	
	private void CargarArchivos(String ArchivoHabitaciones,String ArchivoMenu,String ArchivoEmpleados,String ArchivoTarifas) {
		String line = "";
		String line3 = "";
		String line4="";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoHabitaciones))) {
        	boolean Check1=true;

            while ((line = br.readLine()) != null) {
            	if (Check1) {
            		
            		Check1=false;
            		continue;
            	}
                
                String[] fields = line.split(cvsSplitBy);
                Habitacion HabitacionActual=new Habitacion(Integer.parseInt(fields[0]),fields[1],fields[2],Integer.parseInt(fields[3]),Boolean.parseBoolean(fields[4]),Boolean.parseBoolean(fields[5]),Boolean.parseBoolean(fields[6]));
                
                Boolean ispresenteTipo=Habitaciones.containsKey(fields[1]);
                if(ispresenteTipo) {
                	ArrayList<Habitacion> listaHabitacionesActuales=Habitaciones.get(fields[1]);
                	listaHabitacionesActuales.add(HabitacionActual);
                	Habitaciones.put(fields[1], listaHabitacionesActuales);
                	
                }else{
                    ArrayList<Habitacion> listaHabitaciones=new ArrayList<Habitacion>();
                    listaHabitaciones.add(HabitacionActual);
                    Habitaciones.put(fields[1], listaHabitaciones);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();   }
        

        
        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoEmpleados))) {
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
        
        try (BufferedReader br = new BufferedReader(new FileReader("Datos/"+ArchivoTarifas))) {
        	boolean Check4=true;
        	

            while ((line4 = br.readLine()) != null) {
            	if (Check4) {
            		
            		Check4=false;
            		continue;
            	}
                
                String[] fields = line4.split(cvsSplitBy);
                
                String DiasSemana=fields[3];
                int precio=Integer.parseInt(fields[2]);
                String tipo=fields[0];
                String[] fechasSeparadas=fields[1].split("-");//split a las fechas en incial y final
                
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            	LocalDate fechaInicio = LocalDate.parse(fechasSeparadas[0], formatter); 
            	LocalDate fechaFinal = LocalDate.parse(fechasSeparadas[1], formatter);
                
                
                Boolean isPresente= listaTarifa.containsKey(fields[0]);
            	Tarifa tarifaActual=new Tarifa(fechasSeparadas[0], fechasSeparadas[1], DiasSemana, precio, tipo);
            	if (isPresente) {//verifico si ya existe ese tipo de habtiacion
                	Calendario calenda=listaTarifa.get(tipo);
                	calenda.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
                }
                else{
                	//creo el mapa de fechas con las tarifas y agrego la info y luego lo agrego al mapa de tipos de habitaciones
                	Calendario newCalendaio=new Calendario();
                	newCalendaio.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
                	listaTarifa.put(tipo,newCalendaio);
                	
                }
                	
                
              
            }

        } catch (IOException e) {
            e.printStackTrace();           
}
        
}

	
	public HashMap<String,Boolean> consultarPersonalAutorizado(){
		return this.listaPersonalAutorizado;
	}
	
	public HashMap<String,String> consultarPersonal(){
		return this.listaPersonal;
	}
	
	public void agregarHabitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina, boolean EstaOcupada) {
		Habitacion hab=new Habitacion(id,tipo,ubicacion,capacidad,vista,balcon,cocina) ;
		
		 Boolean ispresenteTipo=Habitaciones.containsKey(tipo);
         if(ispresenteTipo) {
         	ArrayList<Habitacion> listaHabitacionesActuales=Habitaciones.get(tipo);
         	listaHabitacionesActuales.add(hab);
         	Habitaciones.put(tipo, listaHabitacionesActuales);
         	
         }else{
             ArrayList<Habitacion> listaHabitaciones=new ArrayList<Habitacion>();
             listaHabitaciones.add(hab);
             Habitaciones.put(tipo, listaHabitaciones);
         }
	}
	public void editarHabitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina) {
		 Boolean ispresenteTipo=Habitaciones.containsKey(tipo);
         if(ispresenteTipo) {
        	 ArrayList<Habitacion> listaHabitacionesActuales=Habitaciones.get(tipo);
        	 Boolean check=true;
        	 for (Habitacion habitacionActual : listaHabitacionesActuales) {
        		 int idHabitacionActual =habitacionActual.getId();
        		 if(idHabitacionActual==id) {
        			 habitacionActual.setBalcon(balcon);
        			 habitacionActual.setCapacidad(capacidad);
        			 habitacionActual.setCocina(cocina);
        			 habitacionActual.setUbicacion(ubicacion);
        			 habitacionActual.setVista(vista);
        			 check=false;
        		 }
        	 }
        	 if (check) {
        		 System.out.println("No existe esa habitacion");
        	 }
         }else{
             System.out.println("No existe ese tipo de habitacion");
         }
     
	}
	public void consultarHabitacion(int id, String tipo) {
		 Boolean ispresenteTipo=Habitaciones.containsKey(tipo);
        if(ispresenteTipo) {
       	 ArrayList<Habitacion> listaHabitacionesActuales=Habitaciones.get(tipo);
       	 Boolean check=true;
       	 for (Habitacion habitacionActual : listaHabitacionesActuales) {
       		 int idHabitacionActual =habitacionActual.getId();
       		 if(idHabitacionActual==id) {
       			 habitacionActual.consultarHabitacionPorId(id);
       		 }
        	 if (check) {
        		 System.out.println("No existe esa habitacion");
        	 }
       	 }
        }else{
            System.out.println("No existe ese tipo de habitacion");
        }
	}
	/*EMPIEZA SECCION TARIFAS
	 * 
	 */
	
	public void agregarTarifa(String Fecha, String diasDeLaSemana, int precio, String tipo)
	{
		Boolean isPresente= listaTarifa.containsKey(tipo);// ya existe ese tipo de habitacion ?
    	String[] fechasSeparadas=Fecha.split("-");//split a las fechas en incial y final
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate fechaInicio = LocalDate.parse(fechasSeparadas[0], formatter); 
    	LocalDate fechaFinal = LocalDate.parse(fechasSeparadas[1], formatter); 
    	
    	Tarifa tarifaActual=new Tarifa(fechasSeparadas[0], fechasSeparadas[1], diasDeLaSemana,precio, tipo);
    	
        if (isPresente) {//verifico si ya existe ese tipo de habtiacion
        	Calendario calenda=listaTarifa.get(tipo);
        	calenda.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
        }
        else{
        	//creo el mapa de fechas con las tarifas y agrego la info y luego lo agrego al mapa de tipos de habitaciones
        	Calendario newCalendaio=new Calendario();
        	newCalendaio.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
        	listaTarifa.put(tipo,newCalendaio);
        	
        }
	}

	public void agregarHuesped(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente=mapaHuesped.containsKey(identificacion);
		
		
		if(ispresente) {
			System.out.println("El huesped ya esta registrado");
			
		}else {
			Huesped huespedActual=new Huesped(nombre, identificacion, correo, telefono);
			
			mapaHuesped.put(identificacion, huespedActual);
			
			
		}
	}
	
	public Huesped agregarHuespedAReserva(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente=mapaHuesped.containsKey(identificacion);
		
		Huesped huespedActual=new Huesped(nombre, identificacion, correo, telefono);
		
		if(ispresente) {
			System.out.println("El huesped ya estaba registrado, se agregara la nueva info a la reserva pero mantendra la informacion original en el sistema");
	
		}else {
			
			mapaHuesped.put(identificacion, huespedActual);
			
			
		}
		return huespedActual;
	}
	
	public void editarHuesped(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente=mapaHuesped.containsKey(identificacion);
		if(ispresente) {
			Huesped huespedActual=mapaHuesped.get(identificacion);
			huespedActual.setCorreo(correo);
			huespedActual.setIdentificacion(identificacion);
			huespedActual.setNombre(nombre);
			huespedActual.setTelefono(telefono);
			System.out.println("Huesped editado correctamente");
		}else {
			System.out.println("El huesped no esta registrado");
		}
	}
	public void consultarInfoHuesped(int identificacion) {
		Boolean ispresente=mapaHuesped.containsKey(identificacion);
		if(ispresente) {
			Huesped huespedActual=mapaHuesped.get(identificacion);
			String nombreActual=huespedActual.getNombre();
			int identificacionActual=huespedActual.getIdentificacion();
			String correoActual=huespedActual.getCorreo();
			String telefonoActua=huespedActual.getTelefono();
			System.out.println("La info actual del usuario es");
			System.out.println("Nombre: "+nombreActual);
			System.out.println("Identificacion: "+identificacionActual);
			System.out.println("Correo: "+ correoActual);
			System.out.println("Telefono: "+ telefonoActua);
		}else {
			System.out.println("El huesped no esta registrado");
		}
	}
	
	public void consultarReserva(int id) {
		boolean isPresenteReserva=mapaReserva.containsKey(id);
		if(isPresenteReserva) {
			Reserva ReservaActual=mapaReserva.get(id);
			System.out.println("Check in "+ReservaActual.getFechaCheckin());
			System.out.println("Check out "+ReservaActual.getFechaCheckout());
			System.out.println("cantidadAdultos "+ReservaActual.getCantidadAdultos());
			System.out.println("cantidadNinos "+ReservaActual.getCantidadNinos());
			System.out.println("Estado "+ReservaActual.getEstado());
			System.out.println("Cantidad habtiaciones "+ReservaActual.cantidadHabitaciones());
			
		}else {
			System.out.println("Reserva no existe");
		}
	}
	
	public HashMap<Integer, Habitacion> encontrarHabitacion( boolean vista, boolean balcon, boolean cocina,String Tipo,String fechaIn,String fechaFi){
		HashMap<Integer, Habitacion> MapaRespuesta= new HashMap<>();
		
				boolean isPresente=Habitaciones.containsKey(Tipo);
				if (isPresente) {
					ArrayList<Habitacion> listaHabitaciones=Habitaciones.get(Tipo);
					for(Habitacion habitacion:listaHabitaciones) {
						
						if(habitacion.isVista()==vista) {
							MapaRespuesta.put(habitacion.getId(), habitacion);
						}
					for (Habitacion habitacion1:MapaRespuesta.values()) {
						if(habitacion1.isCocina()   ==cocina) {
							MapaRespuesta.put(habitacion1.getId(), habitacion1);
						}else {
							MapaRespuesta.remove(habitacion1.getId());
						}
					}
					for (Habitacion habitacion2:MapaRespuesta.values()) {
						if(habitacion2.isBalcon()   ==balcon) {
							MapaRespuesta.put(habitacion2.getId(), habitacion2);
						}else {
							MapaRespuesta.remove(habitacion2.getId());
						}
					for (Habitacion habitacion3:MapaRespuesta.values()) {
						HashMap<LocalDate, Integer> mapaFechas = habitacion3.GetMapaFechas();
					    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate fechaInicio=LocalDate.parse(fechaIn,formatter);
						LocalDate fechaFinal=LocalDate.parse(fechaFi,formatter);
						
				    	 LocalDate fecha = fechaInicio;
				         while (!fecha.isAfter(fechaFinal)) {
				        	 Integer isPresenteFecha=mapaFechas.get(fecha);
				        	 if(isPresenteFecha!=null) {
				        		 MapaRespuesta.put(habitacion3.getId(), habitacion3);
				        		 mapaFechas.put(fecha, 0);
				        	 }else {
				        		 MapaRespuesta.remove(habitacion3.getId());
				        	 }
				        	 
				             
				             fecha = fecha.plusDays(1);																			
				         }
				        
					}
					for (Habitacion habitacion4:MapaRespuesta.values()) {
						 
					} 
					}
					}
				}else {
					System.out.println("el tipo de habtiacion no es valdios");
				}
		






		return null;
		
	}
	public void crearReserva(String fechaCheckin, String fechaCheckout,int cantidadAdultos, int cantidadNinos){
		Reserva reservaActual = new reserva();
		
	}
}

