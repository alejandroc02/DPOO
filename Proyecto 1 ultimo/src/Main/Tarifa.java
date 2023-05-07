package Main;

public class Tarifa {
    private String fechaInicio;
    private String fechaFinal;
    private String diasDeLaSemana;
    private int precio;
    private String tipo;
    private String Id;
    
    
    public Tarifa(String Id,String fechaInicio, String fechaFinal, String diasDeLaSemana, int precio, String tipo) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.diasDeLaSemana = diasDeLaSemana;
        this.precio = precio;
        this.tipo = tipo;
        this.Id=Id;
    }
    
    public void SetTarifa(String Id,String fechaInicio, String fechaFinal, String diasDeLaSemana, int precio, String tipo) {
    	boolean CheckId=this.esId(Id);
    	if(CheckId){
	        this.fechaInicio = fechaInicio;
	        this.fechaFinal = fechaFinal;
	        this.diasDeLaSemana = diasDeLaSemana;
	        this.precio = precio;
	        this.tipo = tipo;
    	}else {
    		System.out.println("Id no coincide");
    	}
    }
    
    public boolean esId(String Id) {
    	if(this.Id.equals(Id)) {
    		return true;
    	}else {
    		return false;
    	}
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

