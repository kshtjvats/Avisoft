package MedicalManagement;
public class Prescription {
    private String nameOfMedicine,date,prescribedBy,symptoms;
    Prescription(String nameOfMedicine,String date,String prescribedBy,String symptoms)
    {
        this.nameOfMedicine=nameOfMedicine;
        this.date=date;
        this.prescribedBy=prescribedBy;
        this.symptoms=symptoms;
    }
    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    public String getDate() {
        return date;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void displayPrescription() {
        System.out.println("Prescription Details:");
        System.out.println("Medicine Name: " + getNameOfMedicine());
        System.out.println("Prescribed Date: " + getDate());
        System.out.println("Prescribed By: " + getPrescribedBy());
    }
}
