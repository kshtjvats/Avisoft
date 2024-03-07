package VotingSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VotingSystem.UserManual.Users;
class UserManual
{
class Users 
{
Scanner scanner=new Scanner(System.in);
private String name,password,uniqueId,dateOfBirth,voteSymbol;
Users(String name,String password,String  uniqueId,String dateOfBirth)
{
    this.name=name;
    this.password=password;
    this.uniqueId=uniqueId;
    this.dateOfBirth=dateOfBirth;
}
void SetPassword(String Password)
{
    this.password=Password;
}
String getName()
{
    return name;
}
int getAge()
{
    UserRegistration user=new UserRegistration();
    return user.ageCalculator(dateOfBirth);
}
String getUserId()
{
    return uniqueId;
}
void setVotingSymbol(String voteSymbol)
{
    this.voteSymbol=voteSymbol;
}
void showUserDetails()
{
    System.out.println("***************************");
    System.out.println("Employee ID : "+getUserId());
    System.out.println("Employee Name : "+getName());
    System.out.println("Employee Age : "+getAge()+" years");
    System.out.println("***************************");
}
void Vote(List<Candidate>candidates)
{
    if(candidates.size()==0)
    {
    System.out.println("Voting not Live");
    return;
    }
    for(Candidate candidate:candidates)
    {
        candidate.showCandidateDetails();
    }
    System.out.println("Enter the voting symbol to cast Vote");
    String voteSymbol=scanner.next();
    setVotingSymbol(voteSymbol);
}
}
List<Users>readRegisteredUsers(String filepath) {
    List<Users>registeredUsers=new ArrayList<Users>();
    String csvSplitBy = ",";
    try (BufferedReader bufferReader = new BufferedReader(new FileReader(filepath))) {
        bufferReader.readLine(); // Skip header line

        // Read each line of the CSV file
        String line;
        while ((line = bufferReader.readLine()) != null) {
            // Split the line into fields using the CSV separator
            String[] data = line.split(csvSplitBy);

            // Store data into the map (assuming data[0] is key and data[1] is value)
            Users user=new Users(data[2],data[1],data[0],data[3]);
            registeredUsers.add(user);
        }
    } catch (FileNotFoundException fileNotFoundException) {
        // Print error message if the file is not found
        System.err.println("File not found: " + fileNotFoundException.getMessage());
    } catch (IOException ioException) {
        // Print error message for other I/O errors
        System.err.println("Error reading file: " + ioException.getMessage());
    }

    // Return the map containing credentials
    return registeredUsers;
}
}
class Main{
    public static void main(String[] args) {
        UserRegistration u=new UserRegistration();
        u.checkForCredentials();
        UserManual r=new UserManual();
        List<Users>ls=r.readRegisteredUsers("src/VotingSystem/VoterList.csv");
        List<Candidate>c=new ArrayList<Candidate>();
        Admin a=new Admin();
        a.addCandidate(ls);
        /*System.out.println("Registered Users -:");
        for(Users us:ls)
        {
        us.showUserDetails();

        }*/
    }
}
