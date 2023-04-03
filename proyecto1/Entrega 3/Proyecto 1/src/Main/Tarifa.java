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
    
    public void GetTarifa()
    
    public void eliminarTarifa() {
        this.fechaInicio = null;
        this.fechaFinal = null;
        this.diasDeLaSemana = null;
        this.precio = 0;
        this.tipo = null;
    }
}

