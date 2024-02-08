import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmployeeData{
    static Set<Integer>id=new HashSet<Integer>();
   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Employee> emp=new ArrayList<Employee>();
        while(true)
        {
            System.out.println("Enter a choice ");
            System.out.println("1 : Add Employees");
            System.out.println("2 : Remove Employee");
            System.out.println("3 : Update Records");
            System.out.println("4 : Display Specific Employee Data");
            System.out.println("5 : Display All Employee Data");
            System.out.println("6 : Search Employee");
            System.out.println("7 : Sort Employee by Salary");
            System.out.println("-1 : To Terminate");
            int choice=sc.nextInt();
            int u;
            if(choice==-1)
            break;
        switch (choice) {
            case 1:
                addEmployee(emp);
                break;
            case 2:
                System.out.println("Enter UID");
                u=sc.nextInt();
                RemoveEmployee(emp,u);
                System.out.println("Updated Records-");
                DisplayAll(emp);
                break;
            case 3:
                System.out.println("Enter UID");
                u=sc.nextInt();
                Update(emp,u);
                System.out.println("Updated Records-");
                DisplayAll(emp);
                break;
            case 4:
                System.out.println("Enter UID");
                u=sc.nextInt();
                DisplayOne(emp,u);
                break;
            case 5:
                DisplayAll(emp);
                break;
            case 6:
               SearchEmployees(emp);
               break;
            case 7:
               PrintSorted(emp);
               break;
            default:
                break;
        }
    }
    }
    static void addEmployee(ArrayList<Employee>emp)
    {
        String name;
        String s;
        int uid;
        String role;
        String pos;
        double salary;
        int exp;
        double ts;
        boolean flag=true;
        while(flag==true)
        {
            System.out.println("Want to add employee? Press y to add and any other character to terminate");
            //s=sc.next().charAt(0);
            s=sc.next();
            if(s.charAt(0)=='Y'||s.charAt(0)=='y')
            {
                System.out.println("Enter Employee Name,UID(unique),Role,position and salary and total experience in months");
                name=sc.next();
                if(isNameCorrect(name)==false)
                {
                    System.out.println("Cant make this entry ! Try again");
                    continue;
                }
                uid=sc.nextInt();
                if(id.contains(uid)==true)
                {
                    System.out.println("Cant make this entry ! Try again");
                    continue;
                }
                else
                id.add(uid);
                role=sc.next();
                pos=sc.next();
                salary=sc.nextDouble();
                exp=sc.nextInt();
                ts=salary*exp;
                emp.add(new Employee(name, uid, role,pos, salary, exp, ts));
            }
            else
            {
                flag=false;
            break;
        }
    }
}
static void RemoveEmployee(ArrayList<Employee>emp,int x)
{
for(int i=0;i<emp.size();i++)
{
    if(emp.get(i).uid==x)
    {
    emp.remove(emp.get(i));
    break;
    }
}
for(int i=0;i<emp.size();i++)
{
    if(emp.get(i).uid==x)
    {
    emp.remove(emp.get(i));
    break;
    }
}
}
static void DisplayOne(ArrayList<Employee>emp,int x)
{
for(int i=0;i<emp.size();i++)
{
    if(emp.get(i).uid==x)
    {
        System.out.println("*************************************");
        System.out.println("Employee information is");
        System.out.println("Name : "+emp.get(i).name);
        System.out.println("UID : "+emp.get(i).uid);
        System.out.println("Role : "+emp.get(i).role);
        System.out.println("Position : "+emp.get(i).pos);
        System.out.println("Salary : "+emp.get(i).salary);
        System.out.println("Experience : "+emp.get(i).exp+" Months");
        System.out.println("Total Salary got : "+emp.get(i).ts);
        System.out.println("*************************************");
        break;
    }
}
}
static void DisplayAll(ArrayList<Employee>emp)
{
    System.out.println("Employee information are");
for(int i=0;i<emp.size();i++)
{
        System.out.println("Name : "+emp.get(i).name);
        System.out.println("UID : "+emp.get(i).uid);
        System.out.println("Role : "+emp.get(i).role);
        System.out.println("Position : "+emp.get(i).pos);
        System.out.println("Salary : "+emp.get(i).salary);
        System.out.println("Experience : "+emp.get(i).exp+" Months");
        System.out.println("Total Salary got : "+emp.get(i).ts);
        System.out.println("********************************************************");
}
    }
static void SearchEmployees(ArrayList<Employee>emp)
    {
    System.out.println("Enter 1 to search by names,2 to search by position & 3 to search by position range ");
    int c=sc.nextInt();
    switch (c) {
        case 1:
            System.out.println("Enter name");
            String x=sc.next();
            for(int i=0;i<emp.size();i++)
            {
                if(emp.get(i).name.equals(x))
                {
                    System.out.println("Employees found");
                    DisplayOne(emp,emp.get(i).uid);
                }
            }
            break;
            case 2:
            System.out.println("Enter Role");
            String r=sc.next();
            for(int i=0;i<emp.size();i++)
            {
                if(emp.get(i).role.equals(r))
                {
                    System.out.println("Employees found");
                    DisplayOne(emp,emp.get(i).uid);
                }
            }
            break;
            case 3:
            System.out.println("Enter Upper Salary Range");
            double us=sc.nextDouble();
            for(int i=0;i<emp.size();i++)
            {
                if(emp.get(i).salary<=us)
                {
                    System.out.println("Employees found");
                    DisplayOne(emp,emp.get(i).uid);

                }
            }
            break;
        default:
            break;
    }
    }
    static void Update(ArrayList<Employee>emp,int x)
    {
    int ind=0;
    for(int i=0;i<emp.size();i++)
    {
        if(emp.get(i).uid==x)
        {
        ind=i;
        break;
        }
    }
    System.out.println("Enter 1 to update name,2 to update uid,3 to update role,4 to update position ,5 to update salary & 6 to update experience");
    int c=sc.nextInt();
    switch (c) {
        case 1:
            System.out.println("Enter new name");
            emp.get(ind).name=sc.next();
            break;
            
            case 2:
            System.out.println("Enter new uid");
            int nid=sc.nextInt();
            if(id.contains(nid))
            System.out.println("Invalid choice , uid exists");
            else
            emp.get(ind).uid=nid;
            break;
            
            case 3:
            System.out.println("Enter new role");
            emp.get(ind).role=sc.next();
            break;

            case 4:
            System.out.println("Enter new position");
            emp.get(ind).pos=sc.next();
            break;

            case 5:
            System.out.println("Enter new Salary");
            emp.get(ind).salary=sc.nextDouble();
            break;

            case 6:
            System.out.println("Enter new experience in months");
            emp.get(ind).exp=sc.nextInt();
            emp.get(ind).ts=emp.get(ind).exp*emp.get(ind).salary;
            break;

            default:
            break;
    }
    }
static boolean isNameCorrect(String name)
{
    for(int i=0;i<name.length();i++)
                {
                    if(name.charAt(i)<65||name.charAt(i)>126)
                    return false;
                }
                return true;
}
static void PrintSorted(ArrayList<Employee>emp)
{
    ArrayList<Employee>sortSalary=new ArrayList<Employee>();
    ArrayList<Employee>nw=new ArrayList<Employee>();
    for(int i=0;i<emp.size();i++)
    {
    nw.add(emp.get(i));
    }
    while(nw.size()>0)
    {
    double max=0;
    int ind=0;
    for(int i=0;i<nw.size();i++)
    {
    if(nw.get(i).salary>max)
    {
    max=nw.get(i).salary;
    ind=i;
    }
}
    sortSalary.add(nw.get(ind));
    nw.remove(nw.get(ind));
}
for(int i=0;i<sortSalary.size();i++)
{
    DisplayOne(sortSalary,sortSalary.get(i).uid);
}
}
}
class Employee{
    String name;
    int uid;
    String role;
    String pos;
    double salary;
    int exp;
    double ts;


Employee(String name,int uid,String role,String pos,double salary,int exp,double ts)
{
    this.name=name;
    this.uid=uid;
    this.role=role;
    this.pos=pos;
    this.salary=salary;
    this.exp=exp;
    this.ts=ts;
}
}