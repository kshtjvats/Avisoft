package MedicalManagement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Patient> listOfPatients = new ArrayList<>();
        List<Doctor> listOfDoctors = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int counter=0;
        while (!exit) {
            try {
                System.out.println("Enter your choice:");
                System.out.println("1. Admin login");
                System.out.println("2. Doctor login");
                System.out.println("3. Patient login");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Admin login selected");

                        // Admin login logic
                        boolean adminAuthenticated = false;
                        Scanner adminScanner = new Scanner(System.in);

                        // Simulated admin credentials (replace with actual authentication logic)
                        String adminId = "admin";
                        String adminPassword = "admin123";

                        while (!adminAuthenticated) {
                            System.out.println("Enter Admin ID:");
                            String enteredAdminId = adminScanner.next();
                            System.out.println("Enter Password:");
                            String enteredAdminPassword = adminScanner.next();

                            if (enteredAdminId.equals(adminId) && enteredAdminPassword.equals(adminPassword)) {
                                adminAuthenticated = true;
                                System.out.println("Admin login successful!");

                                // Admin operations
                                boolean adminExit = false;
                                while (!adminExit) {
                                    System.out.println("Admin Menu:");
                                    System.out.println("1. Register Patient");
                                    System.out.println("2. Remove patient");
                                    System.out.println("3. Add doctor");
                                    System.out.println("4. Remove doctor");
                                    System.out.println("5. Set up appointment for a patient with a doctor");
                                    System.out.println("6. Exit");

                                    int adminChoice = adminScanner.nextInt();
                                    switch (adminChoice) {
                                        case 1:
                                            System.out.println("Adding patient...");
                                            System.out.println("Enter patient name:");
                                            String patientName = adminScanner.next();
                                            System.out.println("Enter patient email:");
                                            String patientEmail = adminScanner.next();
                                            System.out.println("Enter patient password:");
                                            String patientPassword = adminScanner.next();
                                            System.out.println("Enter patient contact number:");
                                            String contactNumber = adminScanner.next();
                                            if(contactNumber.contains("-")||contactNumber.length()!=10)
                                            {
                                                System.out.println("Invalid Phone number");
                                                break;
                                            }
                                            System.out.println("Enter patient age:");
                                            int patientAge = adminScanner.nextInt();
                                            if(patientAge<0||patientAge>110)
                                            {
                                                System.out.println("Invalid age");
                                                break;
                                            }
                                            // Create and add patient object
                                            listOfPatients.add(new Patient(patientName, patientEmail, patientPassword, contactNumber, patientAge));
                                            break;
                                        case 2:
                                            System.out.println("Removing patient...");
                                            adminScanner.nextLine(); // Consume newline
                                            System.out.println("Enter the email ID of the patient to be removed:");
                                            String emailToRemove = adminScanner.nextLine();

                                            boolean patientRemoved = false;
                                            // Iterate over the list of patients
                                            for (Patient patient : listOfPatients) {
                                                // Check if the patient's email matches the input email
                                                if (patient.getEmail().equals(emailToRemove)) {
                                                    listOfPatients.remove(patient); // Remove the patient from the list
                                                    patientRemoved = true;
                                                    System.out.println("Patient removed successfully.");
                                                    break; // Exit the loop once the patient is removed
                                                }
                                            }

                                            if (!patientRemoved) {
                                                System.out.println("No patient found with the provided email ID.");
                                            }

                                            break;
                                        case 3:
                                            System.out.println("Adding doctor...");
                                            System.out.println("Enter doctor name:");
                                            String doctorName = adminScanner.next();
                                            System.out.println("Enter doctor age:");
                                            int doctorAge = adminScanner.nextInt();
                                            adminScanner.nextLine(); // Consume newline
                                            System.out.println("Enter doctor email:");
                                            String doctorEmail = adminScanner.next();
                                            System.out.println("Enter doctor password:");
                                            String doctorPassword = adminScanner.next();
                                            System.out.println("Enter doctor specialization:");
                                            String doctorSpecialization = adminScanner.next();
                                            listOfDoctors.add(new Doctor(doctorName, doctorAge, doctorEmail, doctorPassword, doctorSpecialization));
                                            break;
                                        case 4:
                                            System.out.println("Removing doctor...");
                                            System.out.println("Enter the email ID of the doctor to be removed:");
                                            emailToRemove = adminScanner.next();
                                            adminScanner.nextLine(); // Consume newline

                                            boolean doctorRemoved = false;
                                            // Iterate over the list of doctors
                                            for (Doctor doctor : listOfDoctors) {
                                                // Check if the doctor's email matches the input email
                                                if (doctor.getEmail().equals(emailToRemove)) {
                                                    listOfDoctors.remove(doctor); // Remove the doctor from the list
                                                    doctorRemoved = true;
                                                    System.out.println("Doctor removed successfully.");
                                                    break; // Exit the loop once the doctor is removed
                                                }
                                            }

                                            if (!doctorRemoved) {
                                                System.out.println("No doctor found with the provided email ID.");
                                            }

                                            break;
                                        case 5:
                                            System.out.println("Setting up appointment...");
                                            System.out.println("Enter patient email:");
                                            String patientEmailForAppointment = adminScanner.next();
                                            adminScanner.nextLine(); // Consume newline
                                            System.out.println("Enter Symtoms with ,");
                                            String symptom = adminScanner.nextLine();

                                            System.out.println("Enter doctor specialization:");
                                            String doctorSpecializationForAppointment = adminScanner.next();
                                            adminScanner.nextLine(); // Consume newline

                                            // Check if the patient exists in the list of patients
                                            boolean patientFound = false;
                                            Patient patientForAppointment = null;
                                            for (Patient patient : listOfPatients) {
                                                if (patient.getEmail().equals(patientEmailForAppointment)) {
                                                    patientFound = true;
                                                    patientForAppointment = patient;
                                                    patient.listSymptoms(symptom);
                                                    break;
                                                }
                                            }

                                            if (!patientFound) {
                                                System.out.println("Patient with the provided email not found.");
                                                break;
                                            }

                                            // Check if the doctor exists in the list of doctors
                                            boolean doctorFound = false;
                                            Doctor doctorForAppointment = null;
                                            for (Doctor doctor : listOfDoctors) {
                                                if (doctor.getSpecialization().equals(doctorSpecializationForAppointment)) {
                                                    doctorFound = true;
                                                    doctorForAppointment = doctor;
                                                    break;
                                                }
                                            }

                                            if (!doctorFound) {
                                                System.out.println("Doctor with the provided specialization not found.");
                                                break;
                                            }

                                            // Appointment logic
                                            doctorForAppointment.addPatientToSee(patientForAppointment);
                                            patientForAppointment.visitDoctor.add(doctorForAppointment);
                                            System.out.println("Appointment set successfully!");
                                            break;
                                        case 6:
                                            System.out.println("Exiting admin menu...");
                                            adminExit = true;
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                                    }
                                }
                            } else {
                                System.out.println("Invalid credentials. Please try again.");
                            }
                        }
                        break;
                    case 2:
                    System.out.println("Doctor login selected");
                    // Doctor login logic
                    boolean doctorAuthenticated = false;
                    Scanner doctorScanner = new Scanner(System.in);

                    // Simulated doctor credentials (replace with actual authentication logic)
                    Doctor currentDoctor = null;
                    System.out.println("Enter Doctor ID:");
                    String enteredDoctorId = doctorScanner.next();
                    System.out.println("Enter Password:");
                    String enteredDoctorPassword = doctorScanner.next();

                    for (Doctor doctor : listOfDoctors) {
                        if (enteredDoctorId.equals(doctor.getEmail()) && enteredDoctorPassword.equals(doctor.getPassword())) {
                            doctorAuthenticated = true;
                            currentDoctor = doctor;
                            break;
                        }
                    }

                    if (doctorAuthenticated) {
                        System.out.println("Doctor login successful!");

                        // Doctor operations
                        boolean doctorExit = false;
                        while (!doctorExit) {
                            System.out.println("Doctor Menu:");
                            System.out.println("1. See patient details");
                            System.out.println("2. Prescribe medication to patients");
                            System.out.println("3. Exit");

                            int doctorChoice = doctorScanner.nextInt();
                            switch (doctorChoice) {
                                case 1:
                                    System.out.println("Viewing patient details...");
                                    doctorScanner.nextLine(); // Consume newline
                                    System.out.println("Enter patient email:");
                                    String patientEmail = doctorScanner.nextLine();

                                    // Check if the patient exists in the list of patients
                                    boolean patientFound = false;
                                    Patient patientDetails = null;
                                    for (Patient patient : listOfPatients) {
                                        if (patient.getEmail().equals(patientEmail)) {
                                            patientFound = true;
                                            patientDetails = patient;
                                            break;
                                        }
                                    }

                                    if (!patientFound) {
                                        System.out.println("Patient with the provided email not found.");
                                        break;
                                    }

                                    // Present options to view patient's past medical history, lab records, or past prescriptions
                                    boolean patientDetailsExit = false;
                                    while (!patientDetailsExit) {
                                        System.out.println("Patient Details Menu:");
                                        System.out.println("1. See patient's past medical history");
                                        System.out.println("2. See patient's lab records");
                                        System.out.println("3. See patient's past prescriptions");
                                        System.out.println("4. Exit");

                                        int patientDetailsChoice = doctorScanner.nextInt();
                                        switch (patientDetailsChoice) {
                                            case 1:
                                                System.out.println("Viewing patient's past medical history...");
                                                if (patientDetails.medicalHistory.size() != 0) {
                                                    for (String history : patientDetails.medicalHistory) {
                                                        System.out.println(history);
                                                    }
                                                } else
                                                    System.out.println("List empty");
                                                break;
                                            case 2:
                                                System.out.println("Viewing patient's lab records...");
                                                if (patientDetails.labRecords.size() != 0) {
                                                    for (LabRecords labRecord : patientDetails.labRecords) {
                                                        labRecord.showLabRecord();
                                                    }
                                                } else
                                                    System.out.println("List empty");
                                                break;
                                            case 3:
                                                System.out.println("Viewing patient's past prescriptions...");
                                                if (patientDetails.prescriptionList.size() != 0) {
                                                    for (Prescription prescription : patientDetails.prescriptionList) {
                                                        prescription.displayPrescription();
                                                    }
                                                } else
                                                    System.out.println("List empty");
                                                break;
                                            case 4:
                                                System.out.println("Exiting patient details menu...");
                                                patientDetailsExit = true;
                                                ;
                                                break;
                                            default:
                                                System.out.println("Invalid choice, please try again.");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Prescribing medication to patients...");
                                    int choiceToExit=0;
                                    
                                    while(choiceToExit!=1 &&counter<=currentDoctor.toSee.size())
                                    {
                                    for (Patient patient : currentDoctor.toSee) {
                                        patient.showPatientDetails();
                                        System.out.println("Enter:\n 1: To prescribe a Lab Test\n 2: To Prescribe Medicine");
                                        int choiceForDoctor = doctorScanner.nextInt(); //fixed

                                        if (choiceForDoctor == 1) {
                                            String[] Reports = {"Report Normal", "Report Abnormal"};
                                            Random random = new Random();

                                            // Generate a random number either 0 or 1
                                            int randomNumber = random.nextInt(2);
                                            System.out.println("Enter the testing category:");
                                            String testingCategory = doctorScanner.next(); //fixed
                                            patient.labRecords.add(new LabRecords(currentDoctor.getName(), testingCategory, Reports[randomNumber]));
                                            System.out.println("Lab test Prescribed");
                                            System.out.println("Lab Tests:");
                                            System.out.println("Patient Name:"+patient.getName());
                                            System.out.println("Report Category:"+testingCategory);
                                            System.out.println("Test Prescribed by:"+currentDoctor.getName());
                                            System.out.println("Test Results : "+Reports[randomNumber]);
                                            System.out.println("Prescribing Medicine now:");
                                            choiceForDoctor=2;
                                        } if (choiceForDoctor == 2) {
                                            System.out.println("Enter today's date:");
                                            String date = doctorScanner.next(); //fixed
                                            System.out.println("Enter medicine name with dose:");
                                            String medicine = doctorScanner.next(); //fixed
                                            patient.prescriptionList.add(new Prescription(medicine, date, currentDoctor.getName(),patient.getSymptoms()));
                                            patient.pastPrescriptions.add(new Prescription(medicine, date, currentDoctor.getName(),patient.getSymptoms()));
                                            patient.visitDoctor.remove(currentDoctor);
                                            System.out.println("Patient Prescribed");
                                            counter++;
                                        }
                                    }
                                    System.out.println("Enter 0 to keep seeing patients or press 1 to exit ");
                                    choiceToExit=scanner.nextInt();
                                }
                                    for(int iterator=0;iterator<counter;iterator++)
                                    {
                                        currentDoctor.toSee.remove(iterator);
                                    }
                                    counter=currentDoctor.toSee.size()-counter;
                                    break;
                                case 3:
                                    System.out.println("Exiting doctor menu...");
                                    doctorExit = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice, please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                 
                    break;
                    case 3:
                    System.out.println("Patient login selected");
                    // Patient login logic
                    boolean patientAuthenticated = false;
                    Scanner patientScanner = new Scanner(System.in);
                
                    System.out.println("Enter Patient Email:");
                    String enteredPatientEmail = patientScanner.next();
                    System.out.println("Enter Password:");
                    String enteredPatientPassword = patientScanner.next();
                
                    // Check if the patient exists in the list of patients
                    Patient currentPatient = null;
                    for (Patient patient : listOfPatients) {
                        if (patient.getEmail().equals(enteredPatientEmail) && patient.getPassword().equals(enteredPatientPassword)) {
                            patientAuthenticated = true;
                            currentPatient = patient;
                            break;
                        }
                    }
                
                    if (patientAuthenticated) {
                        System.out.println("Patient login successful!");
                
                        // Patient operations
                        boolean patientExit = false;
                        while (!patientExit) {
                            System.out.println("Patient Menu:");
                            System.out.println("1. See past prescriptions");
                            System.out.println("2. See upcoming appointments");
                            System.out.println("3. See Lab Records");
                            System.out.println("4. Add my medical history");
                            System.out.println("5. Exit");
                
                            int patientChoice = patientScanner.nextInt();
                            switch (patientChoice) {
                                case 1:
                                    System.out.println("Viewing past prescriptions...");
                                    if (currentPatient.prescriptionList.size() != 0) {
                                        for (Prescription prescription : currentPatient.pastPrescriptions) {
                                            prescription.displayPrescription();
                                        }
                                    } else {
                                        System.out.println("No past prescriptions found.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Viewing upcoming appointments...");
                                    if (currentPatient.visitDoctor.size() != 0) {
                                        for (Doctor doctor : currentPatient.visitDoctor) {
                                            System.out.println("Doctor: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
                                        }
                                    } else {
                                        System.out.println("No upcoming appointments found.");
                                    }
                                    break;
                                case 3:
                                System.out.println("Viewing my lab Reports...");
                                for(LabRecords labRecords:currentPatient.labRecords)
                                {
                                labRecords.showLabRecord();
                                }
                                break;
                                case 4:
                                 System.out.println("Enter your medical history");
                                 patientScanner.nextLine(); // Consume newline
                                 String history = patientScanner.nextLine();  // Read a single word or token
                                currentPatient.addMedicalHistory(history);
                                break;

                                case 5:
                                    System.out.println("Exiting patient menu...");
                                    patientExit = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice, please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;
                    case 4:
                        System.out.println("Exiting application...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException InputMismatchException) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}

