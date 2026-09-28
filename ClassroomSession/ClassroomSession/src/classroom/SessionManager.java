package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionManager {
    private final List<Session> sessions = new ArrayList<>();
    private int nextId = 1;

    public Session create(String title, String date, String time, String room) {
        Session s = new Session(nextId++, title, date, time, room);
        sessions.add(s);
        return s;
    }

    public Optional<Session> find(int id) {
        return sessions.stream().filter(s -> s.getId() == id).findFirst();
    }

    public List<Session> all() { return sessions; }
}
