/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de datos
 * Laboratorio #7
 * @author Freddy José Ruíz 14592
 *
 */
public class main{

	public static void main(String[] args){
		Lectura traductor = new Lectura();
		System.out.println ("BIENVENIDO AL DICCIONARIO INGLES-ESPANOL");
		System.out.println("A continuacion traduciremos el texto ingresado...");
		System.out.println("Este es el texto en ingles:");
		
		//Lectura del diccionario
		try {
			traductor.lecturaAsociacion("src\\diccionario.txt");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		//Lectura del texto
		try {
			traductor.lecturaTraduccion("src\\texto.txt");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
