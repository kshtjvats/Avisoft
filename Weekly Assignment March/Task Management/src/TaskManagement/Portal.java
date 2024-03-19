package TaskManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Portal {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int flag=0;
        FileWriter filewriter = new FileWriter("src/TaskManagement/list.csv", true);
        List<Student> listOfStudents = new ArrayList<Student>(); // List to store registered students
        List<Task> Tasks = new ArrayList<Task>(); // List to store tasks
        int count = 0; // Counter for student registration
        String adminEmailAddress = "Admin@avisoft.io"; // Admin email
        String adminPassword = "Avisoft123"; // Admin password
        Set<String> batchNames = new HashSet<String>(); // Set to store unique batch names
        Set<String> emails = new HashSet<String>(); // Set to store unique email addresses
        int choiceForSwitch = 0; // Variable for main menu choice

        // Main menu loop
        while (choiceForSwitch != 4) {
            System.out.println("Enter a choice\n1 : Admin Login\n2 : Student Registration\n3 : Login\n4 : Quit");
            
            try{
                choiceForSwitch = scanner.nextInt();
            switch (choiceForSwitch) {
                case 1: // Admin login
                    System.out.println("Enter Admin email");
                    String adminEmail = scanner.next();
                    System.out.println("Enter Password");
                    String adminLoginPassword = scanner.next();
                    if (adminEmail.equals(adminEmailAddress) && adminLoginPassword.equals(adminPassword)) {
                        System.out.println("Login Successful!");
                        int choiceForAdmin = 0; // Variable for admin menu choice
                        // Admin menu loop
                        while (choiceForAdmin != 5) {
                            System.out.println("Enter a choice :\n1 : Show List of All Students\n" +
                                    "2 : Show List of Students in a particular Batch\n" +
                                    "3 : Add Tasks\n4 : Check a Student's Submissions ");
                            choiceForAdmin = scanner.nextInt();
                            switch (choiceForAdmin) {
                                case 1: // Display list of all students
                                    if (listOfStudents.size() != 0) {
                                        for (Student student : listOfStudents) {
                                            student.showDetails();
                                        }
                                    } else
                                        System.out.println("No students registered");
                                    break;
                                case 2: // Display list of students in a specific batch
                                    if (listOfStudents.size() != 0) {
                                        System.out.println("Enter the batch name");
                                        String batch = scanner.next();
                                        if (batchNames.contains(batch)) {
                                            for (Student student : listOfStudents) {
                                                if (student.getBatch().equals(batch))
                                                    student.showDetails();
                                            }
                                        } else
                                            System.out.println("No such Batch Present");
                                    } else
                                        System.out.println("No students registered");
                                    break;
                                case 3: // Add tasks
                                    System.out.println("Enter Task title");
                                    String title = scanner.next();
                                    System.out.println("Enter Task Subject");
                                    String subject = scanner.next();
                                    scanner.nextLine();
                                    System.out.println("Enter task deadline of type example : 12Feb2024");
                                    String deadline = scanner.nextLine();
                                    if (isFutureDate(deadline))
                                    {
                                    Task task = new Task(title, deadline, subject);
                                    Tasks.add(task);
                                    }
                                    else
                                    System.out.println("INVALID DATE");
                                    break;
                                case 4: // Check student submissions
                                    System.out.println("Enter student email");
                                    String email = scanner.next();
                                    Student currStudentInAdmin = new Student(null, null, null, null);
                                    for (Student student : listOfStudents) {
                                        if (student.getEmail().equals(email)) {
                                            currStudentInAdmin = student;
                                            break;
                                        }
                                    }
                                    System.out.println("1 : Show Done Tasks\n2 : Show missed Tasks");
                                    int choiceInStudentPortal = scanner.nextInt();
                                    if (choiceInStudentPortal == 1) {
                                        System.out.println("Done Tasks");
                                        for (Task doneTask : currStudentInAdmin.myTasks) {
                                            if(doneTask.getStatus()==true)
                                            System.out.println(doneTask.getTaskTitle());
                                        }
                                    }
                                    if (choiceInStudentPortal == 2) {
                                        System.out.println("Missed Tasks");
                                        for (Task missedTask : currStudentInAdmin.myTasks) {
                                            if(missedTask.getMissedStatus()==true)
                                            System.out.println(missedTask.getTaskTitle());
                                        }
                                    }
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 2: // Student registration
                    System.out.println("Enter your Email");
                    String email = scanner.next();
                    if (!emails.contains(email)) {
                        emails.add(email);
                        System.out.println("Enter your name");
                        String name = scanner.next();
                        System.out.println("Enter Password");
                        String password1 = scanner.next();
                        System.out.println("Enter your Batch");
                        String Batch = scanner.next();
                        batchNames.add(Batch);
                        Student student = new Student(name, email, password1, Batch);
                        listOfStudents.add(student);
                        AddStudentToList(count, student,filewriter);
                        System.out.println("Student Successfully Registered");
                        count++;
                    } else
                        System.out.println("A student with this credential exists!");
                    break;
                case 3: // Student login
                    System.out.println("Enter your email");
                    email = scanner.next();
                    if (emails.contains(email)) {
                        System.out.println("Enter your password");
                        String password = scanner.next();
                        Student currentStudent = new Student(null, null, null, null);
                        for (Student student : listOfStudents) {
                            if (student.getEmail().equals(email)) {
                                currentStudent = student;
                                break;
                            }
                        }
                        if (currentStudent.getPassword().equals(password)) {
                            System.out.println("Login Successful!");
                            //executing the thread
                            for (Task task : Tasks) {
                                if (task.getTaskSubject().equals(currentStudent.getBatch())) {
                                    currentStudent.myTasks.add(task);
                                   /* ExecutorService executor = Executors.newSingleThreadExecutor();
                                    executor.execute(() -> {
                                        task.oneMinuteCalculate();
                                    });*/
                                }
                            }
                            int choiceForStudent = 0; // Variable for student menu choice
                            while (choiceForStudent != 3) {
                                for (Task task : currentStudent.myTasks) {
                                    if (task.deadlineCalculator() == -1 && task.getStatus() == false)
                                        currentStudent.missedTasks.add(task);
                                    task.setMissed();
                                }
                                System.out.println("CHOOSE:\n1 : Show Upcoming work\n2 : Submit Tasks");
                                choiceForStudent = scanner.nextInt();
                                switch (choiceForStudent) {
                                    case 1: // Display upcoming tasks
                                        currentStudent.showUpcomingWork(currentStudent.myTasks);
                                        break;
                                    case 2: // Submit tasks
                                        currentStudent.SubmitTask();
                                        break;
                                    case 3: // Logout
                                        System.out.println("Logged out");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else
                            System.out.println("Invalid credentials, Login Failed!");
                    } else
                        System.out.println("This email is not registered");
                    break;
                case 4:
                filewriter.close();
                break;
                default:
                    break;
            }
        }
        catch(InputMismatchException inputMismatchException)
        {
            System.err.println("Invalid input type");
            scanner.next();
        } 
    }
}
    // Method to add student details to a CSV file
    static void AddStudentToList(int count, Student student,FileWriter filewriter) throws IOException {
        if (count == 0) {
            filewriter.write("Name,Email,Batch\n");
            filewriter.write(student.getName() + "," + student.getEmail() + "," + student.getBatch() + "\n");
        } else {
            filewriter.write(student.getName() + "," + student.getEmail() + "," + student.getBatch() + "\n");
        }
    }
    public static boolean isFutureDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm a");
        try {
            LocalDateTime date = LocalDateTime.parse(dateString, formatter);
            LocalDateTime currentDateTime = LocalDateTime.now();
            return date.isAfter(currentDateTime);
        } catch (Exception e) {
            return false; // Parsing error or invalid format
        }
    }
}
