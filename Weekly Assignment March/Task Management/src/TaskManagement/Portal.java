package TaskManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Portal {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // FileWriter to write student details to CSV file
        FileWriter filewriter = new FileWriter("src/TaskManagement/list.csv", true);

        // List to store registered students
        List<Student> listOfStudents = new ArrayList<Student>();

        // List to store tasks
        List<Task> Tasks = new ArrayList<Task>();

        // Counter for student registration
        int count = 0;

        // Admin credentials
        String adminEmailAddress = "Admin@avisoft.io";
        String adminPassword = "Avisoft123";

        // Set to store unique batch names
        Set<String> batchNames = new HashSet<String>();

        // Set to store unique email addresses
        Set<String> emails = new HashSet<String>();

        // Variable for main menu choice
        int choiceForSwitch = 0;

        // Main menu loop
        while (choiceForSwitch != 4) {
            // Displaying main menu options
            System.out.println("Enter a choice\n1 : Admin Login\n2 : Student Registration\n3 : Student Login\n4 : Quit");
            try {
                // Reading user choice
                choiceForSwitch = scanner.nextInt();

                switch (choiceForSwitch) {
                    case 1: // Admin login
                        System.out.println("Enter Admin email");
                        String adminEmail = scanner.next();
                        System.out.println("Enter Password");
                        String adminLoginPassword = scanner.next();

                        // Admin authentication
                        if (adminEmail.equals(adminEmailAddress) && adminLoginPassword.equals(adminPassword)) {
                            System.out.println("Login Successful!");

                            // Variable for admin menu choice
                            int choiceForAdmin = 0;

                            // Admin menu loop
                            while (choiceForAdmin != 6) {
                                System.out.println("Enter a choice :\n1 : Show List of All Students\n" +
                                        "2 : Show List of Students in a particular Batch\n" +
                                        "3 : Add Tasks\n4 : Check a Student's Submissions\n5 : Change Student's class\n6 : QUIT");

                                // Reading admin menu choice
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

                                        // Check if the entered deadline is in the future
                                        if (isFutureDate(deadline)) {
                                            Task task = new Task(title, deadline, subject);
                                            Tasks.add(task);
                                        } else
                                            System.out.println("INVALID DATE");
                                        break;
                                    case 4: // Check student submissions
                                        System.out.println("Enter student email");
                                        String email = scanner.next();
                                        Student currentStudentInAdmin = new Student(null, null, null, null);
                                        for (Student student : listOfStudents) {
                                            if (student.getEmail().equals(email)) {
                                                currentStudentInAdmin = student;
                                                break;
                                            }
                                        }

                                        // Display student's submissions
                                        if (currentStudentInAdmin.getName() != null) {
                                            System.out.println("1 : Show Done Tasks\n2 : Show missed Tasks\n3 : go back");
                                            int choiceInStudentPortal = scanner.nextInt();
                                            if (choiceInStudentPortal == 1) {
                                                System.out.println("Done Tasks");
                                                for (Task doneTask : currentStudentInAdmin.myTasks) {
                                                    if (doneTask.getStatus() == true)
                                                        System.out.println(doneTask.getTaskTitle());
                                                }
                                            }
                                            if (choiceInStudentPortal == 2) {
                                                System.out.println("Missed Tasks");
                                                for (Task missedTask : currentStudentInAdmin.myTasks) {
                                                    if (missedTask.getMissedStatus() == true)
                                                        System.out.println(missedTask.getTaskTitle());
                                                }
                                            }
                                        } else
                                            System.out.println("Student not found");
                                        break;
                                    case 5: // Change student's class
                                        System.out.println("Enter student email");
                                        email = scanner.next();
                                        currentStudentInAdmin = new Student(null, null, null, null);
                                        for (Student student : listOfStudents) {
                                            if (student.getEmail().equals(email)) {
                                                currentStudentInAdmin = student;
                                                break;
                                            }
                                        }
                                        if (currentStudentInAdmin.getName() != null) {
                                            System.out.println("Enter new class for student");
                                            String newClass = scanner.next();
                                            currentStudentInAdmin.setBatch(newClass);
                                            currentStudentInAdmin.myTasks.clear();
                                        } else
                                            System.out.println("Student not found");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else
                            System.out.println("Invalid credentials");
                        break;
                    case 2: // Student registration
                        System.out.println("Enter your Email");
                        String email = scanner.next();
                        if (!emails.contains(email)) {
                            emails.add(email);
                            System.out.println("Enter your name");
                            String name = scanner.next();

                            // Validate name format
                            if (isNameValid(name) == true) {
                                System.out.println("Enter Password");
                                String password1 = scanner.next();
                                System.out.println("Enter your Batch");
                                String Batch = scanner.next();
                                batchNames.add(Batch);
                                Student student = new Student(name, email, password1, Batch);
                                listOfStudents.add(student);
                                AddStudentToList(count, student, filewriter);
                                System.out.println("Student Successfully Registered");
                                count++;
                            } else
                                System.out.println("Invalid name");
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

                                // Assign tasks to student
                                for (Task task : Tasks) {
                                    if (task.getTaskSubject().equals(currentStudent.getBatch())) {
                                        currentStudent.myTasks.add(task);
                                    }
                                }

                                // Variable for student menu choice
                                int choiceForStudent = 0;

                                // Student menu loop
                                while (choiceForStudent != 3) {
                                    // Check for missed tasks
                                    for (Task task : currentStudent.myTasks) {
                                        if (task.deadlineCalculator() == -1 && task.getStatus() == false) {
                                            currentStudent.missedTasks.add(task);
                                            task.setMissed();
                                        }
                                    }
                                    System.out.println("CHOOSE:\n1 : Show Upcoming work\n2 : Submit Tasks\n3 : Go back");
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
                    case 4: // Quit
                        filewriter.close();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input type");
                scanner.next(); // Clearing scanner buffer
            }
        }
    }

    // Method to add student details to a CSV file
    static void AddStudentToList(int count, Student student, FileWriter filewriter) throws IOException {
        if (count == 0) {
            filewriter.write("Name,Email,Batch\n");
            filewriter.write(student.getName() + "," + student.getEmail() + "," + student.getBatch() + "\n");
        } else {
            filewriter.write(student.getName() + "," + student.getEmail() + "," + student.getBatch() + "\n");
        }
    }

    // Method to check if the entered date is in the future
    static boolean isFutureDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy h:mm a", Locale.ENGLISH);
            LocalDateTime date = LocalDateTime.parse(dateString, formatter);
            LocalDateTime currentDateTime = LocalDateTime.now();
            return date.isAfter(currentDateTime);
        } catch (Exception parsingException) {
            return false; // Parsing error or invalid format
        }
    }

    // Method to validate name format
    static boolean isNameValid(String name) {
        for (int iterator = 0; iterator < name.length(); iterator++) {
            if (name.charAt(iterator) > '0' && name.charAt(iterator) < '9') {
                return false;
            }
        }
        return true;
    }
}
