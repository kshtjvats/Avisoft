import java.util.Scanner;
public class RemoveX{
    static String ans="";
    public static void main(String[] args) {
       String s;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter your String");
       s=sc.next();
       s=s.trim();
       System.out.println("Altered string is ="+rmv(s,s.length()));
     }
    static String rmv(String s,int l)
    {
       if(l<=0)
       return ans;
       if(s.charAt(l-1)=='x')
       return rmv(s,l-1);
       else
       {
        ans=s.charAt(l-1)+ans;
        rmv(s,l-1);
       }
       return ans;
    }
}