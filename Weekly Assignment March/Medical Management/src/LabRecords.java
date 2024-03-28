package MedicalManagement;
public class LabRecords {
    private String prescribedBy,testingCategory,report;
    LabRecords(String prescribedBy,String testingCategory,String report)
    {
        this.prescribedBy=prescribedBy;
        this.testingCategory=testingCategory;
        this.report=report;
    }
    String getPrescribedBy()
    {
        return prescribedBy;
    }
    String getTestingCategory()
    {
        return testingCategory;
    }
    String getReport()
    {
        return report;
    }
    void showLabRecord()
    {
        System.out.println("Lab Test category : "+getTestingCategory());
        System.out.println("Lab Test Prescribed By : "+getPrescribedBy());
        System.out.println("Test results : "+getReport());
    }
}
