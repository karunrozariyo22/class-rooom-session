# Classroom Session Manager

A simple Java console project to create class sessions, add agenda items, and mark attendance.

## Requirements
Java 17 or newer.

## Build and run
```
mkdir -p out
javac -d out src/classroom/*.java
java -cp out classroom.Main
```

## Structure
- `Session.java` holds one session (details, agenda, attendees)
- `SessionManager.java` stores and finds sessions
- `Main.java` runs the text menu
