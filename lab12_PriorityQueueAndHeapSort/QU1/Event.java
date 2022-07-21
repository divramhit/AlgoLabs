package QU1;
import java.time.LocalDate;
import java.util.Date;

public class Event {
    private static int numEvents = 0;
    private int reference;
    private LocalDate timestamp;

    public Event(LocalDate timestamp) {
        reference = ++numEvents;
        this.timestamp = timestamp;
    }

    public static int getNumEvents() {
        return numEvents;
    }

    public int getReference() {
        return reference;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "reference=" + reference +
                ", timestamp=" + timestamp +
                '}';
    }
}

