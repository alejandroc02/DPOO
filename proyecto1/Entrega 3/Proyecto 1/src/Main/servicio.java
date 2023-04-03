package Main;

public class servicio {
	private String tipoServicio;
	private int costoServicio;
	
	
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public int getCostoServicio() {
		return costoServicio;
	}
	public void setCostoServicio(int costoServicio) {
		this.costoServicio = costoServicio;
	}
	 public void registrarServicio(String tipoServicio, int costoServicio) {
	        this.tipoServicio = tipoServicio;
	        this.costoServicio = costoServicio;
	        System.out.println("El servicio ha sido registrado correctamente.");
	    }

	    public void cargarServicio() {
	        if (tipoServicio != null && costoServicio > 0) {
	            System.out.println("El tipo de servicio es: " + tipoServicio);
	            System.out.println("El costo del servicio es: $" + costoServicio);
	        } else {
	            System.out.println("No se ha registrado ningún servicio aún.");
	        }
	    }
	}
	


