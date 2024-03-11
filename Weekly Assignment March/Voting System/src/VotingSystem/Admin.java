package VotingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Admin {
Set<String>AddedCandidates=new HashSet<>();
Set<String>takenSymbols=new HashSet<>();
List<Candidate>CandidateList=new ArrayList<Candidate>();
private String id="ASadmin",password="Avisoft",votingSymbol="null";
Set<String>symbolsforVoting=new HashSet<>(Arrays.asList("@","#","$","%","*","^"));
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
System.out.println("Enter UID to add a Candidate");
String uid=scanner.next();
if(!AddedCandidates.contains(uid))
{
int flag=0,index=0;
for(Users u:user)
{
if(u.getUserId().equals(uid))
{
    flag=1;
    break;
}
index++;
}
if(flag==0)
{
    System.out.println("No such user present");
    return CandidateList;
}
Candidate cand=new Candidate(user.get(index).getName(),user.get(index).getUserId(),user.get(index).getAge());
System.out.println("Enter a voting symbol for this Candidate");
String symbol=scanner.next();
if(!symbolsforVoting.contains(symbol))
System.out.println("Choosing an invalid symbol");
else
{
if(!takenSymbols.contains(symbol))
{
cand.setSymbol(symbol);
CandidateList.add(cand);
AddedCandidates.add(uid);
takenSymbols.add(symbol);
System.out.println("Candidate added to voting list");
}
else
System.out.println("Symbol already taken up");
}
}
else
System.out.println("Already Registered!");
return CandidateList;
}
void removeFromVotingList(List<Candidate>candidateList)
{
if(candidateList.size()==0)
{
    System.out.println("Voter List Empty!");
    return;
}
System.out.println("Enter the Unique ID of candidate to be removed");
String uid=scanner.next();
int index=0,flag=0;
for(Candidate candidate:candidateList)
{
if(candidate.getUserId().equals(uid))
{
flag=1;
break;
}
else
index++;
}
if(flag==1)
{
    takenSymbols.remove(candidateList.get(index).getVotingSymbol());
    candidateList.remove(index);
    AddedCandidates.remove(uid);
}
}
void unblockUid(Set<String>blockedUid)
{
    try{
    System.out.println("Enter the uid to be unblocked");
    String uid=scanner.next();
    if(blockedUid.contains(uid))
    {
    blockedUid.remove(uid);
    System.out.println("UID Unblocked!");
    }
    else
    System.out.println("No such uid present");
}
catch(InputMismatchException inputMismatchException)
{
    System.err.println("Invalid input type");
    return;
}
}
}
