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
private String name,password,uniqueId,dateOfBirth,voteSymbol="null";
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
String getPassword()
{
    return password;
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
String getVotingSymbol()
{
    return voteSymbol;
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
    setVotingSymbol(voteSymbol);
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



