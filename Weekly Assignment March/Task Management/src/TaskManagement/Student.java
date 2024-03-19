package TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    Scanner scanner = new Scanner(System.in);
    int counter = 0; // Counter for task serial number display

    private String name, email, password, batch;
    List<Task> myTasks = new ArrayList<Task>(); // List to store tasks assigned to the student
    List<Task> doneTask = new ArrayList<Task>(); // List to store tasks completed by the student
    List<Task> missedTasks = new ArrayList<Task>(); // List to store tasks missed by the student

    // Constructor to initialize Student object
    Student(String name, String email, String password, String batch) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.batch = batch;
    }
    void setBatch(String batch)
    {
        this.batch=batch;
    }
    // Getter methods for student details
    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getBatch() {
        return batch;
    }

    String getPassword() {
        return password;
    }

    // Method for submitting a task
    void SubmitTask() {
        if (myTasks.size() != 0) {
            try{
            counter=1;
            // Display tasks available for submission
            for (Task task : myTasks) {
                System.out.println("***************");
                System.out.println("Serial Number : " + (counter++));
                System.out.println("Task Title : " + task.getTaskTitle());
                System.out.println("Task Deadline : " + task.getDeadline());
                System.out.println("****************");
            }
            System.out.println("Enter the serial number corresponding to Task");
            int serialNumber = scanner.nextInt();
            if (serialNumber > myTasks.size()) {
                System.out.println("Task does not exist");
                return;
            } else {
                // Prompt for task submission
                System.out.println("Enter 1 to submit task");
                int command = scanner.nextInt();
                if (command == 1) {
                    // Mark task as done and remove from current tasks
                    myTasks.get(serialNumber - 1).setDoneStatus();
                    System.out.println(myTasks.get(serialNumber-1).getTaskTitle()+" Done");
                }
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException)
        {
            System.out.println("Invalid entry");
            return;
        }
     } else
            System.out.println("No tasks to submit");
    }

    // Method to display student details
    void showDetails() {
        System.out.println("Student name : " + getName());
        System.out.println("Student email : " + getEmail());
        System.out.println("Student Batch : " + getBatch());
    }

    // Method to display upcoming tasks
    void showUpcomingWork(List<Task> myTasks) {
        List<Task> upcoming = new ArrayList<Task>();
        if (myTasks.size() == 0) {
            System.out.println("Wohoo! no work due");
        } else {
            for (Task t : myTasks) {
                int deadlineResult = t.deadlineCalculator();
                if (deadlineResult == 1) {
                    t.showDetailsOfTask();
                    upcoming.add(t);
                } else if (deadlineResult == -1) {
                    System.out.println("Invalid deadline for task: " + t.getTaskTitle());
                }
            }
            // Start a new thread for each upcoming task to calculate one minute
            for (Task task : upcoming) {
                Thread oneMinuteThread = new Thread(() -> task.oneMinuteCalculate());
                oneMinuteThread.start();
            }
        }
    }
}
