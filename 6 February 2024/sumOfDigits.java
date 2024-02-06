//QUESTION 6

import java.util.Scanner;
public class sumOfDigits {
static int sum=0;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n;
     System.out.println("Enter the number");
     n=sc.nextInt();
    System.out.println("The sum of digits is = "+sumd(n));
}
static int sumd(int n)
{
    if(n==0)
    return 0;
    else
    {
    sum=sum+n%10;
    sumd(n/10);
    }
    return sum;
}
}

