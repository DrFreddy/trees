
public class Nodo <E> {
	private E valor;
	private Nodo<E> izquierdo;
	private Nodo<E> derecho;
	
	public Nodo(E valor){
		this.valor = valor;
	}
	public Nodo<E> getDerecho(){
		return derecho;
	}
	public void setDerecho(Nodo<E> nodo){
		derecho = nodo;
	}
	public Nodo<E> getIzquierdo(){
		return izquierdo;
	}
	
	public void setIzquierdo(Nodo<E> nodo){
		izquierdo = nodo;
	}
	
	public E getValue(){
		return valor;
	}
	
}
