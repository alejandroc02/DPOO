package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class hotel {

	private static final String String = null;
	private HashMap<String, ArrayList<Habitacion>> Habitaciones = new HashMap<String, ArrayList<Habitacion>>();//
	private HashMap<String, String> listaPersonal = new HashMap<String, String>();// hashMap donde el valor es el
																					// usuario del empleado y el valor
																					// la contrasena
	private HashMap<String, Boolean> listaPersonalAutorizado = new HashMap<String, Boolean>();// HashMap en donde tiene
																								// por llave el nombre
																								// del empelado y como
																								// valor si esta
																								// autorizado
	private HashMap<String, Calendario> listaTarifa = new HashMap<>();// Hashmap en donde la llave es el tipo y el valor
																		// otro hashmap en donde la llave es la fecha de
																		// la tarifa y el valor es una Tarif
	private HashMap<Integer, Huesped> mapaHuesped = new HashMap<>();
	private HashMap<String, Reserva> mapaReserva = new HashMap<>();
	private servicio Servicio = new servicio();
	private restaurante Restaurante;
	public hotel(String ArchivoHabitaciones, String ArchivoMenu, String ArchivoEmpleados, String ArchivoTarifas,
			String ArchivoServicios) {
		this.CargarArchivos(ArchivoHabitaciones, ArchivoMenu, ArchivoEmpleados, ArchivoTarifas, ArchivoServicios);
		this.Restaurante=new restaurante(ArchivoMenu);

	}

	private void CargarArchivos(String ArchivoHabitaciones, String ArchivoMenu, String ArchivoEmpleados,
			String ArchivoTarifas, String ArchivoServicios) {
		String line = "";
		String line3 = "";
		String line4 = "";
		String line5 = "";
		String cvsSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader("Datos/" + ArchivoHabitaciones))) {
			boolean Check1 = true;

			while ((line = br.readLine()) != null) {
				if (Check1) {

					Check1 = false;
					continue;
				}

				String[] fields = line.split(cvsSplitBy);
				Habitacion HabitacionActual = new Habitacion(Integer.parseInt(fields[0]), fields[1], fields[2],
						Integer.parseInt(fields[3]), Boolean.parseBoolean(fields[4]), Boolean.parseBoolean(fields[5]),
						Boolean.parseBoolean(fields[6]));

				Boolean ispresenteTipo = Habitaciones.containsKey(fields[1]);
				if (ispresenteTipo) {
					ArrayList<Habitacion> listaHabitacionesActuales = Habitaciones.get(fields[1]);
					listaHabitacionesActuales.add(HabitacionActual);
					Habitaciones.put(fields[1], listaHabitacionesActuales);

				} else {
					ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
					listaHabitaciones.add(HabitacionActual);
					Habitaciones.put(fields[1], listaHabitaciones);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("Datos/" + ArchivoEmpleados))) {
			boolean Check3 = true;

			while ((line3 = br.readLine()) != null) {
				if (Check3) {

					Check3 = false;
					continue;
				}

				String[] fields = line3.split(cvsSplitBy);

				listaPersonal.put(fields[0], fields[1]);
				listaPersonalAutorizado.put(fields[0], Boolean.parseBoolean(fields[2]));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("Datos/" + ArchivoTarifas))) {
			boolean Check4 = true;

			while ((line4 = br.readLine()) != null) {
				if (Check4) {

					Check4 = false;
					continue;
				}

				String[] fields = line4.split(cvsSplitBy);
				if (fields.length < 4) {
					continue;
				}

				String DiasSemana = fields[3];
				int precio = Integer.parseInt(fields[2]);
				String tipo = fields[0];
				String[] fechasSeparadas = fields[1].split("-");// split a las fechas en incial y final

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaInicio = LocalDate.parse(fechasSeparadas[0], formatter);
				LocalDate fechaFinal = LocalDate.parse(fechasSeparadas[1], formatter);
				String id = fields[4];

				Boolean isPresente = listaTarifa.containsKey(fields[0]);
				Tarifa tarifaActual = new Tarifa(id, fechasSeparadas[0], fechasSeparadas[1], DiasSemana, precio, tipo);
				if (isPresente) {// verifico si ya existe ese tipo de habtiacion
					Calendario calenda = listaTarifa.get(tipo);
					calenda.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
					listaTarifa.put(tipo, calenda);
				} else {
					// creo el mapa de fechas con las tarifas y agrego la info y luego lo agrego al
					// mapa de tipos de habitaciones
					Calendario newCalendaio = new Calendario();
					newCalendaio.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
					listaTarifa.put(tipo, newCalendaio);

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(new FileReader("Datos/" + ArchivoServicios))) {
			boolean Check5 = true;

			while ((line5 = br.readLine()) != null) {
				if (Check5) {

					Check5 = false;
					continue;
				}

				String[] fields = line5.split(cvsSplitBy);
				if (fields.length < 2) {
					continue;
				}

				String nombre = fields[0];
				int precio = Integer.parseInt(fields[1]);
				Servicio.agregarServicio(nombre, precio);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public HashMap<String, Boolean> consultarPersonalAutorizado() {
		return this.listaPersonalAutorizado;
	}

	public HashMap<String, String> consultarPersonal() {
		return this.listaPersonal;
	}

	public void agregarHabitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon,
			boolean cocina, boolean EstaOcupada) {
		Habitacion hab = new Habitacion(id, tipo, ubicacion, capacidad, vista, balcon, cocina);

		Boolean ispresenteTipo = Habitaciones.containsKey(tipo);
		if (ispresenteTipo) {
			ArrayList<Habitacion> listaHabitacionesActuales = Habitaciones.get(tipo);
			listaHabitacionesActuales.add(hab);
			Habitaciones.put(tipo, listaHabitacionesActuales);

		} else {
			ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
			listaHabitaciones.add(hab);
			Habitaciones.put(tipo, listaHabitaciones);
		}
	}

	public Boolean editarHabitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon,
			boolean cocina) {
		Boolean ispresenteTipo = Habitaciones.containsKey(tipo);
		if (ispresenteTipo) {
			ArrayList<Habitacion> listaHabitacionesActuales = Habitaciones.get(tipo);
			for (Habitacion habitacionActual : listaHabitacionesActuales) {
				int idHabitacionActual = habitacionActual.getId();
				if (idHabitacionActual == id) {
					habitacionActual.setBalcon(balcon);
					habitacionActual.setCapacidad(capacidad);
					habitacionActual.setCocina(cocina);
					habitacionActual.setUbicacion(ubicacion);
					habitacionActual.setVista(vista);
					return true;
				}
			}
		}
		return false;

	}


	public Habitacion consultarhabitacion(int id, String tipo) {
		Boolean ispresenteTipo=Habitaciones.containsKey(tipo);
	   if(ispresenteTipo) {
		   ArrayList<Habitacion> listaHabitacionesActuales=Habitaciones.get(tipo);
		   for (Habitacion habitacionActual : listaHabitacionesActuales) {
			   int idHabitacionActual =habitacionActual.getId();
			   if(idHabitacionActual==id) {
				   return habitacionActual;
			   }
		   }
	   }
	   return null;

	   
   }

	public String consultarHabitacion(int id, String tipo) {
		Boolean ispresenteTipo = Habitaciones.containsKey(tipo);
		if (ispresenteTipo) {
			ArrayList<Habitacion> listaHabitacionesActuales = Habitaciones.get(tipo);
			for (Habitacion habitacionActual : listaHabitacionesActuales) {
				int idHabitacionActual = habitacionActual.getId();
				if (idHabitacionActual == id) {
					String cadena = "Ubicación: " + habitacionActual.getUbicacion() + "\n" + "Tipo: "
							+ habitacionActual.getTipo() + "\n" +
							"Capacidad: " + java.lang.String.valueOf(habitacionActual.getCapacidad()) + "\n" + "Vista: "
							+ java.lang.String.valueOf(habitacionActual.isVista()) + "\n" + "Balcon: "
							+ java.lang.String.valueOf(habitacionActual.isBalcon()) + "\n" + "Cocina: "
							+ java.lang.String.valueOf(habitacionActual.isCocina());
					return cadena;
				}
			}
		}
		return null;

        }

		private ArrayList<Habitacion> habitaciones;
    public boolean consultarOcupacion(int id) {
        for (Habitacion habitacion : habitaciones) {
             if (habitacion.getId() == id) {
                 return habitacion.estaOcupada();
                }
            }
            // si no se encuentra la habitación con el ID especificado, se devuelve false
            return false;
	}
	/*
	 * EMPIEZA SECCION TARIFAS
	 * 
	 */

	public void agregarTarifa(String id, String Fecha, String diasDeLaSemana, int precio, String tipo) {

		Boolean isPresente = listaTarifa.containsKey(tipo);// ya existe ese tipo de habitacion ?
		String[] fechasSeparadas = Fecha.split("-");// split a las fechas en incial y final
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaInicio = LocalDate.parse(fechasSeparadas[0], formatter);
		LocalDate fechaFinal = LocalDate.parse(fechasSeparadas[1], formatter);

		Tarifa tarifaActual = new Tarifa(id, fechasSeparadas[0], fechasSeparadas[1], diasDeLaSemana, precio, tipo);

		if (isPresente) {// verifico si ya existe ese tipo de habtiacion
			Calendario calenda = listaTarifa.get(tipo);
			calenda.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
		} else {
			// creo el mapa de fechas con las tarifas y agrego la info y luego lo agrego al
			// mapa de tipos de habitaciones
			Calendario newCalendaio = new Calendario();
			newCalendaio.registrarEvento(tarifaActual, fechaInicio, fechaFinal);
			listaTarifa.put(tipo, newCalendaio);

		}
	}

	public Boolean eliminarTarifa(String id, String Fecha, String tipo) {
		Boolean isPresente = listaTarifa.containsKey(tipo);// ya existe ese tipo de habitacion ?
		String[] fechasSeparadas = Fecha.split("-");// split a las fechas en incial y final
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaInicio = LocalDate.parse(fechasSeparadas[0], formatter);
		LocalDate fechaFinal = LocalDate.parse(fechasSeparadas[1], formatter);

		if (isPresente) {// verifico si ya existe ese tipo de habtiacion
			Calendario calenda = listaTarifa.get(tipo);
			calenda.eliminarEvento(id, fechaInicio, fechaFinal);
			return true;
		} else {
			// creo el mapa de fechas con las tarifas y agrego la info y luego lo agrego al
			// mapa de tipos de habitaciones
			return false;

		}
	}

	public void agregarHuesped(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente = mapaHuesped.containsKey(identificacion);

		if (ispresente) {
			System.out.println("El huesped ya esta registrado");

		} else {
			Huesped huespedActual = new Huesped(nombre, identificacion, correo, telefono);

			mapaHuesped.put(identificacion, huespedActual);

		}
	}

	public Huesped agregarHuespedAReserva(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente = mapaHuesped.containsKey(identificacion);

		Huesped huespedActual = new Huesped(nombre, identificacion, correo, telefono);

		if (ispresente) {
			System.out.println(
					"El huesped ya estaba registrado, se agregara la nueva info a la reserva pero mantendra la informacion original en el sistema");

		} else {

			mapaHuesped.put(identificacion, huespedActual);

		}
		return huespedActual;
	}

	public void editarHuesped(String nombre, int identificacion, String correo, String telefono) {
		Boolean ispresente = mapaHuesped.containsKey(identificacion);
		if (ispresente) {
			Huesped huespedActual = mapaHuesped.get(identificacion);
			huespedActual.setCorreo(correo);
			huespedActual.setIdentificacion(identificacion);
			huespedActual.setNombre(nombre);
			huespedActual.setTelefono(telefono);
			System.out.println("Huesped editado correctamente");
		} else {
			System.out.println("El huesped no esta registrado");
		}
	}

	public void consultarInfoHuesped(int identificacion) {
		Boolean ispresente = mapaHuesped.containsKey(identificacion);
		if (ispresente) {
			Huesped huespedActual = mapaHuesped.get(identificacion);
			String nombreActual = huespedActual.getNombre();
			int identificacionActual = huespedActual.getIdentificacion();
			String correoActual = huespedActual.getCorreo();
			String telefonoActua = huespedActual.getTelefono();
			System.out.println("La info actual del usuario es");
			System.out.println("Nombre: " + nombreActual);
			System.out.println("Identificacion: " + identificacionActual);
			System.out.println("Correo: " + correoActual);
			System.out.println("Telefono: " + telefonoActua);
		} else {
			System.out.println("El huesped no esta registrado");
		}
	}

	public void consultarReserva(int id) {
		boolean isPresenteReserva = mapaReserva.containsKey(id);
		if (isPresenteReserva) {
			Reserva ReservaActual = mapaReserva.get(id);
			System.out.println("Check in " + ReservaActual.getFechaCheckin());
			System.out.println("Check out " + ReservaActual.getFechaCheckout());
			System.out.println("cantidadAdultos " + ReservaActual.getCantidadAdultos());
			System.out.println("cantidadNinos " + ReservaActual.getCantidadNinos());
			System.out.println("Estado " + ReservaActual.getEstado());
			System.out.println("Cantidad habtiaciones " + ReservaActual.cantidadHabitaciones());

		} else {
			System.out.println("Reserva no existe");
		}
	}

	public HashMap<Integer, Habitacion> encontrarHabitacion(boolean vista, boolean balcon, boolean cocina, String Tipo,
			String fechaIn, String fechaFi) {
		HashMap<Integer, Habitacion> MapaRespuesta = new HashMap<>();

		boolean isPresente = Habitaciones.containsKey(Tipo);
		if (isPresente) {
			ArrayList<Habitacion> listaHabitaciones = Habitaciones.get(Tipo);
			for (Habitacion habitacion : listaHabitaciones) {

				if (habitacion.isVista() == vista) {
					MapaRespuesta.put(habitacion.getId(), habitacion);
				}
				for (Habitacion habitacion1 : MapaRespuesta.values()) {
					if (habitacion1.isCocina() == cocina) {
						MapaRespuesta.put(habitacion1.getId(), habitacion1);
					} else {
						MapaRespuesta.remove(habitacion1.getId());
					}
				}
				for (Habitacion habitacion2 : MapaRespuesta.values()) {
					if (habitacion2.isBalcon() == balcon) {
						MapaRespuesta.put(habitacion2.getId(), habitacion2);
					} else {
						MapaRespuesta.remove(habitacion2.getId());
					}
					for (Habitacion habitacion3 : MapaRespuesta.values()) {
						HashMap<LocalDate, Integer> mapaFechas = habitacion3.GetMapaFechas();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate fechaInicio = LocalDate.parse(fechaIn, formatter);
						LocalDate fechaFinal = LocalDate.parse(fechaFi, formatter);

						LocalDate fecha = fechaInicio;
						while (!fecha.isAfter(fechaFinal)) {
							Integer isPresenteFecha = mapaFechas.get(fecha);
							if (isPresenteFecha != null) {
								MapaRespuesta.put(habitacion3.getId(), habitacion3);
								mapaFechas.put(fecha, 0);
							} else {
								MapaRespuesta.remove(habitacion3.getId());
							}

							fecha = fecha.plusDays(1);
						}

					}
					for (Habitacion habitacion4 : MapaRespuesta.values()) {

					}
				}
			}
		} else {
			System.out.println("el tipo de habtiacion no es valdios");
		}

		return null;

	}

	public HashMap<Integer, Habitacion> encontrarHabitacionesIndivudales(int cantidadHabitaciones, int totalPersonas,
			HashMap<Integer, Habitacion> mapaRespuesta) {
		HashMap<Integer, Habitacion> mapaRespuesta1 = new HashMap<Integer, Habitacion>();
		int capacidadTotalHabitaciones = 0;
		int i = 0;

		// Iterar mientras el número de habitaciones requeridas no se haya satisfecho
		while (i < cantidadHabitaciones) {
			// Si solo se requiere una habitación
			if (cantidadHabitaciones == 1) {
				Habitacion habitacionActual = mapaRespuesta1.get(i);
				int capacidadHabitacion = habitacionActual.getCapacidad();

				// Si la capacidad de la habitación es suficiente, agregarla al mapaRespuesta
				if (capacidadHabitacion >= totalPersonas) {
					mapaRespuesta1.put(habitacionActual.getId(), habitacionActual);
					return mapaRespuesta1; // Devolver mapaRespuesta y terminar la función
				}
				// Si se requieren más de una habitación
			} else {
				Habitacion habitacion1 = mapaRespuesta1.get(i);
				Habitacion habitacion2 = mapaRespuesta1.get(i + 1);
				capacidadTotalHabitaciones = habitacion1.getCapacidad() + habitacion2.getCapacidad();

				// Si la capacidad total de las habitaciones es suficiente, agregarlas al
				// mapaRespuesta
				if (capacidadTotalHabitaciones >= totalPersonas) {
					mapaRespuesta1.put(habitacion1.getId(), habitacion1);
					mapaRespuesta1.put(habitacion2.getId(), habitacion2);
					return mapaRespuesta1; // Devolver mapaRespuesta y terminar la función
				}
			}
			i++; // Incrementar el índice de la habitación actual
		}
		return mapaRespuesta1; // Devolver mapaRespuesta aunque no se hayan satisfecho todas las habitaciones
	}

	public HashMap<Integer, Habitacion> encontrarHabitaciones(ArrayList<Habitacion> HabitacionesVaforables,
			int cantidadHabitaciones, int totalPersonas) {
		int w = 0;
		int capacidadTotalHabitaciones = 0;
		boolean encontrado = false;
		HashMap<Integer, Habitacion> MapaRespuesta = new HashMap<Integer, Habitacion>();
		while (w <= HabitacionesVaforables.size() - cantidadHabitaciones && !encontrado) {
			capacidadTotalHabitaciones = 0;
			for (int i = w; i < w + cantidadHabitaciones; i++) {
				Habitacion habitacionActual = HabitacionesVaforables.get(i);
				capacidadTotalHabitaciones += habitacionActual.getCapacidad();
			}
			if (capacidadTotalHabitaciones >= totalPersonas) {
				MapaRespuesta.clear();
				for (int i = w; i < w + cantidadHabitaciones; i++) {
					Habitacion habitacionActual = HabitacionesVaforables.get(i);
					MapaRespuesta.put(habitacionActual.getId(), habitacionActual);
				}
				encontrado = true;
			} else {
				w++;
			}
		}
		return MapaRespuesta;
	}

	public int calcularReserva(String tipo, LocalDate fechaCheckin, LocalDate fechaCheckout) {

		Calendario calendario = listaTarifa.get(tipo);

		List<Tarifa> ListaTarifas = calendario.consultarEventosEntreF(fechaCheckin, fechaCheckout);
		int respuesta = 0;
		for (Tarifa tarifaActual : ListaTarifas) {
			int precioTarifa = tarifaActual.getPrecio();
			respuesta += precioTarifa;
		}

		return respuesta;
	}

	public void crearReserva(String idReserva, String fechaCheckin, String fechaCheckout,
			HashMap<Integer, Habitacion> mapaHabitaciones,
			int cantidadAdultos, int cantidadNinos, HashMap<Integer, Huesped> mapaHuespedes) {
		// Reserva reservaActual = new Reserva();//AQUIIIVOY

	}
	// podemos agregar funcion para que cargue un archivo
	// la funcion consultarServicios podria retornar el mapa si es necesario, es
	// facil el arrreglo

	public void agregarServicio(String nombre, int precio) {
		Servicio.agregarServicio(nombre, precio);

	}

	public void consultarServicios() {
		Servicio.getServicios();

	}

	public void eleminarServicio(String nombre) {
		Servicio.eliminarServicio(nombre);
	}

	public Factura solicitarNuevoServicio(String nombre) {
		Factura factura = new Factura();
		factura.agregarServicio(nombre);
		boolean Check = false;
		while (!Check) {
			Scanner cc = new Scanner(System.in);
			System.out.println("Desea solicitar otro servicio ?(SI/NO)");
			String respuesta = cc.next();
			if (respuesta.equals("SI")) {
				System.out.println("Nombre Servicio");
				String nombreServicio = cc.next();
				factura.agregarServicio(nombreServicio);
			} else if (respuesta.equals("NO")) {
				Check = true;
				cc.close();
			} else { // aqui se puede sermas especificio equaslto.NO
				System.out.println("Opcion no valida");
				;
			}
		}
		return factura;

	}

	public int obtenerTotal(Factura factura) {
		return factura.obtenerTotal();
	}

	public void PagoFactura(String idReserva, Factura factura) {
		Scanner cc = new Scanner(System.in);
		int total = this.obtenerTotal(factura);
		System.out.println("El total a pagar es " + total);
		System.out.println("Desea Pagar ya o al hacer checkOut? (YA/CHECK)");
		String respuesta = cc.next();
		Reserva reservaActual = mapaReserva.get(idReserva);

		if (respuesta.equals("YA")) {
			factura.setEstaPago();
			reservaActual.agregarFactura(factura);
			System.out.println("Se ha pagado con exito la factura");

		} else if (respuesta.equals("CHECK")) {
			reservaActual.agregarFactura(factura);

		} else {
			System.out.println("Opcion no valida");
			System.out.println("Se Pagara a la hora de hacer checkout");
		}

	}
	public void AgregarProducto(String nombre, int precio, boolean Habitacion) {
		Restaurante.AgregarProducto(nombre, precio, Habitacion);
	}
	public void EliminarProducto(String nombre) {
		Restaurante.EliminarProducto(nombre);
	}
	public void EliminarServicio(String nombre) {
		Servicio.eliminarServicio(nombre);
	}
}
