package Main;

import java.util.Random;

public abstract class gatewayPago {
	
	abstract void realizarPago(int resNumTarjeta, String resNombre,int csvTarjeta,String idReserva,int monto);
    abstract String obtenerResultadoPago();
    
    
   
    	
    }
}
