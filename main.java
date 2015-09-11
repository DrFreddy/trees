/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de datos
 * Laboratorio #7
 * @author Freddy José Ruíz 14592 
 *         Christopher Ajú 13171
 *	       Samuel Díaz 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Lectura {
	private String resultado = "";
	private BinaryTreeControl traductorTree;
	private String textoC, textoC1, linea, linea1, textoL, textoL1, traduccion;
	private String[] palabras;
	
	/**
	 * Constructor de la clase lectura:
	 * En el se inicializa un nuevo árbol binario
	 */
	public Lectura() {
		traductorTree = new BinaryTreeControl();
	}
	
	/**
	 * Recorrido in order del árbol
	 * para la muestra de resultados
	 *
	 */
	
	public void inOrder(){
		int i=0;
		traductorTree.resetIterator();
		System.out.println("A continuación se muestran las asociaciones in Order del árbol");
		while(traductorTree.hasNext()){
			i++;
			Association<String,String> inglesEspanol = traductorTree.next();
			System.out.println(i+")"+" Inglés: "+inglesEspanol.getKey()+" Español: "+inglesEspanol.getValue());
			for(int f=0; f<(palabras.length);f++){
				//se busca en todo el array si una palabra en ingles coincide con la llave
				if ((palabras[f]).equals(inglesEspanol.getKey())){
					palabras[f] = inglesEspanol.getValue();
				}
				//System.out.print(palabras[f] + " ");
			}
			System.out.print("\n");
		}
		
		//for de concatenado
		for(int f=0; f<(palabras.length);f++){
			//se recorre el array y se convierte a un string
			resultado = resultado + palabras[f] + " ";
			
		}
	}
	
	//Regresa el arbol actual
	public BinaryTreeControl getArbol(){
		return traductorTree;
	}

	/**
	 * Método LecturaDiccionario
	 * Está encargado de leer los datos del diccionario
	 * y de su almacenamiento en el árbol binario
	 * @param texto
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public void lecturaDiccionario(String texto) throws FileNotFoundException, Exception{
	 
		try{
			File archivo = new File (texto);
	      	FileReader fr= new FileReader(archivo);
	      	BufferedReader bf= new BufferedReader(fr);  
				//El ciclo se mantiene hasta que no hayan lineas que leer
			      while((linea = bf.readLine()) != null){ 
			    	  textoC=textoC+linea;
			    	  textoC= textoC+"\n";
			    	  textoL= textoL+linea;
			      }
			      textoC= textoC.replace("null", "");
			      
			    //Limpieza del diciconario
			      String[] remplazosText = {"(",","};
			      for(int i=0; i < remplazosText.length; i++) {
			      textoL = textoL.replace(remplazosText[i], "");
			      textoL= textoL.replace(")",""+" ");
			      textoL=textoL.replace("null", "");
			      palabras= textoL.split(" ");
			      }
			     
			    //Almacenamiento en el árbol
			      for (int i=0; i< palabras.length; i++){
			    		  traductorTree.addTraduccion(palabras[i],palabras[i+1]);
			    		  i++;
			       } 
	        }
	        catch(Exception e){
	        	System.err.println( "ARCHIVO NO ENCONTRADO" );
	        }
	     
	}
	/**
	 * 
	 * Método LecturaTraducción
	 * Está encargado de leer el string a traducir
	 * y de la muestra de la traducción
	 * @param texto
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public void lecturaTraduccion(String texto)throws FileNotFoundException, Exception{
		
		//*********************LECTURA DEL TEXTO A TRADUCIR********************
		try{
      	File archivo = new File (texto);
      	FileReader fr= new FileReader(archivo);
      	BufferedReader bf= new BufferedReader(fr);
      
      	
      	//El ciclo se mantiene hasta que no hayan lineas que leer
          while((linea = bf.readLine()) != null){ 
        	  textoC1=textoC1+linea;
        	  textoC1= textoC1+"\n";
        	  textoL1= textoL1+linea;
          }//Cierre del while
          
        //***************COMIENZA LA LIMPIEZA DE STRINGS**************************
        	//*****************Limpieza del texto a traducir***********************
                String[] remplazosText = {"'", "."};
                for(int i=0; i < remplazosText.length; i++) {
                textoL1 = textoL1.replace(remplazosText[i], " ");
                textoL1= textoL1.replace(",","");
                textoL1= textoL1.replace("null", "");  
              	palabras= textoL1.split(" ");
              
              }
         
         System.out.println(textoL1);
       //Muestra de los datos del diccionario inOrder
         inOrder();
            System.out.println("Esta es la traducción al Español: ");
        	System.out.println(resultado);
          
		}
		
		//Cierre del try
        catch(Exception e){ //En caso que no pueda leerse el archivo
     	   System.err.println( "ARCHIVO NO ENCONTRADO" );
       } //Cierre del Catch
	  
	}
}
