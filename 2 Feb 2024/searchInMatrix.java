import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class searchInMatrix{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter number of arrays");
    int n=sc.nextInt();
    System.out.println("Enter length of arrays");
    int m=sc.nextInt();
    System.out.println("Enter target");
    int t=sc.nextInt();
    int [][]arr=new int[n][m];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
        System.out.println("Enter elements"+(j+1)+" of array "+(i+1));
        arr[i][j]=sc.nextInt(); 
        }
    }
    boolean flag=false;
    int k=m-1;
    int i=0;
    while(i<n-1 && k>0)
    {
        if(arr[i][k]<t)
        i++;
        else if(arr[i][k]>t)
        k--;
        else if(arr[i][k]==t)
        {
        flag=true;
        break;
        }
    }
        System.out.println(flag);
    }


}
