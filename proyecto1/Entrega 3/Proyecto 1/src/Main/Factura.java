package logica;

public class Factura {
	private int id;
	private String servicio;
	private double total;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Factura(int id, String servicio, int total) {
		this.id = id;
		this.servicio = servicio;
		this.total = total;
	}
	
	 public void crearFactura(int id, String servicio, double total) {
	        this.id = id;
	        this.servicio = servicio;
	        this.total = total;
	        System.out.println("La factura ha sido creada correctamente.");
	    }

	    public void consultarFactura() {
	        if (id > 0 && servicio != null && total > 0) {
	            System.out.println("Identificador: " + id);
	            System.out.println("Servicio: " + servicio);
	            System.out.println("Total: $" + total);
	        } else {
	            System.out.println("No se ha creado ninguna factura aún.");
	        }
	    }

	    public void finalizarFactura() {
	        System.out.println("Factura finalizada. Total a pagar: $" + total);
	    }
	}
	







