package QU1;

import java.time.LocalDate;

public class EventPriorityQueueApp {
    public static void main(String[] args){
        // Try each of the following implementations of PriorityQueue
//		EventPriorityQueueArray myQueue = new EventPriorityQueueArray(5);
//		EventPriorityQueueList myQueue = new EventPriorityQueueList();
        EventPriorityQueueHeap myQueue = new EventPriorityQueueHeap(5);
        myQueue.insert(new Event(LocalDate.parse("2023-07-02")));
        myQueue.insert(new Event(LocalDate.parse("2023-07-23")));
        myQueue.insert(new Event(LocalDate.parse("2023-07-12")));
        //System.out.println(new Event(LocalDate.parse("2023-07-12")));
        myQueue.insert(new Event(LocalDate.parse("2023-07-07")));
        myQueue.insert(new Event(LocalDate.parse("2023-07-13")));
        myQueue.insert(new Event(LocalDate.parse("2023-07-29")));
        myQueue.insert(new Event(LocalDate.parse("2022-08-23")));
        System.out.println("Removed: " + myQueue.remove());
        System.out.println("Removed: " + myQueue.remove());
    }
}
