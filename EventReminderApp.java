import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventReminderApp {
    private static ArrayList<Event> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String FILE_NAME = "events.dat";

    public static void main(String[] args) {
        loadEventsFromFile();

        int choice;
        do {
            System.out.println("\n=== Simple Event Reminder App ===");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. Show Today's Events");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    showTodaysEvents();
                    break;
                case 4:
                    saveEventsToFile();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private static void addEvent() {
    try {
        System.out.print("Enter event title: ");
        String title = scanner.nextLine();

        System.out.print("Enter event date (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput, formatter);

        LocalDate today = LocalDate.now();

        if (date.isBefore(today)) {
            System.out.println("You cannot add an event for a past date!");
            return;
        }

        Event event = new Event(title, date);
        events.add(event);
        System.out.println("Event added successfully.");
    } catch (DateTimeParseException e) {
        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
    }
}


    private static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("\n--- All Events ---");
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }

    private static void showTodaysEvents() {
        LocalDate today = LocalDate.now();
        boolean found = false;

        System.out.println("\n--- Today's Events ---");
        for (Event e : events) {
            if (e.getDate().equals(today)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No events today.");
        }
    }

    private static void saveEventsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(events);
        } catch (IOException e) {
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    private static void loadEventsFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                events = (ArrayList<Event>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading events: " + e.getMessage());
            }
        }
    }
}
