package Main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Habitacion {
    private int id;
    private String tipo;
    private String ubicacion;
    private int capacidad;
    private boolean vista;
    private boolean balcon;
    private boolean cocina;
    private ArrayList<Cama> camas;
    HashMap<LocalDate, Integer> mapaFechas = new HashMap<>();


    
    Habitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.vista = vista;
        this.balcon = balcon;
        this.cocina = cocina;
        
    }
    public HashMap<LocalDate, Integer> GetMapaFechas(){
    	return this.mapaFechas;
    }
    public void agregarFechaReservada(LocalDate fechaInicio,LocalDate fechaFin) {
    	 LocalDate fecha = fechaInicio;
         while (!fecha.isAfter(fechaFin)) {
             mapaFechas.put(fecha, 0);
             fecha = fecha.plusDays(1);
         }
    }
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public boolean isVista() {
		return vista;
	}


	public void setVista(boolean vista) {
		this.vista = vista;
	}


	public boolean isBalcon() {
		return balcon;
	}


	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}


	public boolean isCocina() {
		return cocina;
	}


	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}


	public void consultarHabitacionPorId(int id) {
        if (this.id == id) {
            System.out.println("Habitación encontrada:");
            System.out.println("ID: " + this.id);
            System.out.println("Tipo: " + this.tipo);
            System.out.println("Ubicación: " + this.ubicacion);
            System.out.println("Capacidad: " + this.capacidad);
            System.out.println("Vista: " + (this.vista ? "Sí" : "No"));
            System.out.println("Balcón: " + (this.balcon ? "Sí" : "No"));
            System.out.println("Cocina: " + (this.cocina ? "Sí" : "No"));
			
            System.out.println("Camas:");
        } else {
            System.out.println("No se encontró ninguna habitación con el ID " + id);
        }
    }
    
    
    }

