import java.util.Scanner;
import java.io.*;
public class BinaryAddition{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter number of strings");
    int n=sc.nextInt();
    System.out.println("Enter the strings");
    String []arr=new String[n];
    int sum=0;
    for(int i=0;i<n;i++)
    {
    arr[i]=sc.next();
    int num=Integer.parseInt(arr[i],2); //converting binary string to integer example 10 will get converted to 2
    sum=sum+num;
    }
    System.out.println(Integer.toBinaryString(sum)); //printing corresponding binary string
    }
}