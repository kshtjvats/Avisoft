import java.util.Scanner;

public class ProductOfStrings{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in) ;
    System.out.println("Enter your strings");
    String s=sc.nextLine();
    String s1=sc.nextLine();
    int a=0;
    int b=0;
    for(int i=0;i<s.length();i++)
    a=a*10+(s.charAt(i)-48);
    for(int i=0;i<s1.length();i++)
    b=b*10+(s1.charAt(i)-48);
    System.out.println((long)a*b);
    }
}
