package bstClasses;

public class BSTNode {
	private int value;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(){
		value = 0;
		left = null;
		right = null;
	}
	
	public BSTNode(int value){
		this.value = value;
		left = null;
		right = null;
	}
	
	public void setValue(int newValue){
		value = newValue;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setLeft(BSTNode newLeft){
		left = newLeft;
	}
	
	public BSTNode getLeft(){
		return left;
	}
	
	public void setRight(BSTNode newRight){
		right = newRight;
	}
	
	public BSTNode getRight(){
		return right;
	}
} // end class BSTNode
