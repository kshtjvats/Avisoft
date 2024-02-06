
//Question 12

import java.util.Scanner;
public class RecursiveRemove{ 
    static int i=0;
    static String ans="";
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     String s;
     System.out.println("Enter the string");
     s=sc.next();
     System.out.println(func(s));
}
static String func(String s)
{
    
    if(i==s.length()-1)
    {
    ans=ans+s.charAt(i);
    return ans;
    }
    if(s.charAt(i)==s.charAt(i+1))
    {
    ans=ans+s.substring(i+2,s.length());
    i=0;
    String temp=ans;
    ans="";
    func(temp);
    }
    else
    {
    ans=ans+s.charAt(i);
    ++i;
    func(s);
    }
    return ans;

}
}