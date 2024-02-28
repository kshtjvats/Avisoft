package DeepComparision;
enum Priority{
    HIGH,MEDIUM,LOW;
}
class Student {
private String name;
private int age;
private String rollNumber;
private Priority priority;
public Student(String name,int age,String Roll_Number,Priority priority)
{
    this.name=name;
    this.age=age;
    this.priority=priority;
}
String getName()
{
    return name;
}
int getAge()
{
    return age;
}
String getRollNumber()
{
    return rollNumber;
}
Priority getPriority()
{
    return priority;
}
}
