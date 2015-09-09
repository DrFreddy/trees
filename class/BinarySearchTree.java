
public class BinarySearchTree {
	private Nodo<Integer> root;
	
	public void Add(int value){
		Nodo<Integer> temp = new Nodo<Integer>(value);
		
		//se verifica que no sea el primer valor
		if (root == null){
			root = temp;
			return;
		}
		
		//ingreso de rama
		//se usaran ints para la comparacion
		else{
			insert(root, temp);
		}
	}
	
	public void insert(Nodo<Integer> root, Nodo<Integer> nodo){
		//se verifica si se envia al lado izquierdo
		if((nodo.getValue())<(root.getValue())){
			/*
			 * se verifica que no haya subarboles en el lado izquierdo
			 */
			if((root.getIzquierdo())==null){
				root.setIzquierdo(nodo);
				return;
			}
			//si se encuentra un nodo en el espacio se analiza el subarbol
			else{
				insert(root.getIzquierdo(), nodo);
			}
		}
		//si no entra en el lado izquierdo prueba en el lado derecho
		else{
			//se verifica que no haya subarbol
			if(root.getDerecho() == null){
				root.setDerecho(nodo);
				return;
			}
			//si se encuentra un nodo en el espacio se analiza el subarbol
			else{
				insert(root.getDerecho(), nodo);
			}
		}
	}
}
