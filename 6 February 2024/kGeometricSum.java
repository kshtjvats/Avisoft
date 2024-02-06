//QUESTION 1

import java.util.Scanner;
public class kGeometricSum{
static int c=1; //static counter variable to keep check of number of recursive calls
static double sum=1; //static global double variable to be used in recursive function to calculate sum
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     int k;
     System.out.println("Enter the value of k");
     k=sc.nextInt();
     System.out.println(gms(k));
}
static double gms(int k)
{
    if(c>k)   //base case , c will go upto k only
        return sum;
    
    sum=sum+(1/(Math.pow(2,c)));  //adding 1/2^c to calculate sum
    ++c;
    gms(k); //recursive call
    return sum;
}
}