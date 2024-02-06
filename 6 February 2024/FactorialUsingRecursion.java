import java.util.Scanner;
public class FactorialUsingRecursion{
static int f=1; //static global integer variable to be used in recursive function
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n;
     System.out.println("Enter the number to find its factorial");
     n=sc.nextInt();
     System.out.println("The factorial of "+n+" is = "+fact(n));
}
static int fact(int n)
{
    if(n==0)  //Base case
        return 1;
    return n*fact(n-1);
}
}