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
    private int Tamano=30;
    private int Cama=20;
    private Boolean Aire;
    private Boolean Calefaccion;
    private Boolean Tv;
    private Boolean Cafetera;
    private Boolean RopaYTapetes;
    private Boolean Plancha;
    private Boolean Secador;
    private Boolean VoltajeAc;
    private Boolean TomaUSBA;
    private Boolean TomaUSBC;
    private Boolean Desayuno;
    private Boolean ParqueaderoPagoH=true;
	private Boolean ParqueaderoGratisH=false;
	private Boolean Piscina=true;
	private Boolean zonasHumedas=true;
	private Boolean BQQ=true;
	private Boolean wifi=true;
	private Boolean recepcion24H=true;
	private Boolean mascotas=false;
    
    


    
    Habitacion(int id, String tipo, String ubicacion, int capacidad, boolean vista, boolean balcon, boolean cocina, boolean aire,
    		boolean calefaccion, boolean tv, boolean cafetera, boolean ropaytapetes, boolean plancha, boolean secador, boolean voltajeac,
    		boolean tomausba, boolean tomausbc, boolean desayuno) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.vista = vista;
        this.balcon = balcon;
        this.cocina = cocina;
        this.Aire = aire;
        this.Calefaccion=calefaccion;
        this.Tv = tv;
        this.Cafetera=cafetera;
        this.RopaYTapetes=ropaytapetes;
        this.Plancha=plancha;
        this.Secador=secador;
        this.VoltajeAc=voltajeac;
        this.TomaUSBA=tomausba;
        this.TomaUSBC=tomausbc;
        this.Desayuno=desayuno;
        
        
    }
    public ArrayList<Cama> getCamas() {
		return camas;
	}
	public void setCamas(ArrayList<Cama> camas) {
		this.camas = camas;
	}
	public HashMap<LocalDate, Boolean> getMapaFechasOcupadas() {
		return mapaFechasOcupadas;
	}
	public void setMapaFechasOcupadas(HashMap<LocalDate, Boolean> mapaFechasOcupadas) {
		this.mapaFechasOcupadas = mapaFechasOcupadas;
	}
	public int getTamano() {
		return Tamano;
	}
	public void setTamano(int tamano) {
		Tamano = tamano;
	}
	public int getCama() {
		return Cama;
	}
	public void setCama(int cama) {
		Cama = cama;
	}
	public Boolean getAire() {
		return Aire;
	}
	public void setAire(Boolean aire) {
		Aire = aire;
	}
	public Boolean getCalefaccion() {
		return Calefaccion;
	}
	public void setCalefaccion(Boolean calefaccion) {
		Calefaccion = calefaccion;
	}
	public Boolean getTv() {
		return Tv;
	}
	public void setTv(Boolean tv) {
		Tv = tv;
	}
	public Boolean getCafetera() {
		return Cafetera;
	}
	public void setCafetera(Boolean cafetera) {
		Cafetera = cafetera;
	}
	public Boolean getRopaYTapetes() {
		return RopaYTapetes;
	}
	public void setRopaYTapetes(Boolean ropaYTapetes) {
		RopaYTapetes = ropaYTapetes;
	}
	public Boolean getPlancha() {
		return Plancha;
	}
	public void setPlancha(Boolean plancha) {
		Plancha = plancha;
	}
	public Boolean getSecador() {
		return Secador;
	}
	public void setSecador(Boolean secador) {
		Secador = secador;
	}
	public Boolean getVoltajeAc() {
		return VoltajeAc;
	}
	public void setVoltajeAc(Boolean voltajeAc) {
		VoltajeAc = voltajeAc;
	}
	public Boolean getTomaUSBA() {
		return TomaUSBA;
	}
	public void setTomaUSBA(Boolean tomaUSBA) {
		TomaUSBA = tomaUSBA;
	}
	public Boolean getTomaUSBC() {
		return TomaUSBC;
	}
	public void setTomaUSBC(Boolean tomaUSBC) {
		TomaUSBC = tomaUSBC;
	}
	public Boolean getDesayuno() {
		return Desayuno;
	}
	public void setDesayuno(Boolean desayuno) {
		Desayuno = desayuno;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
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

	public Boolean getParqueaderoPagoH() {
		return ParqueaderoPagoH;
	}
	public void setParqueaderoPagoH(Boolean parqueaderoPagoH) {
		ParqueaderoPagoH = parqueaderoPagoH;
	}
	public Boolean getParqueaderoGratisH() {
		return ParqueaderoGratisH;
	}
	public void setParqueaderoGratisH(Boolean parqueaderoGratisH) {
		ParqueaderoGratisH = parqueaderoGratisH;
	}
	public Boolean getPiscina() {
		return Piscina;
	}
	public void setPiscina(Boolean piscina) {
		Piscina = piscina;
	}
	public Boolean getZonasHumedas() {
		return zonasHumedas;
	}
	public void setZonasHumedas(Boolean zonasHumedas) {
		this.zonasHumedas = zonasHumedas;
	}
	public Boolean getBQQ() {
		return BQQ;
	}
	public void setBQQ(Boolean bQQ) {
		BQQ = bQQ;
	}
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	public Boolean getRecepcion24H() {
		return recepcion24H;
	}
	public void setRecepcion24H(Boolean recepcion24h) {
		recepcion24H = recepcion24h;
	}
	public Boolean getMascotas() {
		return mascotas;
	}
	public void setMascotas(Boolean mascotas) {
		this.mascotas = mascotas;
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

    
    
    

