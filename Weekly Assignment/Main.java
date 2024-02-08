import java.io.*;
abstract class Employee{
private String name;
private int hourlyRate;
Employee(String name,int hourlyRate)
{
    this.name=name;
    this.hourlyRate=hourlyRate;
}
public int getHourlyRate()
{
    return hourlyRate;
}
public String getName()
{
    return name;
}
public abstract int CalculateSalary();
}

class FullTimeEmployee extends Employee{
    FullTimeEmployee( String name, int hourlyRate)
    {
        super(name,hourlyRate);
    }
    public  int CalculateSalary(){
        return getHourlyRate()*(40*50);
    }
}
class PartTimeEmployee extends Employee{
    PartTimeEmployee( String name, int hourlyRate)
    {
        super(name,hourlyRate);
    }
    public int CalculateSalary(){
        return getHourlyRate()*(30*50);
    }
}
class Main{
    public static void main(String[] args)
    {
        FullTimeEmployee f=new FullTimeEmployee("Raman",100);
        PartTimeEmployee p=new PartTimeEmployee("Chaman",50);
        System.out.println("Salary of "+f.getName()+" is = "+f.CalculateSalary());
        System.out.println("Salary of "+p.getName()+" is = "+p.CalculateSalary());
    }
}