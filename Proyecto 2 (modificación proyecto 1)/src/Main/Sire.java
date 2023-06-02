package Main;

import java.io.FileWriter;
import java.io.IOException;

class Sire extends gatewayPago{
	private String resultadoPago=null;
	@Override
	void realizarPago(String resNumTarjeta, String resNombre,int csvTarjeta,String idReserva,int monto) {
		try (FileWriter fileWriter = new FileWriter("Datos/Sire.txt",true)) {
			String Texto=idReserva+","+monto+","+true;
			fileWriter.write(Texto);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resultadoPago = "Pago exitoso";
	}

	@Override
	String obtenerResultadoPago() {
		// TODO Auto-generated method stub
		return resultadoPago;
	}

}
