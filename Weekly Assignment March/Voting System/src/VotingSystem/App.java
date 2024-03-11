// Package containing classes related to the voting system
package VotingSystem;

// Importing necessary libraries
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Custom exception for negative numbers
class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}

// Main application class
class App {
    // Creating an instance of UserRegistration class
    UserRegistration u = new UserRegistration();
    // Creating a scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) throws NegativeNumberException {
        // Creating an instance of UserRegistration class
        UserRegistration userRegistration = new UserRegistration();
        // Creating a Users object with null values
        Users user = new Users(null, null, null, null, null);
        // Reading registered users from file into a list
        List<Users> VoterList = user.readRegisteredUsers("src/VotingSystem/VoterList.csv");
        // Creating lists for candidates and live candidates
        List<Candidate> candidateList = new ArrayList<Candidate>();
        List<Candidate> LiveList = new ArrayList<Candidate>();
        // Variable to track status of voting
        int status = 0;
        // Creating an instance of Admin class
        Admin a = new Admin();
        // Variable to store user's application choice
        int ApplicationChoice = 0;
        // Counter for registered users
        int counter = 0;

            // Loop for application choices
            while (ApplicationChoice != 3) {
                // Displaying options for the user
                System.out.println("Enter a choice");
                System.out.println("1 : User Panel");
                System.out.println("2 : Admin Panel");
                System.out.println("3 : To exit");

                try {
                    // Reading user's choice
                    ApplicationChoice = scanner.nextInt();
                    if (ApplicationChoice < 0)
                    throw new NegativeNumberException("Negative Numbers Not Allowed");
                }
                catch(InputMismatchException inputMismatchException)
                {
                    System.err.println("Invalid entry type");
                    scanner.nextLine();
                }
                catch(NegativeNumberException negativeNumberException)
                {
                    System.err.println("Negative numbers not allowed");
                    scanner.nextLine();
                }
                    // Handling negative number exception

                   

                    // Switch case based on user's choice
                    switch (ApplicationChoice) {
                        case 1:
                            // Submenu for user panel
                            int choiceForUser = 0;
                            while (choiceForUser != 5) {
                                System.out.println(" Enter a choice : ");
                                System.out.println("1 : Register For Voting");
                                System.out.println("2 : Cast Vote");
                                System.out.println("3 : Change Password");
                                System.out.println("4 : Recover Blocked ID");
                                System.out.println("5 : Exit to Main menu");
                                try{
                                choiceForUser = scanner.nextInt();
                                if (choiceForUser < 0)
                                throw new NegativeNumberException("Negative numbers not allowed");
                                }
                                catch(InputMismatchException inputMismatchException)
                                {
                                    System.err.println("Invalid input");
                                    scanner.nextLine();
                                }
                                catch(NegativeNumberException negativeNumberException)
                                 {
                                 System.err.println("Negative numbers not allowed");
                                scanner.nextLine();
                                }
                                // Handling negative number exception
                                
                                
                                // Switch case based on user's submenu choice
                                switch (choiceForUser) {
                                    case 1:
                                        // Registering for voting
                                        if (status != 1) {
                                            userRegistration.checkForCredentials(counter);
                                            VoterList = user.readRegisteredUsers("src/VotingSystem/VoterList.csv");
                                            counter++;
                                        } else
                                            System.out.println("Cannot Register as Voting has started");
                                        break;
                                    case 2:
                                        // Casting vote
                                        if (counter >= 1)
                                            userRegistration.voterLogin(VoterList, LiveList);
                                        else
                                            System.out.println("No active registered users");
                                        break;
                                    case 3:
                                        // Changing password
                                        userRegistration.changePassword(VoterList);
                                        break;
                                    case 4:
                                        // Recovering blocked ID
                                        userRegistration.RecoverAccount(VoterList);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case 2:
                            // Admin panel
                            if (a.adminLogin()) {
                                int choiceForAdmin = 0;

                                // Submenu for admin panel
                                while (choiceForAdmin != 8) {
                                    System.out.println(" Enter a choice : ");
                                    System.out.println("1 : Elect Candidates");
                                    System.out.println("2 : Remove a Candidate");
                                    System.out.println("3 : Set Voting Live");
                                    System.out.println("4 : Cast My Vote");
                                    System.out.println("5 : End Election and declare resuts");
                                    System.out.println("6 : Show Elected Candidates");
                                    System.out.println("7 : Unblock a UID");
                                    System.out.println("8 : Exit");
                                    try{
                                    choiceForAdmin = scanner.nextInt();
                                    if (choiceForAdmin < 0)
                                    throw new NegativeNumberException("Negative Numbers not allowed");
                                    }
                                    catch(InputMismatchException inputMismatchException)
                                    {
                                        System.err.println("Invalid input");
                                        scanner.nextLine();
                                    }
                                    catch(NegativeNumberException negativeNumberException)
                                     {
                                     System.err.println("Negative numbers not allowed");
                                    scanner.nextLine();
                                    }
                                    // Handling negative number exception
                                
                                    // Switch case based on admin's submenu choice
                                    switch (choiceForAdmin) {
                                        case 1:
                                            // Electing candidates
                                            if (status == 0)
                                                candidateList = a.addCandidate(VoterList);
                                            else
                                                System.out.println("Cannot Elect as Voting has started");
                                            break;
                                        case 2:
                                            // Removing a candidate
                                            if (status == 0)
                                                a.removeFromVotingList(candidateList);
                                            else
                                                System.out.println("Cannot Elect as Voting has started");
                                            break;
                                        case 3:
                                            // Setting voting live
                                            if (candidateList.size() != 0) {
                                                if (candidateList.size() >= 3) {
                                                    LiveList = candidateList;
                                                    status = 1;
                                                } else
                                                    System.out.println("Too Less candidates to conduct election");
                                            } else
                                                System.out.println("Voting list Empty");
                                            break;
                                        case 4:
                                            // Admin casting vote
                                            a.AdminsVote(LiveList);
                                            break;
                                        case 5:
                                            // Declaring winner and resetting data
                                            userRegistration.DeclareWinner(candidateList);
                                            LiveList = null;
                                            status = 0;
                                            candidateList = null;
                                            VoterList = null;
                                            break;
                                        case 6:
                                            // Showing elected candidates
                                            for (Candidate cand : candidateList) {
                                                cand.showCandidateDetails();
                                            }
                                            break;
                                        case 7:
                                            // Unblocking a UID
                                            a.unblockUid(userRegistration.blockedUids);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            } else
                                System.out.println("Invalid Credentials");
                            break;
                            case 3:
                            break;
                        default:
                            break;
                    }
                } 
                }
            }
        

