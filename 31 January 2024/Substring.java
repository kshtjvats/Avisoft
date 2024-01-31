import java.util.Scanner;
public class Substring{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        s=s.trim();
        int i=0;
        int j=s.length();
        System.out.println("Substring are");
        while(j!=i)
        {
        System.out.println(s.substring(i,j));
        if(j==i+1)
        {
            j=s.length();
            i++;
        }
        else
        j--;
        }
        sc.close();
    }
}