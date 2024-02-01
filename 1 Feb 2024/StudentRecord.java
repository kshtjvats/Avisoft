import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord{
   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Student> st=new ArrayList<Student>();
        ArrayList<Student> topper=new ArrayList<Student>();
        ArrayList<Student> specialCare=new ArrayList<Student>();
        ArrayList<Student> avg=new ArrayList<Student>();
        /*StudentRecord ob=new StudentRecord();*/
        int ut;
        int lt;
        int c;
        System.out.println("Enter upper Threshold");
        ut=sc.nextInt();
        System.out.println("Enter lower Threshold");
        lt=sc.nextInt();
        addStudent(st);
        analyze(st,topper,specialCare,avg,ut,lt);
        while(true)
        {
            System.out.println("Enter a choice ");
            System.out.println("1 to check toppers, 2 to check special case students & 3 to check average students");
            c=sc.nextInt();
            if(c==-1)
            break;
        switch (c) {
            case 1:
                PrintToppers(topper);
                break;
            case 2:
                PrintSpecialCare(specialCare);
                break;
            case 3:
                Printavg(avg);
                break;
            default:
                break;
        }
    }
    }
    static void analyze(ArrayList<Student>st,ArrayList<Student>topper,ArrayList<Student>specialCare,ArrayList<Student>avg,int ut,int lt)
    {
        int marks=0;
        for(int i=0;i<st.size();i++)
        {
            marks=(st.get(i).java+st.get(i).dbms+st.get(i).os)/3;
            System.out.println("Marks of "+st.get(i).name+"="+marks);
            if(marks>=ut)
            {
                topper.add(st.get(i));
            }
            else if(marks<lt)
            {
                specialCare.add(st.get(i));
            }
            else if(marks<ut&&marks>lt&&isFail(st.get(i).java,st.get(i).dbms,st.get(i).os)==true)
            {
                specialCare.add(st.get(i));
            }
            else if (marks<ut&&marks>lt&&isFail(st.get(i).java,st.get(i).dbms,st.get(i).os)==false) {
                avg.add(st.get(i));
            }
            marks=0;
        }
    }
    static void PrintToppers(ArrayList<Student>topper)
    {
        System.out.println("List of toppers is -:");
        int max=0;
        String nm="";
        for(int i=0;i<topper.size();i++)
        {
            int marks=(topper.get(i).java+topper.get(i).os+topper.get(i).dbms)/3;
            System.out.println(topper.get(i).name);
            if(marks>max)
            {
                max=marks;
                nm=topper.get(i).name;
            }
            System.out.println("OVERALL TOPPER IS : "+nm);
        }

    }
    static void PrintSpecialCare(ArrayList<Student>specialCare)
    {
        System.out.println("List of Student needing special attention is -:");
        for(int i=0;i<specialCare.size();i++)
        {
            System.out.println(specialCare.get(i).name);
        }
    }
    static void Printavg(ArrayList<Student>avg)
    {
        System.out.println("List of avg student is -:");
        for(int i=0;i<avg.size();i++)
        {
            System.out.println(avg.get(i).name);
        }
    }
    static boolean isFail(int java,int dbms,int os)
    {
        if(java<40||os<40||dbms<40)
        return true;
        else
        return false;
    }
    static void addStudent(ArrayList<Student>st)
    {
        String s;
        int rollNo;
        String name;
        int java;
        int dbms;
        int os;
        boolean flag=true;
        while(flag==true)
        {
            System.out.println("Want to add student? Press y to add and any other character to terminate");
            //s=sc.next().charAt(0);
            s=sc.next();
            if(s.charAt(0)=='Y'||s.charAt(0)=='y')
            {
                System.out.println("Enter student Name,Roll Number,marks in java,dbms & os line by line");
                name=sc.next();
                rollNo=sc.nextInt();
                java=sc.nextInt();
                dbms=sc.nextInt();
                os=sc.nextInt();
                if(java>100||java<0||os>100||os<0||dbms>100||dbms<0)
                System.out.println("Cant make this! Try again");
                else
                st.add(new Student(rollNo,name,java,dbms,os));
            }
            else
            {
                flag=false;
            break;
        }
    }
}
}
class Student{
int rollNo;
String name;
int java;
int dbms;
int os;
Student(int rollNo,String name,int java,int dbms,int os)
{
    this.rollNo=rollNo;
    this.dbms=dbms;
    this.java=java;
    this.name=name;
    this.os=os;
}
}