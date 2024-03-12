package VotingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Admin { // Declaring a public class named Admin
    
        // Declaring useful sets to verify unique values of symbols and ensuring candidates are not added twice
        Set<String> AddedCandidates = new HashSet<>(); // Set to store added candidate IDs
        Set<String> takenSymbols = new HashSet<>(); // Set to store taken voting symbols
        List<Candidate> CandidateList = new ArrayList<Candidate>(); // List to store candidate objects
        private String id = "ASadmin", password = "Avisoft", votingSymbol = "null"; // setting password and ID for Admin
        Set<String> symbolsforVoting = new HashSet<>(Arrays.asList("@", "#", "$", "%", "*", "^")); // Set to store valid voting symbols
        
        // Getters and setters for retrieving some basic admin details
        String getPassword() {
            return password;
        }
    
        String getId() {
            return id;
        }
    
        String getVotingSymbol() {
            return votingSymbol;
        }
    
        void setSymbol(String symbol) {
            this.votingSymbol = symbol;
        }
    
        // Function to cast admin's vote
        void AdminsVote(List<Candidate> candidates) {
            List<String> VotingSymbols = new ArrayList<String>(); // List to store voting symbols for display
            // Checking if the admin has already voted or if voting is live
            if (getVotingSymbol().equals("null")) {
                // Checking if there are candidates to vote for
                if (candidates.size() == 0) {
                    System.out.println("Voting not Live");
                    return;
                }
                // Displaying available candidates and their voting symbols
                for (Candidate candidate : candidates) {
                    candidate.showCandidateDetails();
                    VotingSymbols.add(candidate.getVotingSymbol());
                }
    
                System.out.println("Enter the voting symbol to cast Vote"); // Prompting admin to input the voting symbol
                String voteSymbol = scanner.next(); // Reading admin's input
    
                if (VotingSymbols.contains(voteSymbol)) { // Checking if the input symbol is valid
                    setSymbol(voteSymbol); // Setting admin's voting symbol
                    int index = 0;
                    for (Candidate candidate : candidates) { // Incrementing vote count for the chosen candidate
                        if (candidate.getVotingSymbol().equals(voteSymbol))
                            break;
                        else
                            index++;
                    }
                    candidates.get(index).IncrementVote();
                } else
                    System.out.println("Invalid Vote, Logging Out!"); // Displaying message for invalid vote
            } else
                System.out.println("Already Voted!"); // Displaying message if admin has already voted
            System.out.println("LIVE VOTE COUNT:"); // Displaying live vote count
            for (Candidate candidate : candidates) {
                System.out.println(candidate.getName() + ":" + candidate.getVoteCount()); // Printing each candidate's vote count
            }
        }
    
        // Method to validate admin login credentials
        boolean adminLogin() {
            System.out.println("Enter Admin ID");
            String id = scanner.next(); // Reading admin ID input
            System.out.println("Enter Password");
            String password = scanner.next(); // Reading admin password input
            if (getPassword().equals(password)) // Comparing input password with admin password
                return true;
            else
                return false;
        }
    
        Scanner scanner = new Scanner(System.in); // Creating Scanner object for user input
    
        // Method to add a candidate to the voting system
        List<Candidate> addCandidate(List<Users> user) {
            System.out.println("Enter UID to add a Candidate"); // Prompting admin to enter candidate's UID
            String uid = scanner.next(); // Reading admin's input
            if (!AddedCandidates.contains(uid)) { // Checking if the candidate is not already added
                int flag = 0, index = 0;
                for (Users u : user) { // Checking if the given UID corresponds to a user
                    if (u.getUserId().equals(uid)) {
                        flag = 1;
                        break;
                    }
                    index++;
                }
                if (flag == 0) { // If the UID doesn't match any user
                    System.out.println("No such user present");
                    return CandidateList; // Returning current candidate list
                }
                Candidate candidate = new Candidate(user.get(index).getName(), user.get(index).getUserId(), user.get(index).getAge()); // Creating a candidate object
                System.out.println("Enter a voting symbol for this Candidate"); // Prompting admin to enter candidate's voting symbol
                String symbol = scanner.next(); // Reading admin's input
                if (!symbolsforVoting.contains(symbol)) // Checking if the entered symbol is valid
                    System.out.println("Choosing an invalid symbol"); // Displaying message for invalid symbol
                else {
                    if (!takenSymbols.contains(symbol)) { // Checking if the symbol is not already taken
                        candidate.setSymbol(symbol); // Setting candidate's voting symbol
                        CandidateList.add(candidate); // Adding candidate to the candidate list
                        AddedCandidates.add(uid); // Adding UID to the set of added candidates
                        takenSymbols.add(symbol); // Adding symbol to the set of taken symbols
                        System.out.println("Candidate added to voting list"); // Displaying message for successful addition
                    } else
                        System.out.println("Symbol already taken up"); // Displaying message if symbol is already taken
                }
            } else
                System.out.println("Already Registered!"); // Displaying message if candidate is already registered
            return CandidateList; // Returning current candidate list
        }
    
        // Method to remove a candidate from the voting system
        void removeFromVotingList(List<Candidate> candidateList) {
            if (candidateList.size() == 0) { // Checking if the candidate list is empty
                System.out.println("Voter List Empty!"); // Displaying message if candidate list is empty
                return;
            }
            System.out.println("Enter the Unique ID of candidate to be removed"); // Prompting admin to enter candidate's UID
            String uid = scanner.next(); // Reading admin's input
            int index = 0, flag = 0;
            for (Candidate candidate : candidateList) { // Searching for the candidate with the given UID
                if (candidate.getUserId().equals(uid)) {
                    flag = 1;
                    break;
                } else
                    index++;
            }
            if (flag == 1) { // If the candidate with given UID is found
                takenSymbols.remove(candidateList.get(index).getVotingSymbol()); // Removing the candidate's voting symbol from the set of taken symbols
                candidateList.remove(index); // Removing candidate from the candidate list
                AddedCandidates.remove(uid); // Removing UID from the set of added candidates
            }
        }
    
        // Method to unblock a blocked UID
        void unblockUid(Set<String> blockedUid) {
            System.out.println("Enter the uid to be unblocked"); // Prompting admin to enter the UID to be unblocked
            String uid = scanner.next(); // Reading admin's input
            if (blockedUid.contains(uid)) { // Checking if the given UID is blocked
                blockedUid.remove(uid); // Removing the UID from the set of blocked UIDs
                System.out.println("UID Unblocked!"); // Displaying message for successful unblocking
            } else
                System.out.println("No such uid present"); // Displaying message if the given UID is not blocked
        }
    
    }