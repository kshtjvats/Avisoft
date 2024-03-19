package TaskManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Task {
    private String title, deadline,subject;
    private boolean isDone = false;
    boolean missed=false;
    boolean running=true;
    // Constructor
    Task(String title, String deadline,String subject) {
        this.title = title;
        this.deadline = deadline;
        this.subject=subject;
    }

    // Setter methods
    void setTitle(String title) {
        this.title = title;
    }
    String getTaskSubject()
    {
        return subject;
    }
    void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    void setMissed()
    {
        this.missed=true;
    }
    boolean getMissedStatus()
    {
    return this.missed;
    }
    // Getter methods
    String getTaskTitle() {
        return title;
    }

    String getDeadline() {
        return deadline;
    }
    // Method to mark task as done
    void setDoneStatus() {
        this.isDone = true;
    }

    // Method to get status of task
    boolean getStatus() {
        return isDone;
    }

    // Method to display task details
    void showDetailsOfTask() {
        System.out.println("*********************");
        System.out.println("Task title : " + getTaskTitle());
        System.out.println("Task Deadline : " + getDeadline());
        System.out.println("*********************");
    }

    // Method to calculate deadline
    int deadlineCalculator() {
        String input = this.getDeadline();
        LocalDateTime inputDateTime = parseDateTime(input);
        LocalDateTime currentDateTime = LocalDateTime.now();
        int comparisonResult = compareDateTime(inputDateTime, currentDateTime);  
        /*
        -1: Deadline is in the past.
        1: Deadline is in the future.
        0: Deadline is the same as the current date and time
        */
        if (inputDateTime != null) {
            currentDateTime = LocalDateTime.now();
            comparisonResult = compareDateTime(inputDateTime, currentDateTime);
        } else {
            System.out.println("Invalid date and time format");
        }
        return comparisonResult;
    }

    // Method to continuously check if 1 minute left until deadline
    void oneMinuteCalculate() {
        while (running) {
            String input = this.getDeadline();
            int flag = 0;
            LocalDateTime inputDateTime = parseDateTime(input);
            LocalDateTime currentDateTime = LocalDateTime.now();
            int comparisonResult = compareDateTime(inputDateTime, currentDateTime);
            if (inputDateTime != null) {
                while (comparisonResult != -1) {
                    currentDateTime = LocalDateTime.now();
                    comparisonResult = compareDateTime(inputDateTime, currentDateTime);
                    // Check if 1 minute left
                    long minutesDifference = currentDateTime.until(inputDateTime, java.time.temporal.ChronoUnit.MINUTES);
                    if (flag == 0) {
                        if (minutesDifference < 1) {
                            System.out.println("1 minute left for Assignment:" + getTaskTitle());
                            flag = 1;
                        }
                    }
                }
            } else {
                System.out.println("Invalid date and time format");
            }
            try {
                Thread.sleep(60000); // Sleep for 1 minute
            } catch (InterruptedException interruptedException) {
                // Handle interruption
                Thread.currentThread().interrupt();
                return; // Exit the thread
            }
            if(this.getStatus()==true)
            break;
        }
    }
    // Method to parse date and time from string
    public static LocalDateTime parseDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM uuuu h:mm a");
        try {
            return LocalDateTime.parse(input, formatter);
        } catch (Exception exception) {
            return null;
        }
    }

    // Method to compare two date times
    public static int compareDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return dateTime1.compareTo(dateTime2);
    }
    
}
