package VotingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// Class responsible for user registration and management
public class UserRegistration {
    Scanner scanner = new Scanner(System.in);

    // CSVParser object to parse CSV files
    CSVParser parser = new CSVParser();

    // Map to store user credentials (UID as key, password as value)
    Map<String, String> credentials = parser.convertCsvToMap("src/VotingSystem/UserData.csv");

    // Set to store blocked credentials
    Set<String> blockedCredentials = new HashSet<>();

    // Set to store blocked UIDs
    Set<String> blockedUids = new HashSet<>();

    // Set to store registered UIDs
    Set<String> registeredUsers = new HashSet<>();

    // Method to check user credentials and register new users
    void checkForCredentials(int csvCounter) {
        // Counter to track if VoterList.csv is created or not
        String[][] credentialArray = new String[credentials.size()][3]; // 2D array to hold credentials
        int indexOfArray = 0;

        // Convert credentials map to a 2D array for easy access
        for (String key : credentials.keySet()) {
            String value = credentials.get(key);
            credentialArray[indexOfArray][0] = key; // UID
            credentialArray[indexOfArray][1] = value; // DOB
            indexOfArray++;
        }

        // Obtain user UID and verify credentials
        System.out.println("Enter your AviSoft UID:");
        String uniqueId = scanner.next();

        if (!credentials.containsKey(uniqueId)) {
            System.out.println("You are not an AviSoft Employee!");
            return;
        } else if (registeredUsers.contains(uniqueId)) {
            System.out.println("You are already a registered user.");
            return;
        } else if (blockedUids.contains(uniqueId)) {
            System.out.println("Cannot register with a blocked UID.");
            return;
        } else {
            // Obtain user password and validate
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
                int flag = 0;
                if (password.equals(credentialArray[index][1])) {
                    if (ageCalculator(password) >= 18) {
                        Set<String> numbers = new HashSet<>();
                        for (int digit = 0; digit < 10; digit++) {
                            numbers.add(String.valueOf(digit));
                        }
                        System.out.println("Login Successful!");
                        System.out.println("Enter your Name:");
                        String name = scanner.next();
                        for (String s : numbers) {
                            if (name.contains(s)) {
                                System.out.println("Invalid name");
                                return;
                            }
                        }
                        credentialArray[index][2] = name;
                        int flagValue = 0;
                        if (csvCounter == 0) {
                            flagValue = createVoterList(credentialArray, index);
                        } else {
                            flagValue = addToVoterList(credentialArray, index);
                        }
                        csvCounter++;
                        if (flagValue == 1) {
                            registeredUsers.add(uniqueId);
                            System.out.println("Registration Successful!");
                        }
                        return;
                    } else {
                        System.out.println("Cannot Register as your age is less than 18");
                        break;
                    }
                } else {
                    if (++counter == 3) {
                        blockedUids.add(uniqueId);
                        System.out.println("UID Blocked");
                        continue;
                    }
                    System.out.println("Wrong password try again (" + (3 - counter) + " attempts left)");
                }
            }
        }
    }

    // Method to create voter list CSV file
    int createVoterList(String[][] credentialArray, int index) {
        int flag = 0;
        try (FileWriter writer = new FileWriter("src/VotingSystem/VoterList.csv")) {
            writer.write("UID,Password,Name,D.O.B,Sectert Question Answer\n"); // CSV header
            System.out.println("Enter your Password for Voting panel login:");
            String password1 = scanner.next();
            System.out.println("Re-Enter your Password:");
            String password2 = scanner.next();
            if (password1.equals(password2)) {
                writer.write(credentialArray[index][0] + "," + password1 + "," + credentialArray[index][2] + "," + credentialArray[index][1]);
                System.out.println("Answer this Secret question for password Recovery : What is the name of your favourite movie?");
                String answer = scanner.next();
                writer.write("," + answer + "\n");
                flag = 1;
            } else {
                System.out.println("Passwords do not Match! Registration not completed");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    // Method to append data to voter list CSV file
    int addToVoterList(String[][] credentialArray, int index) {
        String filePath = "src/VotingSystem/VoterList.csv";
        int flag = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            System.out.println("Enter your Password for Voting panel login:");
            String password1 = scanner.next();
            System.out.println("Re-Enter your Password:");
            String password2 = scanner.next();
            if (password1.equals(password2)) {
                writer.append(credentialArray[index][0] + "," + password1 + "," + credentialArray[index][2] + "," + credentialArray[index][1]);
                System.out.println("Answer this Secret question for password Recovery : What is the name of your favourite movie?");
                String answer = scanner.next();
                writer.write("," + answer + "\n");
                flag = 1;
            } else {
                System.out.println("Passwords do not Match! Registration not completed");
            }
        } catch (IOException ioException) {
            System.err.println("Input Mismatch Exception" );
        }
        return flag;
    }

    // Method to get row and column count of a CSV file
    public static int[] getRowCountAndColumnCount(String filePath) {
        int[] result = new int[2];
        result[0] = 0; // Initialize row count
        result[1] = -1; // Initialize column count to -1

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the first line to determine the number of columns
            if ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                result[1] = columns.length;
                result[0]++; // Increment row count for the first line
            }

            // Count the remaining rows
            while ((line = bufferedReader.readLine()) != null) {
                result[0]++;
            }
        } catch (IOException ioException) {
           System.err.println("No files found");;
        }

        return result;
    }

    // Method to recover a blocked account
    void RecoverAccount(List<Users> users) {
        if (blockedCredentials.size() == 0) {
            System.out.println("No Accounts blocked");
            return;
        }
        System.out.println("Enter the UID of the account to be recovered");
        String uid = scanner.next();
        if (!blockedCredentials.contains(uid))
            System.out.println("Trying to recover a non-blocked Account");
        else {
            for (Users user : users) {
                if (user.getUserId().equals(uid)) {
                    System.out.println("Enter the answer to this question:");
                    System.out.println("Name of your favorite movie");
                    String ans = scanner.next();
                    if (user.getSecretQnAnswer().equals(ans))
                        blockedCredentials.remove(uid);
                    else
                    {
                        System.out.println("Incorrect");
                        return;
                    }
                    break;
                }
            }
        }
    }

    // Method to change password
    void changePassword(List<Users> VoterList) {
        System.out.println("Enter the Unique ID");
        String uid = scanner.next();
        if (blockedCredentials.contains(uid)) {
            System.out.println("UID is blocked");
            return;
        }
        int index = 0, flag = 0, counter = 0;
        for (Users user : VoterList) {
            if (user.getUserId().equals(uid)) {
                flag = 1;
                break;
            }
            index++;
        }
        if (flag == 1) {
            while (counter < 3) {
                System.out.println("Enter the old Password");
                String pass = scanner.next();
                if (pass.equals(VoterList.get(index).getPassword())) {
                    System.out.println("Enter the new Password");
                    String firstPasswordAttempt = scanner.next();
                    System.out.println("Re-Enter the new Password");
                    String secondPasswordAttempt = scanner.next();
                    if (firstPasswordAttempt.equals(secondPasswordAttempt)) {
                        int[] sizeOfCsv = getRowCountAndColumnCount("src/VotingSystem/VoterList.csv");
                        String[][] Alldata = new String[sizeOfCsv[0] - 1][sizeOfCsv[1]];
                        int countOfIndex = 0;
                        String csvSplitBy = ",";
                        try {
                            BufferedReader bufferReader = new BufferedReader(new FileReader("src/VotingSystem/VoterList.csv"));
                            bufferReader.readLine(); // Skip header line
                            // Read each line of the CSV file
                            String line;
                            while ((line = bufferReader.readLine()) != null) {
                                String[] data = line.split(csvSplitBy);
                                Alldata[countOfIndex] = data;
                                countOfIndex++;
                            }
                            bufferReader.close();
                            int iterator = 0;
                            FileWriter writer = new FileWriter("src/VotingSystem/VoterList.csv");
                            writer.write("UID,Password,Name,D.O.B,Sectert Question Answer\n");
                            while (iterator < Alldata.length) {
                                String UidAtIndex = Alldata[iterator][0].toString();
                                if (UidAtIndex.equals(uid)) {
                                    // Split the line into fields using the CSV separator
                                    Alldata[iterator][1] = firstPasswordAttempt;
                                }
                                writer.write(String.join(",", Alldata[iterator]) + "\n");
                                iterator++;
                            }
                            writer.close();
                            bufferReader.close();
                            for (Users user : VoterList) {
                                if (user.getUserId().equals(uid))
                                    user.SetPassword(firstPasswordAttempt);
                            }
                        } catch (FileNotFoundException fileNotFoundException) {
                            // Print error message if the file is not found
                            System.err.println("File not found: " + fileNotFoundException.getMessage());
                        } catch (IOException ioException) {
                            // Print error message for other I/O errors
                            System.err.println("Error reading file: " + ioException.getMessage());
                        }
                        break;
                    } else {
                        System.out.println("New Passwords do not match!");
                        return;
                    }
                } else {
                    if (++counter == 3) {
                        blockedCredentials.add(uid);
                        System.out.println("UID Blocked");
                        break;
                    }
                    System.out.println("Wrong password try again (" + (3 - counter) + " attempts left)");
                }
            }
        }
    }

    // Method to calculate age from date of birth
    int ageCalculator(String dobString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMuuuu");
        LocalDate dob = LocalDate.parse(dobString, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }

    // Method for user to login and vote
    void voterLogin(List<Users> VoterList, List<Candidate> candidateList) {
        int counter=0;
        System.out.println("Enter your registered UID");
        String uid = scanner.next();
        if(blockedCredentials.contains(uid))
        {
        System.out.println("Cannot Login with a blocked uid");
        return;
        }
        int flag = -1;
        for (Users user : VoterList) {
            if (user.getUserId().equals(uid)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("UID Not Registered");
        else {
            while(counter<=3)
            {
            System.out.println("Enter Password");
            String password = scanner.next();
            int flagForPassword = -1;
            for ( Users user: VoterList) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Login Successful!");
                    flagForPassword = 0;
                    user.Vote(candidateList);
                    return;
                }
            }
            if (flagForPassword == -1) {
                if (++counter == 3) {
                    blockedCredentials.add(uid);
                    System.out.println("UID Blocked");
                    break;
                }
                System.out.println("Wrong password try again (" + (3 - counter) + " attempts left)");
        }
    }
    }
    }
    // Method to declare the winner of the election
    void DeclareWinner(List<Candidate> candidateList) {
        int max = 0;
        Candidate winner = new Candidate(null, null, 0);
        for (Candidate candidate : candidateList) {
            if (candidate.getVoteCount() > max) {
                winner = candidate;
                max = candidate.getVoteCount();
            }
        }
        System.out.println("Winner of election is: " + winner.getName() + " with " + winner.getVoteCount() + " votes!");
    }
}
