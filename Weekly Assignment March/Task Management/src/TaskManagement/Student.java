package TaskManagement;

import java.util.ArrayList;
import java.util.List;

public class Student {
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
            t.oneMinuteCalculate();
        }
    }
}
}
class Main
    {
        public static void main(String[] args) {
            List<Task>tasks=new ArrayList<Task>();
            Task t=new Task("Task1","14 March 2024 4:29 PM");
            tasks.add(t);
            Task t2=new Task("Task2","14 March 2024 4:30 PM");
            tasks.add(t2);
            Student s=new Student("Kshitij","kshtij.vats@avisoft.io","hiKv","java");
            s.showUpcomingWork(tasks);
        }
    }

