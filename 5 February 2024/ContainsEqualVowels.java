import java.util.Scanner;

public class ContainsEqualVowels{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the string");
    String s=sc.next();
    s=s.trim();
    s=s.toUpperCase();
    String s1=s.substring(0,(s.length()/2)-1);
    String s2=s.substring(s.length()/2,s.length());
    int c=0;
    for(int i=0;i<s1.length();i++)
    {
        if(s1.charAt(i)=='A'||s1.charAt(i)=='E'||s1.charAt(i)=='I'||s1.charAt(i)=='O'||s1.charAt(i)=='U')
        c++;
        if(s2.charAt(i)=='A'||s2.charAt(i)=='E'||s2.charAt(i)=='I'||s2.charAt(i)=='O'||s2.charAt(i)=='U')
        c--;
    }
    if(c==0)
    System.out.println(true);
    else
    System.out.println(false);
}
}