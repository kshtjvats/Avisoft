package VotingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VotingSystem.UserManual.Users;

public class Admin {
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
