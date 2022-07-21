package QU1;

public class EventNode {
    private Event event;
    private EventNode nextEvent;

    public EventNode(){
        this.event = null;
        this.nextEvent = null;
    }

    public EventNode(Event event) {
        this.event = event;
        nextEvent = null;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventNode getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(EventNode newNextEvent) {
        this.nextEvent = newNextEvent;
    }

    @Override
    public String toString() {
        return event.toString();
    }
}
