//QUESTION 9

import java.util.Scanner;
public class LongestIncreasing{ 
    static int i=0;
    static String ans="";
public static void main(String[] args) 
{
     Scanner sc=new Scanner(System.in);  //scanner object
     System.out.println("Enter size of array");
     int n=sc.nextInt();
     int []arr=new int[n];
     System.out.println("Enter array elements");
     for(int i=0;i<n;i++)
     arr[i]=sc.nextInt();
     System.out.println("Length of longest increasing sequence is="+func(arr,0,-1));
}
static int func(int[]arr,int i,int prev)
{
    if(i==arr.length)
    return 0;
    int take=0;
    int not_take=0;
    if(prev==-1||arr[i]>arr[prev])
    take=1+func(arr,i+1,i);
    else
    not_take=0+func(arr,i+1,i);
    return Math.max(take,not_take);
}
}