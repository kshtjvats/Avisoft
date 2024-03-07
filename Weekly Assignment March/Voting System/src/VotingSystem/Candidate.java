package VotingSystem;

public class Candidate {
    private String name,uniqueId;
    private int age;
    private String VotingSymbol="";
    Candidate(String name,String  uniqueId,int age)
    {
        this.name=name;
        this.uniqueId=uniqueId;
        this.age=age;
    }
void setSymbol(String VotingSymbol)
{
    this.VotingSymbol=VotingSymbol;
}
int getAge()
{
    return age;
}
String getUserId()
{
    return uniqueId;
}
String getName()
{
    return name;
}
String getVotingSymbol()
{
    return VotingSymbol;
}
void showCandidateDetails()
{
    System.out.println("***************************");
    System.out.println("Employee ID : "+getUserId());
    System.out.println("Employee Name : "+getName());
    System.out.println("Employee Age : "+getAge()+" years");
    System.out.println("Voting Symbol : "+getVotingSymbol());
    System.out.println("***************************");
}
}
