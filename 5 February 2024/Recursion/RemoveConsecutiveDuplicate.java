import java.util.Scanner;
public class RemoveConsecutiveDuplicate{
    static String ans="";
    public static void main(String[] args) {
       String s;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter your String");
       s=sc.next();
       s=s.trim();
       s=s+' ';
       System.out.println("Altered string is ="+rmvc(s,s.length(),0));
     }
    static String rmvc(String s,int l,int st)
    {
       if(st>(l-2))
       return ans;
       if(s.charAt(st)==s.charAt(st+1))
       return rmvc(s,l,st+1);
       else
       {
        ans=ans+s.charAt(st);
        rmvc(s,l,st+1);
       }
       return ans;
    }
}