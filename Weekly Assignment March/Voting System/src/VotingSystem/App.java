package VotingSystem;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
class NegativeNumberException extends Exception
{
NegativeNumberException(String message)
{
    super(message);
}
}

class App{
    UserRegistration u=new UserRegistration();
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)throws NegativeNumberException  {
        UserRegistration userRegistration=new UserRegistration();
        Users user=new Users(null, null, null, null,null);
        List<Users>VoterList=user.readRegisteredUsers("src/VotingSystem/VoterList.csv");
        List<Candidate>candidateList=new ArrayList<Candidate>();
        List<Candidate>LiveList=new ArrayList<Candidate>();
        int status=0;
        Admin a=new Admin();
        int ApplicationChoice=0;
        int counter=0;
        try{
        while(ApplicationChoice!=4)
        {
        System.out.println("Enter a choice");
        System.out.println("1 : User Panel");
        System.out.println("2 : Admin Panel");
        System.out.println("3 : To exit");
        try{
        ApplicationChoice=scanner.nextInt();
        if(ApplicationChoice<0)
        throw new NegativeNumberException("Negative Numbers Not Allowed");
        switch (ApplicationChoice) {
            case 1:
            int choiceForUser=0;
            while(choiceForUser!=5)
            {
                System.out.println(" Enter a choice : ");
                System.out.println("1 : Register For Voting");
                System.out.println("2 : Cast Vote");
                System.out.println("3 : Change Password");
                System.out.println("4 : Recover Blocked ID");
                System.out.println("5 : Exit to Main menu");
                choiceForUser=scanner.nextInt();
                if(choiceForUser<0)
                throw new NegativeNumberException("Negative numbers not allowed");
                switch (choiceForUser) {
                    case 1:
                    if(status!=1)
                    {
                    userRegistration.checkForCredentials(counter);
                    VoterList=user.readRegisteredUsers("src/VotingSystem/VoterList.csv");
                    counter++;
                    }
                    else
                    System.out.println("Cannot Register as Voting has started");
                    break;
                    case 2:
                    if(counter>=1)
                    userRegistration.voterLogin(VoterList,LiveList);
                    else
                    System.out.println("No active registered users");
                    break;
                    case 3:
                    userRegistration.changePassword(VoterList);
                    break;
                    case 4:
                    userRegistration.RecoverAccount(VoterList);
                    default:
                        break;
                }  
            }   
            break;
            case 2:
            if(a.adminLogin())
            {
            int choiceForAdmin=0;
            if(choiceForAdmin<0)
            throw new NegativeNumberException("Negative Numbers not allowed");
            while (choiceForAdmin!=8){
            System.out.println(" Enter a choice : ");
            System.out.println("1 : Elect Candidates");
            System.out.println("2 : Remove a Candidate");
            System.out.println("3 : Set Voting Live");
            System.out.println("4 : Cast My Vote");
            System.out.println("5 : End Election and declare resuts");
            System.out.println("6 : Show Elected Candidates");
            System.out.println("7 : Unblock a UID");
            System.out.println("8 : Exit");
            choiceForAdmin=scanner.nextInt();
            switch (choiceForAdmin) {
            case 1:
            if(status==0)
            candidateList=a.addCandidate(VoterList); 
            else
            System.out.println("Cannot Elect as Voting has started");
            break;
            case 2:
            if(status==0)
            a.removeFromVotingList(candidateList);
            else
            System.out.println("Cannot Elect as Voting has started");
            break;
            case 3:
            if(candidateList.size()!=0)
            {
            if(candidateList.size()>=3)
            {
            LiveList=candidateList;
            status=1;
            }
            else
            System.out.println("Too Less candidates to conduct election");
            }
            else
            System.out.println("Voting list Empty");
            break;
            case 4:
            a.AdminsVote(LiveList);
            break;
            case 5:
            userRegistration.DeclareWinner(candidateList);
            LiveList=null;
            status=0;
            candidateList=null;
            VoterList=null;
            break;
            case 6:
            for(Candidate cand:candidateList)
            {
                cand.showCandidateDetails();
            }
            break;
            case 7:
            a.unblockUid(userRegistration.blockedUids);
            break;
            default:
            break;
        }
        }
    }
    default:
    break;
           
        }
    }
    catch(NegativeNumberException negativeNumberException)
            {
                System.err.println(negativeNumberException.getMessage());
            }
    }
}
catch(InputMismatchException inputMismatchException)
{
    System.err.println("Invalid entry , you are trying to enter an invalid input");
    scanner.nextLine();
    main(args);
}  
    }
}