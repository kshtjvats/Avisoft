package TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    Scanner scanner=new Scanner(System.in);
private String name,email,password,batch;
List<Task>myTasks;
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
void SubmitTask()
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
}
