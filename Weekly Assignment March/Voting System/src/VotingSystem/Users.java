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
    }
    System.out.println("Enter the voting symbol to cast Vote");
    String voteSymbol=scanner.next();
    setVotingSymbol(voteSymbol);
}
else
System.out.println("Already Voted!");
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
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        UserRegistration u=new UserRegistration();
        u.checkForCredentials();
        UserManual r=new UserManual();
        List<Users>ls=r.readRegisteredUsers("src/VotingSystem/VoterList.csv");
        List<Candidate>c=new ArrayList<Candidate>();
        Admin a=new Admin();
        c=a.addCandidate(ls);
        int choice=0;
        while(choice!=-1)
        {
        VoterLogin(ls, c);
        System.out.println("Enter -1 to quit or any other key to vote ");
        choice=scanner.nextInt();
        }
        for(Users user:ls)
        {
        System.out.println(user.getName() +"Voted for symbol "+user.getVotingSymbol());
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
    }

