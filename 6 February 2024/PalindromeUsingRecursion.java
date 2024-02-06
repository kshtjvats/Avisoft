//QUESTION 2

import java.util.Scanner;
public class PalindromeUsingRecursion{
static int i=0; //static global variable to be used as head pointer
static boolean flag=true;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     String s;
     System.out.println("Enter the string");
     s=sc.next();
     s=s.toLowerCase();  //converting to lower case as 'R'!='r' in case of "Racecar"
     if(isPalindrome(s,s.length()-1)==true) //printing according to result
     System.out.println("It is a palindrome String");
     else
     System.out.println("Not a palindrome String");
     sc.close();
}
static boolean isPalindrome(String s,int l)
{
if(i==l) // Base Case 
//i pointer moves forward , l keeps on decreasing to check i'th and last string character 
    return flag;
if(s.charAt(i)==s.charAt(l))
{
    ++i;  
    isPalindrome(s,--l);  //if the i'th and l'th char match we keep moving
}
else
{
    flag=false;  //serves as terminating condition
    return flag;
}
return flag;
}
}