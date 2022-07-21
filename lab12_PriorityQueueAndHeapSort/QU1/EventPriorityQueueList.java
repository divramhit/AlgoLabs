package QU1;

public class EventPriorityQueueList {
    private EventNode front;
    private long size;

    public EventPriorityQueueList(){
        front = null;
        size = 0;
    } // end constructor

    public EventNode peek(){
        return front;
    } // end peek

    public long getSize(){
        return size;
    } // end getSize

    public boolean isEmpty(){
        return (front == null);
    } // end isEmpty

    public void insert(Event event){	// add events with smaller timestamps in front
        EventNode newNode = new EventNode(event);
        EventNode tmp = front;

        if (front == null)
            front = newNode;
        else{
            // The new element has the smallest timestamp in the list if its timestamp is smaller than  than front itself
            if(front.getEvent().getTimestamp().isAfter(event.getTimestamp())){
                newNode.setNextEvent(front);
                front = newNode;
            }
            else{
                // add the newNode somewhere in between
                // tmp will be an earlier date than event, but temp's next will be a later date than event
                while((tmp.getNextEvent() != null) && (tmp.getNextEvent().getEvent().getTimestamp().isBefore(event.getTimestamp())))
                    tmp = tmp.getNextEvent();
                newNode.setNextEvent(tmp.getNextEvent());
                tmp.setNextEvent(newNode);
            }
        }
        size++;
    } // end insert

    public EventNode remove(){	// returns null if queue is empty
        EventNode tmp = front;
        front = front.getNextEvent();
        size--;
        return tmp;
    } // end remove
}

