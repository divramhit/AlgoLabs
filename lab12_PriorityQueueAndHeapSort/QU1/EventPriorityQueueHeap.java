package QU1;

public class EventPriorityQueueHeap {
    private Event[] heap;
    private int size;

    public EventPriorityQueueHeap(int size){
        heap = new Event[size+1];
        size = 0;
    } // end constructor

    public boolean isFull(){
        return(size == heap.length - 1);
    } // end isFull

    public boolean isEmpty(){
        return(size == 0);
    } // end isEmpty

    public void insert(Event event){
        if(isFull())
            System.out.println("Queue is already full...");
        else{
            heap[++size] = event;
            upheap(heap, size);
        }
    } // end insert

    public void upheap(Event[] heap, int index){
        Event tmp;
        while ((index > 1) && (heap[index/2].getTimestamp().isAfter(heap[index].getTimestamp()))){
            // We use "isAfter" because a date with a higher priority, and should therefore be higher up, is one which has the earliest date
            tmp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = tmp;
            index = index/2;
        }
    } // end upheap

    public Event remove(){
        Event tmp = heap[1];
        heap[1] = heap[size--];// moves the last element to the top
        downheap(heap, 1);
        return tmp;
    } // end remove

    public void downheap(Event[] heap, int index){
        int j = index * 2;
       Event tmp;

        while(j < size){
            if(heap[j].getTimestamp().isAfter(heap[j + 1].getTimestamp()))
                j++;
            if(heap[index].getTimestamp().isBefore( heap[j].getTimestamp()))
                break;
            tmp = heap[index];
            heap[index] = heap[j];
            heap[j] = tmp;
            index = j;
            j = index * 2;
        }
    } // end downheap
}

