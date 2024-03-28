package MedicalManagement;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name,email,password,contactNumber;
    String symptoms="";
    private int age;
    List<LabRecords>labRecords=new ArrayList<LabRecords>();
    List<String>medicalHistory=new ArrayList<String>();
    List<Prescription>prescriptionList=new ArrayList<Prescription>();
    List<Doctor>visitDoctor=new ArrayList<Doctor>();
    List<Prescription>pastPrescriptions=new ArrayList<Prescription>();
    //constructor of class Patient
    Patient(String name,String email,String password,String contactNumber,int age)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.contactNumber=contactNumber;
        this.age=age;
    }
    //Setters for this class
    void setName(String name)
    {
    this.name=name;
    }
    void setAge(int age)
    {
        this.age=age;
    }
    void setEmail(String email)
    {
    this.email=email;
    }
    void setPassword(String password)
    {
        this.password=password;
    }
    void setContactNumber(String contactNumber)
    {
        this.contactNumber=contactNumber;
    }
    void listSymptoms(String symptoms)
    {
    this.symptoms=symptoms;
    }
    //getters for this class
    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    String getEmail()
    {
        return email;
    }
    String getPassword()
    {
        return password;
    }
    String getContact()
    {
        return contactNumber;
    }
    String getSymptoms()
    {
        return symptoms;
    }
    //function to add a lab test to records
    void addLabRecord(LabRecords record)
    {
        labRecords.add(record);
    }
    //function to add a medical history to records
    void addMedicalHistory(String history)
    {
        medicalHistory.add(history);
    }
    //function to add a prescription to patient's records
    void addPrescription(Prescription prescription)
    {
        prescriptionList.add(prescription);
    }
    
        // fields and methods omitted for brevity...
    
        // Method to display patient details
        void showPatientDetails() {
            System.out.println("Patient Details:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
            System.out.println("Contact Number: " + contactNumber);
    
            // Display lab records
            System.out.println("Lab Records:");
            for (LabRecords record : labRecords) {
                System.out.println("Test Category: " + record.getTestingCategory());
                System.out.println("Prescribed By: " + record.getPrescribedBy());
                System.out.println("Report: " + record.getReport());
            }
            System.out.println("Symptoms :"+getSymptoms());
            // Display medical history
            System.out.println("Medical History:");
            for (String history : medicalHistory) {
                System.out.println(history);
            }
    
            // Display prescriptions
            System.out.println("Prescriptions:");
            for (Prescription prescription : prescriptionList) {
                System.out.println("Medicine: " + prescription.getNameOfMedicine());
                System.out.println("Date: " + prescription.getDate());
                System.out.println("Prescribed By: " + prescription.getPrescribedBy());
            }
        }
    }
    

