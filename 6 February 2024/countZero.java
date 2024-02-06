//QUESTION 8

import java.util.Scanner;
public class countZero{
static int ans=0;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n;
     System.out.println("Enter the number");
     n=sc.nextInt();
     System.out.println("The number of zeroes present are = "+count(n));
}
static int count(int n)
{
    if(n==0)
    return 1;
    else
    {
    if(n%10==0)
    ++ans;
    count(n/10);
    }
    return ans;
}
}