package classroom;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Session {
    private final int id;
    private final String title;
    private final String date;
    private final String time;
    private final String room;
    private final List<String> agenda = new ArrayList<>();
    private final Set<String> attendees = new LinkedHashSet<>();

    public Session(int id, String title, String date, String time, String room) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    public void addAgendaItem(String item) { agenda.add(item); }

    public boolean markPresent(String student) { return attendees.add(student.trim()); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(id).append(" ").append(title).append("\n");
        sb.append("   Date: ").append(date).append("  Time: ").append(time)
          .append("  Room: ").append(room).append("\n");
        sb.append("   Agenda:\n");
        if (agenda.isEmpty()) sb.append("     (none yet)\n");
        for (int i = 0; i < agenda.size(); i++) {
            sb.append("     ").append(i + 1).append(". ").append(agenda.get(i)).append("\n");
        }
        sb.append("   Present (").append(attendees.size()).append("): ")
          .append(attendees.isEmpty() ? "-" : String.join(", ", attendees));
        return sb.toString();
    }
}
