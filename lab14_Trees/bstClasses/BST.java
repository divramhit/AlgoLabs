package bstClasses;

public class BST {
	private BSTNode root;
	
	public BST(){
		root = null;
	} // end constructor
	
	public BSTNode getRoot(){
		return root;
	} // end getRoot
	
	public void addElement(int elementVal){
		// create new node to be added
		BSTNode tmp = new BSTNode(elementVal);		
		
		if(root == null)	// BST is empty
			root = tmp;		// The new node becomes the root
		else{				// BST is not empty
			BSTNode parent, current;	
			parent = current = root;
			while(current != null){		
				// locates the node where the new node will be inserted
				parent = current;
				if(elementVal < current.getValue())
					current = current.getLeft();
				else
					current = current.getRight();
			}
			// After while loop, parent points to parent of node to be inserted
			
			// if the element to be inserted is less than it's parent, insert it as the parent's left child;
			// else as its right child 
			if(elementVal < parent.getValue())	 
				parent.setLeft(tmp);
			else
				parent.setRight(tmp);
		}
	} // end addElement
	
	public BSTNode searchElement(int searchVal){
		// if searchVal not found, searchElement returns null
		BSTNode tmp;
		tmp = root;
		
		while((tmp != null) &&(tmp.getValue() != searchVal)){
			if(searchVal < tmp.getValue())
				tmp = tmp.getLeft();
			else
				tmp = tmp.getRight();
		}
		return tmp;		
	} // end searchElement
	
	public void deleteElement(int delVal){		
		BSTNode delNode;			// node to be deleted 
		BSTNode parent;				// parent of delNode
		BSTNode replaceNode;		// node that will replace delNode
		BSTNode parentSuccessor;	// parent of replaceNode
		BSTNode successor;			// inorder successor of delNode 
		
		parent = delNode = root;
		replaceNode = parentSuccessor = successor = null;
		
		while((delNode != null) && 
				(delNode.getValue() != delVal)){		
			// search the node to be deleted while haven't found the node to be deleted and not reached null
			parent = delNode;
			if(delVal < delNode.getValue())
				delNode = delNode.getLeft();
			else
				delNode = delNode.getRight();
		}
		// delNode points to the node to be deleted or to null if the node is not found in the BST;
		// parent points to the parent of delNode
		
		// Set replaceNode to the node that will replace delNode
		if(delNode == null)
			System.out.println("\n\tThe node is not found in this BST...");
		else{
			// Cases 1 and 2: No children or 1 child
			if(delNode.getLeft() == null){
				replaceNode = delNode.getRight();
			}
			else if(delNode.getRight() == null){
				replaceNode = delNode.getLeft();
			}
			else{
				// Case 3: delNode has 2 children
				// Set replaceNode to the inorder successor of delNode and parentSuccessor to the parent of replaceNode 
				parentSuccessor = delNode;
				replaceNode = delNode.getRight();
				successor = replaceNode.getLeft();
				// find the inorder successor of delNode - loop while there is still a left subtree
				while(successor != null){	
					parentSuccessor = replaceNode;
					replaceNode = successor;
					successor = replaceNode.getLeft();
				} 
				// at this point replaceNode is the inorder successor of delNode
				
				if(parentSuccessor != delNode){
					// delNode is not the parent of replaceNode and replaceNode == parentSuccessor.getLeft()
					parentSuccessor.setLeft(replaceNode.getRight());
					// remove replaceNode from its current position and replace it with the right child of replaceNode
					// replaceNode takes the place of delNode
					replaceNode.setRight(delNode.getRight());
				} // end if
				
				// set the left child of replaceNode so that replaceNode takes the place of delNode
				replaceNode.setLeft(delNode.getLeft());
			} // end else - case 3
			
			// insert replaceNode in the position formerly occupied by delNode
			if(delNode == root)		
				// if node to be deleted is root, set root to replaceNode
				root = replaceNode;			
			else if(delNode == parent.getLeft())
				parent.setLeft(replaceNode);
			else
				parent.setRight(replaceNode);			
		} // end else - node is found in the BST
	} // end deleteElement

	public void preOrder(BSTNode node){
		if(node != null){
			System.out.print("\t" + node.getValue());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	} // end preOrder
	
	public void inOrder(BSTNode node){
		if(node != null){
			inOrder(node.getLeft());
			System.out.print("\t" + node.getValue());
			inOrder(node.getRight());			
		}
	} // end inOrder
	
	public void postOrder(BSTNode node){
		if(node != null){
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print("\t" + node.getValue());
		}
	} // end postOrder
} // end class BST
