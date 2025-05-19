import java.io.Serializable;
import java.time.LocalDate;

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private LocalDate date;

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event: " + title + " on " + date.toString();
    }
}
