package TaskManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Portal {
static Scanner scanner=new Scanner(System.in);
public static void main(String[] args) throws IOException {
    List<Student>listOfStudents=new ArrayList<Student>();
    int count=0;
    Set<String>emails=new HashSet<String>();
    int choiceForSwitch=0;
    while(choiceForSwitch!=4)
    {
        System.out.println("Enter a choice\n1 : Admin Login\n2 : Student Registeration\n3:  Registeration\n4 : Quit");
        choiceForSwitch=scanner.nextInt();
        switch (choiceForSwitch) {
            case 1:
                
            break;
            case 2:
            System.out.println("Enter your Email");
            String email=scanner.next();
            if(!emails.contains(email))
            {
            emails.add(email);
            System.out.println("Enter your name");
            String name=scanner.next();
            System.out.println("Enter Password");
            String password1=scanner.next();
            System.out.println("Enter your Batch");
            String Batch=scanner.next();
            Student student=new Student(name,email,password1,Batch);
            listOfStudents.add(student);
            AddStudentToList(count,student);
            System.out.println("Student Successfully Registered");
            count++;
            }
            else
            System.out.println("A student with this credential exist!");
            break;
            case 3:
                
            break;
            default:
                break;
        }
    }
}
static void AddStudentToList(int count,Student student) throws IOException
{
FileWriter filewriter=new FileWriter("src/TaskManagement/list.csv",true);
if(count==0)
{
filewriter.write("Name,Email,Batch\n"); 
filewriter.write(student.getName()+","+student.getEmail()+","+student.getBatch());
}
else
{
filewriter.write(student.getName()+","+student.getEmail()+","+student.getBatch());
}
filewriter.close();
}
}
