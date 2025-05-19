# 📅 Simple Event Reminder App (Console-Based Java Project)

A beginner-friendly Java console application to add, view, and manage upcoming events — now with persistent storage using file handling and Java Serialization.

---

## 🚀 Features

- ✅ Add events with title and date
- 🗓️ Prevent adding past dates
- 📋 View all saved events
- 📆 Show only today's events
- 💾 Save and load events from file (`events.dat`) using serialization

---

## 🧾 Requirements

- Java JDK 8 or higher
- A terminal or command prompt

---

## 📁 Project Structure
```
EventReminder/
├── Event.java # Event class (implements Serializable)
└── EventReminderApp.java # Main logic and menu-driven CLI
```
---

## ⚙️ How to Compile and Run

### 🔹 Step 1: Open Terminal / CMD

Navigate to your project directory:

```bash
cd path/to/EventReminder
```

## Compile the Code
```bash
javac Event.java EventReminderApp.java
```

## Run the App
```bash
java EventReminderApp
```

## 📦 Event File
A file called events.dat will be created in the same directory.

It stores your events permanently using Java serialization.

When you re-open the app, previously saved events are loaded automatically.

## 📸 Demo (Sample CLI Output)
``` bash

=== Simple Event Reminder App ===
1. Add Event
2. View All Events
3. Show Today's Events
4. Exit
Enter your choice: 1
Enter event title: Project Submission
Enter event date (yyyy-MM-dd): 2025-06-01
Event added successfully.
```
