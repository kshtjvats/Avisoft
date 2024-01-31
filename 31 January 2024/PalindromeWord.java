import java.util.Scanner;
public class PalindromeWord{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        s=s.trim();
        int i=0;
        int j=s.length()-1;
        boolean flag=true;
        s=s.toLowerCase();
        while(i<=j)
        {
        if(s.charAt(i)==s.charAt(j))
        {
            j--;
            i++;
        }
        else
        {
        flag=false;
        break;
        }
        }
        System.out.println(flag);
        sc.close();
    }
}