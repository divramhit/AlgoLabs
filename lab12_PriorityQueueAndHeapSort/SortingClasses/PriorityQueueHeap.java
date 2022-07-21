package SortingClasses;

public class PriorityQueueHeap {
	private int[] heap;
	private int size;
	
	public PriorityQueueHeap(int size){
		heap = new int[size+1];
		size = 0;
	} // end constructor
	
	public boolean isFull(){
		return(size == heap.length - 1);
	} // end isFull
	
	public boolean isEmpty(){
		return(size == 0);
	} // end isEmpty
	
	public void insert(int element){
		if(isFull())
			System.out.println("Queue is already full...");
		else{
			heap[++size] = element;
			upheap(heap, size);
		}
	} // end insert
	
	public void upheap(int[] heap, int index){
		int tmp;
		while ((index > 1) && (heap[index/2] < heap[index])){
			tmp = heap[index];
			heap[index] = heap[index/2];
			heap[index/2] = tmp;
			index = index/2;
		}
	} // end upheap
	
	public int remove(){
		int tmp = heap[1];
		heap[1] = heap[size--];
		downheap(heap, 1);
		return tmp;
	} // end remove
	
	public void downheap(int[] heap, int index){
		int j = index * 2;
		int tmp;
		
		while(j < size){
			if(heap[j] < heap[j + 1])
				j++;
			if(heap[index] >= heap[j])
			     break;
			tmp = heap[index];
			heap[index] = heap[j];
			heap[j] = tmp;
			index = j;
			j = index * 2;
		}
	} // end downheap
} // end class PriorityQueueHeap 
