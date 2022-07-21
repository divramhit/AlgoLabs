package SortingClasses;

class Node{
	private int element;
	private Node next;
	
	public Node(){
		element = 0;
		next = null;
	}
	
	public Node(int element){
		this.element = element;
		next = null;
	}
	
	public int getElement(){
		return element;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setElement(int newElement){
		element = newElement; 
	}
	
	public void setNext(Node newNext){
		next = newNext;
	}
	
	public String toString(){
		return Integer.toString(this.element);
	}
} // end class Node

public class PriorityQueueList {
	private Node front;
	private long size;
	
	public PriorityQueueList(){
		front = null;
		size = 0;
	} // end constructor
	
	public Node peek(){	
		return front;
	} // end peek
	
	public long getSize(){
		return size;
	} // end getSize
	
	public boolean isEmpty(){
		return (front == null);
	} // end isEmpty
	
	public void insert(int element){	// addDescendingOrder
		Node newNode = new Node(element);
		Node tmp = front;
		
		if (front == null)
			front = newNode;		
		else{
			if(front.getElement() < element){
				newNode.setNext(front);
				front = newNode;
			}
			else{
				while((tmp.getNext() != null) && (tmp.getNext().getElement() > element))
					tmp = tmp.getNext();
				newNode.setNext(tmp.getNext());
				tmp.setNext(newNode);
			}
		}
		size++;		
	} // end insert
	
	public Node remove(){	// returns null if queue is empty
		Node tmp = front;
		front = front.getNext();
		size--;
		return tmp;
	} // end remove
} // end class PriorityQueueList
