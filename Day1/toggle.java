import java.util.Scanner;
public class toggle {
    public static void main(String[] args) {
    String s,sn="";
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a string to toggle");
    s=sc.nextLine();
    int n=s.length();
    for(int i=0;i<n;i++)
    {
        if((s.charAt(i))>90 && (s.charAt(i))<=122) //checking for lowercase 
            sn=sn+(char)(s.charAt(i)-32);
        else if(s.charAt(i)>=65 && s.charAt(i)<=90) //checking for uppercase
            sn=sn+(char)(s.charAt(i)+32);
        else
            sn=sn+(s.charAt(i)); //checking for non alphabets
    }
    System.out.print("Toggled String is = ");
    System.out.println(sn);
    }
}
