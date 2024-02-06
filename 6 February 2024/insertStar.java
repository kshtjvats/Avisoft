//QUESTION 4

import java.util.Scanner;
public class insertStar {
static int i=0;
static String ans="";
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     String s;
     System.out.println("Enter the string");
     s=sc.next();
     System.out.println("The converted string is :"+convert(s,s.length()-1)+s.charAt(s.length()-1));
     
}

static String convert(String s,int l)
{
if(i==l)
return ans;
if(s.charAt(i)==s.charAt(i+1))
{
ans=ans+s.charAt(i)+'*';
++i;
convert(s,l);
}
else
{
ans=ans+s.charAt(i);
++i;
convert(s,l);
}
return ans;
}
}