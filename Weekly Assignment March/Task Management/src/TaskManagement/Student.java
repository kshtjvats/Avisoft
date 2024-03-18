package TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
Scanner scanner=new Scanner(System.in);
private String name,email,password,batch;
List<Task>myTasks;
List<Student>studentList=new ArrayList<Student>();
Student(String name,String email,String password,String batch)
{
    this.name=name;
    this.email=email;
    this.password=password;
    this.batch=batch;
}
void assignTask(List<Task>Tasks)
{
    this.myTasks=Tasks;
}
String getName()
{
    return name;
}
String getEmail()
{
    return email;
}
String getBatch()
{
    return batch;
}
void SubmitTask()
{
if(myTasks.size()!=0)
{
System.out.println("Enter the serial number corresponding to Task");
int serialNumber=scanner.nextInt();
if(serialNumber>myTasks.size())
{
System.out.println("Task does not exist");
return;
}
else
{
    System.out.println("Enter 1 to submit task");
    int command=scanner.nextInt();
    if(command==1)
    myTasks.get(serialNumber).setDoneStatus();
}
}
else
System.out.println("No tasks to submit");
}
void showUpcomingWork(List<Task>myTasks)
{
    List<Task>upcoming=new ArrayList<Task>();
    if(myTasks.size()==0)
    System.out.println("Wohoo! no work due");
    else
    {
        for(Task t:myTasks)
        {
            if(t.deadlineCalculator()==1)
            {
            t.showDetailsOfTask();
            upcoming.add(t);
            }
        }
        for(Task t:upcoming)
        {
        Thread oneMinuteThread = new Thread(() -> t.oneMinuteCalculate());
        oneMinuteThread.start();
        }
    }
}
Student addStudent()
{
System.out.println("Enter Student email");
String email=scanner.next();
System.out.println("Enter Student name");
String name=scanner.next();
System.out.println("Enter Password");
String password=scanner.next();
System.out.println("Enter Batch");
String batch=scanner.next();
return new Student(name,email,password,batch);
}
}
