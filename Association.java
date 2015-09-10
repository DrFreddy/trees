/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de base de datos
 * @author Freddy Ruíz 14592 / Samuel Duarte 14 / Christopher V 13
 * Laboratorio #7:
 * Clase: Association
 * @param <K>
 * @param <V>
 */
public class Association<K,V>
{
	protected K theKey; // the key of the key-value pair
	protected V theValue; // the value of the key-value pair

	// pre: key is non-null
	// post: constructs a key-value pair
	public Association(K key, V value){
		this.theKey=key;
		this.theValue=value;
	}
	
	// post: returns value from association
	public V getValue(){
		return theValue;
	}
	
	// post: returns key from association
	public K getKey(){
		return theKey;
	}
	
	// post: sets association's value to value
	public V setValue(V value){
		V viejoValor = theValue;
		theValue = value;
		return viejoValor;
	}
	
}
