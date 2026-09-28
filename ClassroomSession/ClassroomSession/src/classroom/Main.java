package classroom;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final SessionManager manager = new SessionManager();

    public static void main(String[] args) {
        System.out.println("=== Classroom Session Manager ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Create session");
            System.out.println("2. Add agenda item");
            System.out.println("3. Mark student present");
            System.out.println("4. List sessions");
            System.out.println("0. Exit");
            switch (ask("Choose: ")) {
                case "1" -> createSession();
                case "2" -> addAgenda();
                case "3" -> markPresent();
                case "4" -> listSessions();
                case "0" -> running = false;
                default -> System.out.println("Please enter a number from the menu.");
            }
        }
        System.out.println("Goodbye!");
    }

    private static void createSession() {
        String title = ask("Title: ");
        String date = ask("Date (e.g. 2026-10-05): ");
        String time = ask("Time (e.g. 10:00-12:00): ");
        String room = ask("Room: ");
        Session s = manager.create(title, date, time, room);
        System.out.println("Created session #" + s.getId());
    }

    private static void addAgenda() {
        Session s = pickSession();
        if (s == null) return;
        s.addAgendaItem(ask("Agenda item: "));
        System.out.println("Added.");
    }

    private static void markPresent() {
        Session s = pickSession();
        if (s == null) return;
        String name = ask("Student name: ");
        System.out.println(s.markPresent(name) ? "Marked present." : "Already marked present.");
    }

    private static void listSessions() {
        if (manager.all().isEmpty()) {
            System.out.println("No sessions yet. Choose 1 to create one.");
            return;
        }
        manager.all().forEach(s -> System.out.println("\n" + s));
    }

    private static Session pickSession() {
        if (manager.all().isEmpty()) {
            System.out.println("Create a session first.");
            return null;
        }
        try {
            int id = Integer.parseInt(ask("Session number: "));
            return manager.find(id).orElseGet(() -> {
                System.out.println("No session with that number.");
                return null;
            });
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return null;
        }
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }
}
