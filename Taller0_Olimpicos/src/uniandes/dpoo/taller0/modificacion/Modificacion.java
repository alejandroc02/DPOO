
package uniandes.dpoo.taller0.modificacion;

public class Modificacion
{
	
	public static void main(String[]args)
	{
		CalculadoraEstadisticas calc = LoaderOlimpicos.cargarArchivo("./data/atletas.csv");
		System.out.println(calc.paisConMasMedallistas());
	}
}