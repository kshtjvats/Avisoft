//QUESTION 7

import java.util.Scanner;
public class Multiplication {
static int sum=0;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n,m;
     System.out.println("Enter the numbers to be multiplied");
     n=sc.nextInt();
     m=sc.nextInt();
    System.out.println("The product of digits is = "+pd(n,m));
}
static int pd(int n,int m)
{
    if(n==0)
    return 0;
    else
    {
    sum=sum+m;
    pd(--n,m);
    }
    return sum;
}
}
