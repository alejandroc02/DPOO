package Main;

public class Tarifa {
    private String fechaInicio;
    private String fechaFinal;
    private String diasDeLaSemana;
    private int precio;
    private String tipo;
    
    
    public Tarifa(String fechaInicio, String fechaFinal, String diasDeLaSemana, int precio, String tipo) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasDeLaSemana = diasDeLaSemana;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    public void SetTarifa(String fechaInicio, String fechaFinal, String diasDeLaSemana, int precio, String tipo) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasDeLaSemana = diasDeLaSemana;
        this.precio = precio;
        this.tipo = tipo;
    }

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public String getDiasDeLaSemana() {
		return diasDeLaSemana;
	}

	public int getPrecio() {
		return precio;
	}
    
   
    
    
}

