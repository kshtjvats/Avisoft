package FileHandle.src;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Student implements Serializable {
    private int age;
    private String name, student_id;

    Student(int age, String name, String student_id) {
        this.age = age;
        this.name = name;
        this.student_id = student_id;
    }

    String getName() {
        return name;
    }

    String getSid() {
        return student_id;
    }

    int getAge() {
        return age;
    }
}

class Operations {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    Scanner n = new Scanner(System.in);

    List<Student> students = new ArrayList<Student>();
    List<Student> deserializedStudents = new ArrayList<>();
    Set<String>uid=new HashSet<String>();
    void addStudent(Set<String>uid) throws Exception {
        System.out.println("Enter Student name");
        String name = sc.next();
        System.out.println("Enter Student Uid");
        String sid = sc.next();
        if(uid.contains(sid)==true)
        {
        throw new Exception("Student with this uid exist");
        }
        else
        {
        uid.add(sid);
        System.out.println("Enter Student age");
        int age = n.nextInt();
        students.add(new Student(age, name, sid));
        }
    }
    int SearchStudent( List<Student> deserializedStudents,String id,Set<String>uid) throws Exception
    {
    if(uid.contains(id)==false)
    throw new Exception("No such Student Exist");
    else
    {
        int i=0;
        for(i=0;i<deserializedStudents.size();i++)
        {
            if(deserializedStudents.get(i).getSid().equals(id))
            break;
        }
        return i;
    }
    }
}

class FileHandler {
    String fileName = "Students.dat";

    void serialize(List<Student> students) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(students);
            oos.close();
            file.close();
            System.out.println("Students Serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    List<Student> deserialize() {
        List<Student> deserializedStudents = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            deserializedStudents = (List<Student>)in.readObject();
            in.close();
            file.close();
            System.out.println("Students Deserialized");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException is caught");
        }
        return deserializedStudents;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();
        Set<String> uid = new HashSet<String>();

        // Deserialize the students list at the beginning
        FileHandler f = new FileHandler();
        List<Student> deserializedStudents = f.deserialize();

        // Populate the uid set with IDs from deserializedStudents
        for (Student student : deserializedStudents) {
            uid.add(student.getSid());
        }

         int c = 0;
        while (c != -1) {
            System.out.println("ENTER A CHOICE : ");
            System.out.println("1 : ADD A STUDENT ");
            System.out.println("2 : DISPLAY A STUDENT ");
            System.out.println("3 : DISPLAY ALL  STUDENTS");
            c = sc.nextInt();

            switch (c) {
                case 1:
                    try {
                        op.addStudent(uid);
                        f.serialize(op.students);
                        // After adding a new student, update the deserializedStudents list
                        deserializedStudents = f.deserialize();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        // Access the deserialized list to display students
                        System.out.println("Enter student id to search");
                        String id = sc.next();
                        int x = op.SearchStudent(deserializedStudents, id, uid);
                        if (x != -1) {
                            System.out.println("Student Found:");
                            System.out.println("Name: " + deserializedStudents.get(x).getName() +
                                    ", ID: " + deserializedStudents.get(x).getSid() +
                                    ", Age: " + deserializedStudents.get(x).getAge());
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("All Students:");
                        for (Student student : deserializedStudents) {
                            System.out.println("Name: " + student.getName() +
                                    ", ID: " + student.getSid() +
                                    ", Age: " + student.getAge());
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
