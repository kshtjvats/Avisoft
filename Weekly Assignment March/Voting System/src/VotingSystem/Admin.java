package VotingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VotingSystem.UserManual.Users;

public class Admin {
private String id="ASadmin",password="Avisoft",votingSymbol="null";
String getPassword()
{
    return password;
}
String getId()
{
    return id;
}
String getVotingSymbol()
{
    return votingSymbol;
}
void setSymbol(String symbol)
{
    this.votingSymbol=symbol;
}
void AdminsVote(List<Candidate>candidates)
{
    List<String>VotingSymbols=new ArrayList<String>();
    if(getVotingSymbol().equals("null"))
    {
    if(candidates.size()==0)
    {
    System.out.println("Voting not Live");
    return;
    }
    for(Candidate candidate:candidates)
    {
        candidate.showCandidateDetails();
        VotingSymbols.add(candidate.getVotingSymbol());
    }
    System.out.println("Enter the voting symbol to cast Vote");
    String voteSymbol=scanner.next();
    if(VotingSymbols.contains(voteSymbol))
    {
    setSymbol(voteSymbol);
    int index=0;
    for(Candidate candidate:candidates)
    {
        if(candidate.getVotingSymbol().equals(voteSymbol))
        break;
        else
        index++;
    }
    candidates.get(index).IncrementVote();
    }
    else
    System.out.println("Invalid Vote ,Logging Out!");
    }
else
System.out.println("Already Voted!");
System.out.println("LIVE VOTE COUNT:");
for(Candidate candidate:candidates)
    {
        System.out.println(candidate.getName()+":"+candidate.getVoteCount());
    }
}
boolean adminLogin()
{
    System.out.println("Enter Admin ID");
    String id=scanner.next();
    System.out.println("Enter Password");
    String password=scanner.next();
    if(getPassword().equals(password))
    return true;
    else
    return false;
}
Scanner scanner=new Scanner(System.in);
List<Candidate> addCandidate(List<Users>user)
{
List<Candidate>CandidateList=new ArrayList<Candidate>();
for(Users u:user)
{
    u.showUserDetails();
    System.out.println("Enter 1 to add as Candidate");
    int choice=scanner.nextInt();
    if(choice==1)
    {
        Candidate cand=new Candidate(u.getName(),u.getUserId(),u.getAge());
        System.out.println("Enter a voting symbol for this Candidate");
        String sym=scanner.next();
        cand.setSymbol(sym);
        CandidateList.add(cand);
    }
}
return CandidateList;
}
}
