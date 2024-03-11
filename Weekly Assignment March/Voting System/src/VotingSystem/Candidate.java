package VotingSystem;

// Class representing a candidate in the voting system
public class Candidate {
    // Private attributes
    private String name, uniqueId;
    private int age, votes = 0;
    private String VotingSymbol = "";

    // Constructor to initialize candidate attributes
    Candidate(String name, String uniqueId, int age) {
        this.name = name;
        this.uniqueId = uniqueId;
        this.age = age;
    }

    // Method to set the voting symbol for the candidate
    void setSymbol(String VotingSymbol) {
        this.VotingSymbol = VotingSymbol;
    }

    // Method to retrieve the age of the candidate
    int getAge() {
        return age;
    }

    // Method to retrieve the unique identifier of the candidate
    String getUserId() {
        return uniqueId;
    }

    // Method to increment the vote count for the candidate
    void IncrementVote() {
        this.votes++;
    }

    // Method to retrieve the total vote count for the candidate
    int getVoteCount() {
        return votes;
    }

    // Method to retrieve the name of the candidate
    String getName() {
        return name;
    }

    // Method to retrieve the voting symbol associated with the candidate
    String getVotingSymbol() {
        return VotingSymbol;
    }

    // Method to display the details of the candidate
    void showCandidateDetails() {
        // Displaying candidate details
        System.out.println("***************************");
        System.out.println("Employee ID : " + getUserId());
        System.out.println("Employee Name : " + getName());
        System.out.println("Employee Age : " + getAge() + " years");
        System.out.println("Voting Symbol : " + getVotingSymbol());
        System.out.println("***************************");
    }
}
