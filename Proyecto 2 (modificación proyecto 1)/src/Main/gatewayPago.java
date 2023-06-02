package Main;


public abstract class gatewayPago {
	
	abstract void realizarPago(String resNumTarjeta, String resNombre,int csvTarjeta,String idReserva,int monto);
    abstract Boolean obtenerResultadoPago();
    
    
   
    	
}
