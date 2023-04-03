package Main;
import java.util.ArrayList;

public class Habitacion {
    private int id;
    private String tipo;
    private String ubicacion;
    private int capacidad;
    private boolean vista;
    private boolean balcon;
    private boolean cocina;
    private ArrayList<Cama> camas;
    private Tarifa tarifa;
    
    Habitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina, boolean EstaOcupada) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.vista = vista;
        this.balcon = balcon;
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
    
    public void editarHabitacion() {
     
        }
    }

