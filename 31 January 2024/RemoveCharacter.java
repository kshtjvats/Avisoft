import java.util.Scanner;
public class RemoveCharacter{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        System.out.println("Enter your character to be removed");
        String a=sc.nextLine();
        s=s.trim();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==a.charAt(0))
            {
                if(i==0)
                {
                s=s.substring(i+1,s.length());
                }
                else
                {
                s=s.substring(0,i)+s.substring(i+1,s.length());
                }
             i--;
    }
}
        System.out.println(s);
        sc.close();
    }
    }
