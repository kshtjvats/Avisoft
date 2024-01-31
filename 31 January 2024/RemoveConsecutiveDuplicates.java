import java.util.Scanner;
public class RemoveConsecutiveDuplicates{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
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
        sc.close();
    }
    }