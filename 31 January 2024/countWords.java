import java.util.Scanner;
public class countWords{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        s.trim();
        s=s+" ";
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            c++;
        }
        System.out.println(c);
        sc.close();
    }
}