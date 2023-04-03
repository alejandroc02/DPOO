package Main;

public class Huesped {
    private String nombre;
    private String identificacion;
    private String correo;
    private String telefono;
    
    public Huesped(String nombre, String identificacion, String correo, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public void consultarHuesped() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Identificación: " + this.identificacion);
        System.out.println("Correo electrónico: " + this.correo);
        System.out.println("Teléfono: " + this.telefono);
    }
}

