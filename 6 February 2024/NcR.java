//QUESTION 10

import java.util.Scanner;
public class NcR {
static double sum=1;
static int i=0,f=1;
static int re=0;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n;
     System.out.println("Enter the numbers as N & R");
     n=sc.nextInt();
     int r=sc.nextInt();
     System.out.println((int)ncr(n,r)/(fact(n-r)*fact(r)));
     
}
static double ncr(int n,int r)
{
    if(n-i==0)
    return sum;
    else
    {
    sum=sum*(n-i);
    ++i;
    ncr(n,r);
    return sum;
    }
}
static int fact(int n)
{
    if(n==0)  //Base case
        return 1;
    return n*fact(n-1);
}
}