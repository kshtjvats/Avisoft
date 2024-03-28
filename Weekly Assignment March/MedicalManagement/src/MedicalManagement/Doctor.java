package MedicalManagement;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private int age;
    private String email;
    private String password;
    private String specialization;
    List<Patient>toSee=new ArrayList<Patient>();
    // Constructor
    public Doctor(String name, int age, String email, String password, String specialization) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.specialization = specialization;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    void addPatientToSee(Patient patient)
    {
        toSee.add(patient);
    }
    // Function to display details of the doctor
    public void showDoctorDetails() {
        System.out.println("Doctor Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Specialization: " + getSpecialization());
    }

    public static void main(String[] args) {
        // Example usage
        Doctor doctor = new Doctor("Dr. John Doe", 35, "johndoe@example.com", "password123", "Cardiology");
        doctor.showDoctorDetails();
    }
}
