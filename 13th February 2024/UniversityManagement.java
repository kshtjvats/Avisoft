import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Abstract class representing a person
abstract class Person {
    private int age;
    private String name, uid;

    // Constructor for initializing person's attributes
    Person(String uid, int age, String name) {
        this.uid = uid;
        this.age = age;
        this.name = name;
    }

    // Getter methods for retrieving attributes
    String getUid() {
        return uid;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    // Abstract method to get details, to be implemented by subclasses
    void getDetails() {

    }
}

// Class representing a student, inheriting from Person
class Student extends Person {
    Scanner sc = new Scanner(System.in);
    int rollNo;
    List<course> Courses;

    // Constructor for initializing student's attributes
    Student(String uid, int age, String name, int rollNo, List<course> Courses) {
        super(uid, age, name);
        this.rollNo = rollNo;
        this.Courses = Courses;
    }

    // Method to display student details
    @Override
    void getDetails() {
        System.out.println("Student Details are -:");
        System.out.println("Student Name : " + getName());
        System.out.println("Student Unique ID : " + getUid());
        System.out.println("Student Age : " + getAge());
        System.out.println("Student Roll Number : " + rollNo);
        System.out.print("Courses Registered : ");
        for (int i = 0; i < Courses.size(); i++) {
            System.out.print(Courses.get(i).getCourseName() + ",");
        }
        System.out.println("");
    }
}

// Class representing a teacher, inheriting from Person
class Teacher extends Person {
    Scanner sc = new Scanner(System.in);
    int tNo;
    List<course> TCourses;

    // Constructor for initializing teacher's attributes
    Teacher(String uid, int age, String name, int tNo, List<course> Courses) {
        super(uid, age, name);
        this.tNo = tNo;
        this.TCourses = Courses;
    }

    // Method to check if a teacher can teach a specific course
    void teach(Set<String> teaches, String cid) {
        if (teaches.contains(cid) == false)
            System.out.println("Cannot teach this subject as it is not registered to teach it");
        else
            System.out.println("Teacher will teach the subject");
    }

    // Method to display teacher details
    @Override
    void getDetails() {
        System.out.println("Teacher Details are -:");
        System.out.println("Teacher Name : " + getName());
        System.out.println("Teacher Unique ID : " + getUid());
        System.out.println("Teacher Age : " + getAge());
        System.out.println("Teacher Number : " + tNo);
        System.out.print("Courses Registered to teach : ");
        for (int i = 0; i < TCourses.size(); i++) {
            System.out.print(TCourses.get(i).getCourseName() + ",");
        }
        System.out.println("");
    }
}

// Class representing a course
class course {
    private String courseCode, courseName;
    private int credits;
    List<course> AllCourse;

    // Constructor for initializing course's attributes
    course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.AllCourse = AllCourse;
    }

    // Getter methods for retrieving attributes
    String getCourseCode() {
        return courseCode;
    }

    String getCourseName() {
        return courseName;
    }

    int getCourseCredit() {
        return credits;
    }

    // Method to display course details
    void DisplayCourse() {
        System.out.println("Course Name : " + getCourseName());
        System.out.println("Course Code : " + getCourseCode());
        System.out.println("Course Credit : " + getCourseCredit());
        System.out.println("************************************");
    }
}

// Class representing a University
class University {
    Scanner sc=new Scanner(System.in);
    Scanner s = new Scanner(System.in).useDelimiter("\n");
    List<Student> students = new ArrayList<Student>();
    List<course> courses = new ArrayList<course>();
    List<course> AllCourse = new ArrayList<course>();
    Set<Integer> SetOfUid = new HashSet<Integer>();
    Set<Integer> SetOfRollNo = new HashSet<Integer>();
    Set<String> SetOfCourseNo = new HashSet<String>();
    List<Teacher> teachers = new ArrayList<Teacher>();
    List<course> Tcourses = new ArrayList<course>();
    Set<Integer> SetOfTNo = new HashSet<Integer>();
    Set<String> teaches = new HashSet<String>();
    String StudentName, uniqueID, TName, Tuid;
    int age, rollNo, tNo, tAge;

    // Method to add a student
    void addStudent() {
        System.out.println("Enter Student Name");
        StudentName = s.next();
        System.out.println("Enter Student's Unique ID (example Adhar Number)");
        uniqueID = s.next();
        System.out.println("Enter Student Age");
        age = sc.nextInt();
        System.out.println("Enter Student's Roll Number");
        rollNo = sc.nextInt();
        int x = 0;
        System.out.println("Register Subjects");
        while (x != -1) {
            DisplayAllCourses();
            System.out.println("Enter Corresponding serial number of subject to register");
            int sn = sc.nextInt();
            courses.add(AllCourse.get(sn - 1));
            System.out.println("Enter 1 to add another Subject or press -1");
            x = sc.nextInt();
        }
        if (SetOfRollNo.contains(rollNo) == false
        ) {
            students.add(new Student(uniqueID, age, StudentName, rollNo, courses));
            SetOfRollNo.add(rollNo);
        } else
            System.out.println("Cannot make this entry!");
    }

    // Method to add a teacher
    void addTeacher() {
        System.out.println("Enter Teacher Name");
        TName = s.next();
        System.out.println("Enter Teacher's Unique ID (example Adhar Number)");
        Tuid = s.next();
        System.out.println("Enter Teacher Age");
        tAge = sc.nextInt();
        System.out.println("Enter Teacher's Number");
        tNo = sc.nextInt();
        int x = 0;
        System.out.println("Register Subjects to teach");
        while (x != -1) {
            DisplayAllCourses();
            System.out.println("Enter Corresponding serial number of subject to register");
            int sn = sc.nextInt();
            Tcourses.add(AllCourse.get(sn - 1));
            teaches.add(AllCourse.get(sn - 1).getCourseCode());
            System.out.println("Enter 1 to add another Subject or press -1");
            x = sc.nextInt();
        }
        if (SetOfTNo.contains(tNo) == false) {
            teachers.add(new Teacher(Tuid, tAge, TName, tNo, Tcourses));
            SetOfTNo.add(tNo);
        } else
            System.out.println("Cannot make this entry!");
    }

    // Method to find a student
    int findStudent(List<Student> students, Set<Integer> SetOfRollNo) {
        System.out.println("Enter Student's Roll No");
        int rollNo = sc.nextInt();
        if (SetOfRollNo.contains(rollNo) == true) {
            int i = 0;
            for (i = 0; i < students.size(); i++) {
                if (students.get(i).rollNo == rollNo)
                    break;
            }
            return i;
        } else {
            System.out.println("Student does not exist");
            return -1;
        }
    }

    // Method to find a teacher
    int findTeacher(List<Teacher> teachers, Set<Integer> SetOfTNo) {
        System.out.println("Enter Teacher's Number");
        int tNo = s.nextInt();
        if (SetOfTNo.contains(tNo) == true) {
            int i = 0;
            for (i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).tNo == tNo)
                    break;
            }
            return i;
        } else {
            System.out.println("Teacher does not exist");
            return -1;
        }
    }

void AddCourseToStudent() {
    // Find the index of the student
    int ind = findStudent(students, SetOfRollNo);
    boolean flag = true;
    if (ind != -1) {
        // Display available courses
        DisplayAllCourses();
        System.out.println("Enter Course serial number to add to Student's record");
        int serialNo = sc.nextInt();
        String s1 = AllCourse.get(serialNo - 1).getCourseCode();
        // Check if the course is already registered for the student
        for (int j = 0; j < students.get(ind).Courses.size(); j++) {
            String s2 = students.get(ind).Courses.get(j).getCourseCode();
            if (s1.equals(s2)) {
                flag = false;
                break;
            }
        }
        if (flag == true)
            students.get(ind).Courses.add(AllCourse.get(serialNo - 1));
        else
            System.out.println("Course already registered");
    }
}

void AddCourseToTeacher() {
    // Find the index of the teacher
    int ind = findTeacher(teachers, SetOfTNo);
    boolean flag = true;
    if (ind != -1) {
        // Display available courses
        DisplayAllCourses();
        System.out.println("Enter Course serial number to add to Teacher's record");
        int serialNo = sc.nextInt();
        String s1 = AllCourse.get(serialNo - 1).getCourseCode();
        // Check if the course is already registered for the teacher
        for (int j = 0; j < teachers.get(ind).TCourses.size(); j++) {
            String s2 = teachers.get(ind).TCourses.get(j).getCourseCode();
            if (s1.equals(s2)) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            // Update the list of courses the teacher teaches
            teaches.add(AllCourse.get(ind).getCourseCode());
            teachers.get(ind).TCourses.add(AllCourse.get(serialNo - 1));
        } else
            System.out.println("Course already registered");
    }
}

void addCourse() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter course name");
    String courseName = s.next();
    System.out.println("Enter course code");
    String courseCode = s.next();
    System.out.println("Enter course credits");
    int credits = sc.nextInt();
    if (SetOfCourseNo.contains(courseCode) == false) {
        // Add the course to the list of all courses
        SetOfCourseNo.add(courseCode);
        AllCourse.add(new course(courseCode, courseName, credits));
    }
}

void DisplayAllCourses() {
    // Display all available courses
    System.out.println("List of available Courses are :");
    for (int i = 0; i < AllCourse.size(); i++) {
        System.out.println("Course " + (i + 1));
        AllCourse.get(i).DisplayCourse();
    }
}

void DisplayDetails() {
    // Display details of a student
    int ind = findStudent(students, SetOfRollNo);
    if (ind != -1) {
        students.get(ind).getDetails();
    }
}

void TeacherDisplayDetails() {
    // Display details of a teacher
    int ind = findTeacher(teachers, SetOfTNo);
    if (ind != -1) {
        teachers.get(ind).getDetails();
    }
}

void removeCourse() {
    // Remove a course from a student's record
    int ind = findStudent(students, SetOfRollNo);
    if (ind != -1) {
        System.out.println("Courses Registered for Student is");
        for (int i = 0; i < students.get(ind).Courses.size(); i++) {
            System.out.println(i + 1 + " : " + students.get(ind).Courses.get(i).getCourseName());
        }
        System.out.println("Enter serial number corresponding to course to be removed");
        int c = sc.nextInt();
        if (c > students.get(ind).Courses.size())
            System.out.println("Invalid Choice");
        else {
            students.get(ind).Courses.remove(students.get(ind).Courses.get(c - 1));
            System.out.println("Course Removed");
        }
    }
}

void TremoveCourse() {
    // Remove a course from a teacher's record
    int ind = findTeacher(teachers, SetOfTNo);
    if (ind != -1) {
        System.out.println("Courses Registered for Teacher is");
        for (int i = 0; i < teachers.get(ind).TCourses.size(); i++) {
            System.out.println((i + 1) + " : " + teachers.get(ind).TCourses.get(i).getCourseName());
        }
        System.out.println("Enter serial number corresponding to course to be removed");
        int c = sc.nextInt();
        if (c > teachers.get(ind).TCourses.size() + 1)
            System.out.println("Invalid Choice");
        else {
            teachers.get(ind).TCourses.remove(students.get(ind).Courses.get(c - 1));
            System.out.println("Course Removed");
        }
    }
}

void makeTeach() {
    // Make a teacher teach a course
    int ind = findTeacher(teachers, SetOfTNo);
    DisplayAllCourses();
    System.out.println("Enter Serial number corresponding to subject to teach");
    int sNo = sc.nextInt();
    String courseID = AllCourse.get(ind).getCourseCode();
    Teacher t = new Teacher(Tuid, tAge, TName, tNo, Tcourses);
    t.teach(teaches, courseID);
}

void DisplayAllStudents() {
    // Display details of all students
    for (int i = 0; i < students.size(); i++)
        students.get(i).getDetails();
}

void DisplayTeachers() {
    // Display details of all teachers
    for (int i = 0; i < teachers.size(); i++)
        teachers.get(i).getDetails();
}
}
class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create an instance of the University
        University u = new University();
        int ch = 0;
        while (ch != -1) {
            // Display menu options
            System.out.println("Enter a choice");
            System.out.println("1 : Add Course to University Database");
            System.out.println("2 : To Add Student");
            System.out.println("3 : Display Student Details");
            System.out.println("4 : Unregister a Student for a course");
            System.out.println("5 : Enroll Student to an additional course");
            System.out.println("6 : Display All University Courses");
            System.out.println("7 : Add Teacher");
            System.out.println("8 : Display Teacher Details");
            System.out.println("9 : Enroll additional course to a teacher");
            System.out.println("10 : Remove Teacher's Course");
            System.out.println("11 : To make teacher teach a course");
            System.out.println("12 : To show all Students");
            System.out.println("13 : To show all Teachers");
            // Take user input for choice
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Number of Courses to be added");
                    int n = sc.nextInt();
                    // Add courses to the university database
                    for (int i = 0; i < n; i++)
                        u.addCourse();
                    break;
                case 2:
                    // Add a student to the university
                    u.addStudent();
                    break;
                case 3:
                    // Display details of a student
                    u.DisplayDetails();
                    break;
                case 4:
                    // Unregister a student for a course
                    u.removeCourse();
                    break;
                case 5:
                    // Enroll a student to an additional course
                    u.AddCourseToStudent();
                    break;
                case 6:
                    // Display all university courses
                    u.DisplayAllCourses();
                    break;
                case 7:
                    // Add a teacher to the university
                    u.addTeacher();
                    break;
                case 8:
                    // Display details of a teacher
                    u.TeacherDisplayDetails();
                    break;
                case 9:
                    // Enroll additional course to a teacher
                    u.AddCourseToTeacher();
                    break;
                case 10:
                    // Remove a teacher's course
                    u.TremoveCourse();
                    break;
                case 11:
                    // Make a teacher teach a course
                    u.makeTeach();
                    break;
                case 12:
                    // Display details of all students
                    if (u.students.size() == 0)
                        System.out.println("List Empty");
                    else
                        u.DisplayAllStudents();
                    break;
                case 13:
                    // Display details of all teachers
                    if (u.teachers.size() == 0)
                        System.out.println("List Empty");
                    else
                        u.DisplayTeachers();
                    break;
                default:
                    break;
            }
        }
    }
}
