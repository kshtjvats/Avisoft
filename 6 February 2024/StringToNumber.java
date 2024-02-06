//QUESTION 3

import java.util.Scanner;
public class StringToNumber {
static int i=0;
static long num=0; //static global variable to be used as head pointer
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     String s;
     System.out.println("Enter the string");
     s=sc.next();
     for(int i=0;i<s.length();i++)
     {
        if(s.charAt(i)>48)
        {
        s=s.substring(i,s.length());
        break;
        }
    }
     System.out.println("The converted string to number is :"+convert(s,s.length()-1));
     
}

static long convert(String s,int l)
{
if(i>l)
return num;
num=num*10+(s.charAt(i)-48);
++i;
convert(s,l);
return num;
}
}
