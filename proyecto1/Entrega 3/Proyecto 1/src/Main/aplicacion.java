package Main;

import java.util.HashMap;
import java.util.Scanner;



public class aplicacion {
	private hotel hotel;
	private Boolean Autorizacion;
	private Boolean InicioSesion = false;

	public aplicacion(){
		int op;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Digite alguna de las opciones \n0. Salir\n1. CargarArchivos\n2. Habitaciones y tarfias\n3. Servicios\n4. Restaruante\n5. Reservas\n6 Log In.\n");		
			op = sc.nextInt();
			if(op == 1) {
				CargarArchivos();
			}else if(op == 2) {
				
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
		String ArchivoHabitaciones="InventarioHabitaciones.csv";
		String ArchivoMenu="Empleados.csv";
		String ArchivoEmpleados="Menu.csv";
		this.hotel=new hotel(ArchivoHabitaciones,ArchivoMenu,ArchivoEmpleados);
		
	}
	public void EjecutarHabitaciones() { 
		if (InicioSesion && Autorizacion) {
			Scanner cc = new Scanner(System.in);
			System.out.println("\n1. Editar Habitacion\n2. Agregar habitacion\n3. Consultar habitaciones\n4. Camas \n5. Tarifas");
			int opcion=cc.nextInt();
			if(opcion==1) {
				System.out.println("\n Ingrese el id de la habitacion a editar");
			}else if(opcion==2) {
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
				
			}else if(opcion==3) {
				
			}else if(opcion==4) {
				
			}else if (opcion==5) {
				System.out.println("\n1. Agregar tarifa\n2. Editar tarfia\n3. Eliminar tarifa");
				int opcion2=cc.nextInt();
				if(opcion2==1) {
					System.out.println("\n Ingrese el id de la habitacion a editar");
				}else if(opcion2==2) {
					
				}else if(opcion2==3) {
					
				}else {
					
				}
			}else {
				
			}
		}
		else {
			System.out.println("No tiene autorizacion o no ha iniciado sesion\n");
		}
		
	}
	public void EjecutarTarifas() {
		
	}
	public void EjecutarServicios() {
		
	}
	public void EjecutarRestaruante() {
		
	}
	public void EjecutarReservas() {
		
		
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
