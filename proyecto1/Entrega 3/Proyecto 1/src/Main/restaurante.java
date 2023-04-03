package logica;

public class restaurante {
	private String menu;
	private String lugarConsumo;
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getLugarConsumo() {
		return lugarConsumo;
	}
	public void setLugarConsumo(String lugarConsumo) {
		this.lugarConsumo = lugarConsumo;
	}
	
	 public void cargarMenu(String menu) {
	        this.menu = menu;
	        System.out.println("El menú ha sido cargado correctamente.");
	    }

	    public void consultarMenu() {
	        if (menu != null) {
	            System.out.println("El menú del restaurante es:");
	            System.out.println(menu);
	            System.out.println("El lugar de consumo es: " + lugarConsumo);
	        } else {
	            System.out.println("No se ha cargado ningún menú aún.");
	        }
	    }

	    }
	
	