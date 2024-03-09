package VotingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VotingSystem.UserManual.Users;
class App{
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        UserRegistration u=new UserRegistration();
        UserManual r=new UserManual();
        List<Users>ls=r.readRegisteredUsers("src/VotingSystem/VoterList.csv");
        List<Candidate>c=new ArrayList<Candidate>();
        List<Candidate>LiveList=new ArrayList<Candidate>();
        Admin a=new Admin();
        int ApplicationChoice=0;
        int counter=0;
        while(ApplicationChoice!=3)
        {
        System.out.println("Enter a choice");
        System.out.println("1 : User Panel");
        System.out.println("2 : Admin Panel");
        System.out.println("3 : To exit");
        ApplicationChoice=scanner.nextInt();
        switch (ApplicationChoice) {
            case 1:
            int choiceForUser=0;
            while(choiceForUser!=3)
            {
                System.out.println(" Enter a choice : ");
                System.out.println("1 : Register For Voting");
                System.out.println("2 : Cast Vote");
                System.out.println("3 : Exit to Main menu");
                choiceForUser=scanner.nextInt();
                switch (choiceForUser) {
                    case 1:
                    u.checkForCredentials(counter);
                    ls=r.readRegisteredUsers("src/VotingSystem/VoterList.csv");
                    counter++;
                    break;
                    case 2:
                    if(counter>=1)
                    VoterLogin(ls,LiveList);
                    else
                    System.out.println("No active registered users");
                    break;
                    default:
                        break;
                }  
            }   
            break;
            case 2:
            if(a.adminLogin())
            {
            int choiceForAdmin=0;
            while (choiceForAdmin!=6){
            System.out.println(" Enter a choice : ");
            System.out.println("1 : Elect Candidates");
            System.out.println("2 : Remove a Candidate");
            System.out.println("3 : Set Voting Live");
            System.out.println("4 : Cast My Vote");
            System.out.println("5 : End Election and declare resuts");
            System.out.println("6 : Exit to Main menu");
            choiceForAdmin=scanner.nextInt();
            switch (choiceForAdmin) {

            case 1:
            c=a.addCandidate(ls); 
            break;
            case 3:
            if(c.size()!=0)
            LiveList=c;
            else
            System.out.println("Voting list Empty");
            break;
            case 4:
            a.AdminsVote(LiveList);
            break;
            case 5:
            DeclareWinner(c);
            LiveList=null;
            break;
            default:
                break;
        }
        }
    }
            break;
            default:
                break;
        }
    }
        
    }

    static void VoterLogin(List<Users>ls,List<Candidate>c)
    {
        System.out.println("Enter your registered UID");
        String uid=scanner.next();
        int flag=-1;
        for(Users u:ls)
        {
            if(u.getUserId().equals(uid))
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        System.out.println("UID Not Registered");
        else
        {
            System.out.println("Enter Password");
            String password=scanner.next();
            int flagForPassword=-1;
            for(Users u:ls)
            {
            if(u.getPassword().equals(password))
            {
                System.out.println("Login Succesful!");
                flagForPassword=0;
                u.Vote(c);
                break;
            }
        }
            if(flagForPassword==-1)
            {
                System.out.println("Incorrect Password!");
            }
        }
        }
       static void DeclareWinner(List<Candidate>c)
        {
          int max=0;
          Candidate winner=new Candidate(null, null, 0);
          for(Candidate candidate:c)
          {
            if(candidate.getVoteCount()>max)
            {
            winner=candidate;
            max=candidate.getVoteCount();
          }
        }
          System.out.println("Winner of election is : "+winner.getName()+" with "+winner.getVoteCount()+" votes!");
        }
    }
