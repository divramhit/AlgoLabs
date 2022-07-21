package SortingClasses;

public class PriorityQueueArray {
	private int[] queue;
	private int size;
	
	public PriorityQueueArray(int size){
		queue = new int[size];
		size = 0;
	}
	
	public boolean isFull(){
		return(size == queue.length);
	}
	
	public boolean isEmpty(){
		return(size == 0);
	}
	
	public void insert(int element){
		if(isFull())
			System.out.println("Queue is already full...");
		else
			queue[size++] = element;
	}
	
	public int remove(){
		int highestPriority = 0, tmp;
		if(isEmpty())
			return -1;
		for(int i = 1; i < size; i++)
			if(queue[i] > queue[highestPriority])
				highestPriority = i;
		tmp = queue[highestPriority];
		queue[highestPriority] = queue[--size];
		return tmp;
	}
} // end class PriorityQueueArray
