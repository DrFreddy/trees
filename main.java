/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de datos
 * Laboratorio #7
 * @author Freddy José Ruíz 14592 
 *         Christopher Ajú 13171
 *	       Samuel Díaz 
 */
public class main{

	public static void main(String[] args){
		Lectura traductor = new Lectura();
		System.out.println ("BIENVENIDO AL DICCIONARIO INGLÉS-ESPAÑOL");
		System.out.println("A continuación traduciremos el texto ingresado...");
		System.out.println("Este es el texto en inglés:");
		
		//Lectura del diccionario
		try {
			traductor.lecturaDiccionario("src\\diccionario.txt");
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
