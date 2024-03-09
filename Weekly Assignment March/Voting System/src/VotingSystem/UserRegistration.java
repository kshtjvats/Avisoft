package VotingSystem;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class UserRegistration {
    Scanner scanner = new Scanner(System.in);
    CSVParser parser=new CSVParser();
    Map<String,String>credentials=parser.convertCsvToMap("src/VotingSystem/UserData.csv");
    // Method to check user credentials
    void checkForCredentials(int csvCounter) {
        int choice = 0;
        // Counter to track if VoterList.csv is created or not
        Set<String> blockedUids = new HashSet<>(); // Set to store blocked UIDs
        Set<String> registeredUsers = new HashSet<>(); // Set to store registered UIDs
        String[][] credentialArray = new String[credentials.size()][3]; // 2D array to hold credentials
        int indexOfArray = 0;

        // Convert credentials map to a 2D array for easy access
        for (String key : credentials.keySet()) {
            String value = credentials.get(key);
            credentialArray[indexOfArray][0] = key; // UID
            credentialArray[indexOfArray][1] = value; // DOB
            indexOfArray++;
        }

        while (choice != -1) {
            System.out.println("Enter your AviSoft UID:");
            String uniqueId = scanner.next();

            if (!credentials.containsKey(uniqueId)) {
                System.out.println("You are not an AviSoft Employee!");
            } else if (registeredUsers.contains(uniqueId)) {
                System.out.println("You are already a registered user.");
            } else if (blockedUids.contains(uniqueId)) {
                System.out.println("Cannot register with a blocked UID.");
            } else {
                int index = 0;
                for (String element : credentials.keySet()) {
                    if (element.equals(uniqueId)) {
                        break;
                    }
                    index++;
                }

                int counter = 0;
                while (counter < 3) {
                    System.out.println("Enter your password (Your Password is your D.O.B of format ddMmYYYY):");
                    String password = scanner.next();
                    int flag=0;
                    if (password.equals(credentialArray[index][1])){
                        if(ageCalculator(password) >= 18)
                        {
                        System.out.println("Login Successful!");
                        System.out.println("Enter your Name:");
                        credentialArray[index][2] = scanner.next();
                        if (csvCounter == 0) {
                            flag=createVoterList(credentialArray, index);
                        } else {
                            flag=addToVoterList(credentialArray, index);
                        }
                        csvCounter++;
                        if(flag==1)
                        registeredUsers.add(uniqueId);
                        break;
                    }
                    else
                    {
                    System.out.println("Cannot Register as your age is less than 18");
                    break;
                    }
                 } else {
                        if (++counter == 3) {
                            blockedUids.add(uniqueId);
                            System.out.println("UID Blocked");
                            break;
                        }
                        System.out.println("Wrong password try again (" + (3 - counter) + " attempts left)");
                    }
                }
            }
            System.out.println("Enter -1 to exit or press any other key to continue");
            choice = scanner.nextInt();
        }
    }

    // Method to create voter list CSV file
    int createVoterList(String[][] credentialArray, int index) {
        int flag=0;
        try (FileWriter writer = new FileWriter("src/VotingSystem/VoterList.csv")) {
            writer.write("UID,Password,Name,D.O.B\n"); // CSV header
            System.out.println("Enter your Password for Voting panel login:");
            String password1 = scanner.next();
            System.out.println("Re-Enter your Password:");
            String password2 = scanner.next();
            if (password1.equals(password2)) {
                writer.write(credentialArray[index][0] + "," + password1 + "," + credentialArray[index][2] +","+credentialArray[index][1] +"\n");
                flag=1;
            }
            else
            {
            System.out.println("Passwords do not Match ! Regestration not completed");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    // Method to append data to voter list CSV file
    int addToVoterList(String[][] credentialArray, int index) {
        String filePath = "src/VotingSystem/VoterList.csv";
        int flag=0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            System.out.println("Enter your Password for Voting panel login:");
            String password1 = scanner.next();
            System.out.println("Re-Enter your Password:");
            String password2 = scanner.next();
            if (password1.equals(password2)) {
                writer.append(credentialArray[index][0] + "," + password1 + "," + credentialArray[index][2] +","+credentialArray[index][1]+"\n");
                flag=1;
            }
            else
            System.out.println("Passwords do not Match ! Regestration not completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Method to calculate age from date of birth
    int ageCalculator(String dobString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMuuuu");
        LocalDate dob = LocalDate.parse(dobString, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }
}

