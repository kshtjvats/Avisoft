package TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Portal {
static Scanner scanner=new Scanner(System.in);
public static void main(String[] args) {
    List<Student>listOfStudents=new ArrayList<Student>();
    int choiceForSwitch=0;
    while(choiceForSwitch!=3)
    {
        System.out.println("Enter a choice\n1 : Admin Login\n2 : Student Login\n3 : Quit");
        choiceForSwitch=scanner.nextInt();
        switch (choiceForSwitch) {
            case 1:
                
            break;
            case 2:
                
            break;
            case 3:
                
            break;
            default:
                break;
        }
    }
}
}
