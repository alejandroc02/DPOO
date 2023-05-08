package Main;

public class Huesped {
    private String nombre;
    private int identificacion;
    private String correo;
    private String telefono;
    
    public Huesped(String nombre, int identificacion, String correo, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public int getIdentificacion() {
		return identificacion;
	}


	public void consultarHuesped() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Identificación: " + this.identificacion);
        System.out.println("Correo electrónico: " + this.correo);
        System.out.println("Teléfono: " + this.telefono);
    }
}

