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
    /*int n1=0;int n2=0;
    for(int i=0;i<s1.length();i++)
    {
    n1=n1*10+(s1.charAt(i)-48);   
    }
    for(int i=0;i<s2.length();i++)
    {
    n2=n2*10+(s2.charAt(i)-48);   
    }*/
    for(int i=0;i<n;i++)
    {
    arr[i]=sc.next();
    int num=Integer.parseInt(arr[i],2);
    sum=sum+num;
    /*int n1=Integer.parseInt(s1,2);
    int n2=Integer.parseInt(s2,2);
    int sum=n1+n2;*/
    }
    System.out.println(Integer.toBinaryString(sum));
}
}