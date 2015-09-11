/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de datos
 * Laboratorio #7
 * @author Freddy José Ruíz 14592 
 *         Christopher Ajú 13171
 *	       Samuel Díaz 
 */
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class pruebasUnitarias {
Lectura lectora= new Lectura();
BinaryTreeControl arbol= new BinaryTreeControl();
	@Test
	public void buscar() {
		assertEquals(null,lectora.buscar("crazy")); //Debido a que no está
	}
	@Test
	public void add(){
		arbol.addTraduccion("hello", "hola");
	assertEquals(1,arbol.contadorElementos());
	}
}
