import java.util.Scanner;
public class RemoveConsecutiveDuplicates{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the string");
    String s=sc.next();
    s=s.trim();
    for(int i=0;i<s.length()-1;i++)
    {
        if(s.charAt(i)==s.charAt(i+1))
        {
            s=s.substring(i+1,s.length());
            i--;
        }
    }
    System.out.println(s);
}
}