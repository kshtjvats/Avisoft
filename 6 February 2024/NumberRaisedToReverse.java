//QUESTION 13
import java.util.Scanner;
public class NumberRaisedToReverse {
static double sum=1;
static double d=1e9+7;
static int re=0;
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int n;
     System.out.println("Enter the number");
     n=sc.nextInt();
     int r=rev(n);
     System.out.println((int)pw(n,r));
}
static double pw(int n,int r)
{
    if(r==0)
    return sum;
    sum=(sum*n)%d;
    pw(n,--r);
    return sum;
}
static int rev(int n)
{
    if(n==0)
    return re;
    re=re*10+(n%10);
    rev(n/10);
    return re;
}
}