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
	private boolean ocupada;
    private ArrayList<Cama> camas;
    HashMap<LocalDate, Boolean> mapaFechasOcupadas = new HashMap<>();


    
    Habitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.vista = vista;
        this.balcon = balcon;
        this.cocina = cocina;
        
    }
    public HashMap<LocalDate, Boolean> GetMapaFechas(){
    	return this.mapaFechasOcupadas;
    }
    public boolean agregarFechaReservada(LocalDate fechaInicio,LocalDate fechaFin) {
    	 LocalDate fecha = fechaInicio;
         while (!fecha.isAfter(fechaFin)) {
        	 mapaFechasOcupadas.put(fecha, true);
             fecha = fecha.plusDays(1);
         }
		 return true;
    }
    public int getId() {
		return id;
	}
	public boolean estaOcupada() {
        return ocupada; }


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

	public boolean isOcupada() {
		return ocupada;
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
    
    }

    
    
    

