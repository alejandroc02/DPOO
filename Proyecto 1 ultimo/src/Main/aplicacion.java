package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Persistencia.Plano;



public class aplicacion {
	private hotel hotel;
	private Boolean Autorizacion;
	private Boolean InicioSesion = false;
	private Plano plano;

	public aplicacion(){
		int op;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Digite alguna de las opciones \n0. Salir\n1. CargarArchivos\n2. Habitaciones y tarfias\n3. Servicios\n4. Restaruante\n5. Reservas\n6 Log In.\n");		
			op = sc.nextInt();
			if(op == 1) {
				CargarArchivos();
			}else if(op == 2) {
				EjecutarHabitaciones();
			}else if (op == 3) {
				
			}else if (op == 4) {
				
			}else if (op== 5) {
				
			}else if (op==6) {
				try {
					EjecutarLogIn();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}while (op != 0);
		sc.close();
	}
	
	public Boolean validarAutorizacion(String usuario) {
		HashMap<String,Boolean> Personal =hotel.consultarPersonalAutorizado();
		if (Personal.get(usuario)) {
			return true;
		}
		else {
			return false;
			}
		
	}
	
	private void CargarArchivos() {
		plano.CargarArchivos();
	}
	
	
	public void EjecutarHabitaciones() { 
		if (InicioSesion) {
			Scanner cc = new Scanner(System.in);
			System.out.println("\n1. Editar Habitacion\n2. Agregar habitacion\n3. Consultar habitaciones\n4. Camas \n5. Tarifas");
			int opcion=cc.nextInt();
			if(opcion==1) {
				if (Autorizacion) {
				System.out.println("\n Ingrese el tipo de la habitacion a editar");
				int id=cc.nextInt();
				System.out.println("\n Ingrese el id de la habitacion a editar");
				String tipo=cc.nextLine();
				System.out.println("\n Ingrese la ubicacion de la habitacion a editar(str) ");
				String ubi=cc.nextLine();
				System.out.println("\n Ingrese la capacidad de la habitacion a editar(int) ");
				int capacidad=cc.nextInt();
				System.out.println("\n Tiene balcon? a editar(bool) ");
				boolean balcon=cc.nextBoolean();
				System.out.println("\n Tiene cocina? a editar(bool) ");
				boolean cocina=cc.nextBoolean();
				System.out.println("\n Tiene vista? a editar(bool) ");
				boolean vista=cc.nextBoolean();
				hotel.editarHabitacion(id, tipo, ubi, capacidad, vista, balcon, cocina);
				System.out.println("Habitacion editada");
				}else {
					System.out.println("no tienes autorizacion");
				}
			}else if(opcion==2) {
				if(Autorizacion) {
			
				System.out.println("\n Ingrese el id de la habitacion (int) ");
				int id=cc.nextInt();
				System.out.println("\n Ingrese el tipo de la habitacion (str) ");
				String tipo=cc.nextLine();
				System.out.println("\n Ingrese la ubicacion de la habitacion (str) ");
				String ubi=cc.nextLine();
				System.out.println("\n Ingrese la capacidad de la habitacion (int) ");
				int capacidad=cc.nextInt();
				System.out.println("\n Tiene balcon? (bool) ");
				boolean balcon=cc.nextBoolean();
				System.out.println("\n Tiene cocina? (bool) ");
				boolean cocina=cc.nextBoolean();
				System.out.println("\n Tiene vista? (bool) ");
				boolean vista=cc.nextBoolean();
				hotel.agregarHabitacion(id,tipo,ubi,capacidad,vista,balcon,cocina,false);
				System.out.println("\n Habitacion agregada satisfactoriamente\n ");
				}else {
					System.out.println("no tienes autorizacion");
				}
			}else if(opcion==3) {
				System.out.println("\n Ingrese el id de la habitacion (int) ");
				int id=cc.nextInt();
				System.out.println("\n Ingrese el tipo de la habitacion (str) ");
				String tipo=cc.nextLine();
				hotel.consultarHabitacion(id, tipo);
				
			}else if(opcion==4) {
				
			}else if (opcion==5) {
				System.out.println("\n1. Agregar tarfia\n");
				int opcion2=cc.nextInt();
				if(opcion2==1) {
					System.out.println("Digite fecha asi dd/MM/yyyyInicial-dd/MM/yyyyFinal");
					String Fechas = cc.next();
					System.out.println("Digite tipo de habitacion");
					String Tipo = cc.next();
					System.out.println("Digite el precio de la tarifa");
					int Precio = cc.nextInt();
					System.out.println("Digite dias semana asi L-M-MI-J-V");
					String DiasS = cc.next();
					hotel.agregarTarifa(Fechas, DiasS, Precio, Tipo);
				}
			}else {
				
			}
		}
		else {
			System.out.println("No tiene autorizacion o no ha iniciado sesion\n");
		}
		
	}

	public void EjecutarServicios() {
		if(InicioSesion) {
			Scanner cc = new Scanner(System.in);
			System.out.println("\n1. Consultar Servicios\n2. SolicitarServicio servicio\n3. Pago");
			int opcion=cc.nextInt();
			if(opcion==1) {
				
			}else if(opcion==2) {
				
			}else if(opcion==3) {
				
			}else if(opcion==4) {
				
			}else if (opcion==5) {
		}else {
			System.out.println("No has iniciado sesion");
		}
		}
		//agregar a la reserva
		//elimanr a la reserva
		//consultar servicios y precios
		//editar sergvicios
	}
	public void EjecutarRestaruante() {
		if(InicioSesion) {
			Scanner cc = new Scanner(System.in);
			System.out.println("\n1. Consultar Menu\n2. crear pedido \n3. Agregar producto a pedido \n4.Eliminar producto a pedido \n5.Finalizar pedido\n");
			int opcion=cc.nextInt();
			if(opcion==1) {
				
			}else if(opcion==2) {
				
			}else if(opcion==3) {
				
			}else if(opcion==4) {
				
			}else if (opcion==5) {
		}else {
			System.out.println("No has iniciado sesion");
		}
		}
	}
	public void EjecutarReservas() {
		if(InicioSesion) {
			Scanner cc = new Scanner(System.in);
			System.out.println("\n1. Consultar Reserva\n2. Crear reserva \n3. Check in\n3. Check out");
			int opcion=cc.nextInt();
			if(opcion==1) {
				System.out.println("Ingrese id de la rserva");
				int idReserva=cc.nextInt();
				hotel.consultarReserva(idReserva);
				
			}else if(opcion==2) {
				Scanner scanner = new Scanner(System.in);

		        // Pedir la fecha de check-in
		        System.out.print("Ingrese la fecha de check-in (formato dd/MM/yyyy): ");
		        String fechaCheckin = scanner.nextLine();

		        // Pedir la fecha de check-out
		        System.out.print("Ingrese la fecha de check-out (formato dd/MM/yyyy): ");
		        String fechaCheckout = scanner.nextLine();

		        // Pedir la cantidad de adultos
		        System.out.print("Ingrese la cantidad de adultos: ");
		        int cantidadAdultos = scanner.nextInt();
		        

		        // Pedir la cantidad de niños
		        System.out.print("Ingrese la cantidad de niños: ");
		        int cantidadNinos = scanner.nextInt();
		        
		        System.out.print("cuantas habitaciones desea?");
		        int cantidadHabtiaciones = scanner.nextInt();
		        int i=0;
		        ArrayList<Habitacion> HabitacionesVaforables=new ArrayList<Habitacion>();
		        while (i<cantidadHabtiaciones) {
		        	System.out.println("De que tipo quiere la habitacion "+i+" ?");
		        	String tipo = scanner.next();
		        
		        	System.out.print("¿	Quiere vista? (true/false): ");
		        	boolean vista = scanner.nextBoolean();

		        	System.out.print("¿Quiere balcón? (true/false): ");
		        	boolean balcon = scanner.nextBoolean();

		        	System.out.print("¿Quiere cocina? (true/false): ");
		        	boolean cocina = scanner.nextBoolean();
		        	
		        	HashMap<Integer, Habitacion> MapaRespuesta=hotel.encontrarHabitacion( vista, balcon, cocina, tipo, fechaCheckin, fechaCheckout);
		        	
		        	for (Habitacion habitaion:MapaRespuesta.values()) {
		        		HabitacionesVaforables.add(habitaion);
		        	}
		        	
		        int w=0;
		        int  capacidadTotalHabitaciones=0;
		        while (w<HabitacionesVaforables.size()) {
		        	Habitacion HabitacionActual=HabitacionesVaforables.get(w);
		        	int capacidadHab=HabitacionActual.getCapacidad();
		        	capacidadTotalHabitaciones+=capacidadHab;
		        }
		
		

		        
		        }
		        
		        int totalPersonas=cantidadNinos+cantidadAdultos;
		        int x=0;
		        HashMap<Integer,Huesped> MapaHuesped=new HashMap<>();
		        while(x <= totalPersonas) {
		        	
		        	System.out.print("Ingrese la identificación: ");
		            int identificacion = scanner.nextInt();
		            scanner.nextLine(); // Consumir el salto de línea después de leer un entero
		            
		            System.out.print("Ingrese el nombre: ");
		            String nombre = scanner.nextLine();

		            System.out.print("Ingrese el correo: ");
		            String correo = scanner.nextLine();

		            System.out.print("Ingrese el teléfono: ");
		            String telefono = scanner.nextLine();

		            Huesped huespedActual=hotel.agregarHuespedAReserva(nombre, identificacion, correo, telefono);
		            MapaHuesped.put(huespedActual.getIdentificacion(), huespedActual);
		        	
		        	
		        	x+=1;
		        }
		        
		        
			}else if(opcion==3) {
				
			}else if(opcion==4) {
				
			}else if (opcion==5) {
		}else {
			System.out.println("No has iniciado sesion");
		}
		}
		
	}
	
	public void EjecutarLogIn() throws Exception {
		Scanner cc = new Scanner(System.in);
		System.out.println("Digite su usuario\n");
		String usuario = cc.nextLine();
		System.out.println("Digite su contraseña\n");
		String contra = cc.nextLine();
		
		HashMap<String,String>Personal = hotel.consultarPersonal();
		
		String Validacion=Personal.get(usuario);
		
		if (Validacion.equals(null)) {
			
			throw new Exception("Usuario o contraseña invalidos\n");
			
			
		}
		else if (Validacion.equals(contra)) {
			InicioSesion=true;
			Autorizacion = validarAutorizacion(usuario);
			System.out.println("Inicio sesion correctamente\n");
			
		}
		else {
			
			throw new Exception("Usuario o contraseña invalidos\n");
		}
		
	}
	
	
	public static void main(String[] args) {
		new aplicacion();
	}
}
