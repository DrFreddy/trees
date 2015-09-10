import java.util.Stack;

public class BinaryTreeControl{
	BinaryTree<Association<String,String>> root = null;
	Comparador comparador = new Comparador();
	protected Stack<BinaryTree<Association<String,String>>> todo = new Stack<BinaryTree<Association<String,String>>>();
	int contador = 0;
	
	
	public BinaryTree<Association<String,String>> locate(BinaryTree<Association<String,String>> root, String value){
		String rootValue = root.getNode().getKey();
		BinaryTree<Association <String,String>> child;
		
		//found at root: done
		if(rootValue.equals(value)) return root;
		//look left if less-than, right if greater-than
		if(rootValue.compareTo(value) <0){
			child = root.getRight();
		} else {
			child = root.getLeft();
		}
		
		//no child there: not in tree, return this node, else keep searching
		if(child==null){
			return root;
		} else {
			return locate(child, value);
		}
	}
	
	public void add(Association <String,String> asociacion){
		BinaryTree<Association<String,String>> newNode = new BinaryTree<Association<String,String>>(asociacion);
	
		//Add value to binary search tree
		//if there's no root, create value at root
		if(root==null){
			root = newNode;
			contador++;
		} else {
			BinaryTree<Association<String,String>> insertLocation = locate(root, asociacion.getKey());
			String nodeValue = insertLocation.getNode().getKey();
			
			//If the newNode is greater than insertLocation, set it to the right.
			if(asociacion.getKey().compareTo(nodeValue) <0){
				insertLocation.setLeft(newNode);
				contador++;
			} 
			//If the newNode is lower than insertLocation, set it to the left.
			if(asociacion.getKey().compareTo(nodeValue)> 0){
				insertLocation.setRight(newNode);
				contador++;
			} 
			//If the newNode is equal to insertLocation the newNode isn't added to the tree.
			
		}
	}
	
	//Next method
	public Association<String,String> next(){
		BinaryTree<Association<String,String>> old = todo.pop();
		Association<String,String> result = old.getNode();
		//We know this node has no unconsidered left children; if this node has right child,
		//we push the right child and its leftmost descendants:
		//else
		//	top element of stack is next node to be visited
		if(old.getRight()!=null){
			BinaryTree<Association<String,String>> current = old.getRight();
			do{
				todo.push(current);
				current = current.getLeft();
			} while(current!=null);
		}
		
		return result;
	}
	
	public boolean hasNext(){
		return !todo.isEmpty();
	}
	//Agregar Traduccion
		public void addTraduccion(String ingles, String espanol){
			add(new Association<String,String>(ingles,espanol));
		}
		
		//Reset Iterator method
		public void resetIterator(){
			todo.clear();
			//Stack is empty. Push nodes from root to leftmost descendant
			BinaryTree<Association<String,String>> current = root;
			while(current!=null){
				todo.push(current);
				current = current.getLeft();
			}
		}

}