package QU1;

public class EventPriorityQueueArray {
    private Event[] queue;
    private int size;

    public EventPriorityQueueArray(int size){
        queue = new Event[size];
        size = 0;
    }

    public boolean isFull(){
        return(size == queue.length);
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public void insert(Event event){
        if(isFull())
            System.out.println("Queue is already full...");
        else
            queue[size++] = event;
    }

    public Event remove(){
        int highestPriority = 0;
        Event tmp;

        if(isEmpty())
            return null;

        for(int i = 1; i < size; i++)
            if(queue[i].getTimestamp().isBefore(queue[highestPriority].getTimestamp()))
                highestPriority = i;

        tmp = queue[highestPriority];
        queue[highestPriority] = queue[--size];
        return tmp;
    }
} // end class PriorityQueueArray
