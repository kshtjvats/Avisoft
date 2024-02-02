import java.util.ArrayList;
import java.util.Scanner;
public class ZeroinRow{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> zero=new ArrayList<Integer>();
    System.out.println("Enter number of arrays");
    int n=sc.nextInt();
    System.out.println("Enter length of arrays");
    int m=sc.nextInt();
    int [][]arr=new int[n][m];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
        System.out.println("Enter elements"+(j+1)+" of array "+(i+1));
        arr[i][j]=sc.nextInt();
        if(arr[i][j]==0)
        {
        zero.add(i);
        zero.add(i+1);
        }
    }
    }
    System.out.println("Matrix before alteration is -:");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
        System.out.print(arr[i][j]);
        }
        System.out.println();
    }
    
    for(int i=0;i<zero.size();i=i+2)
    {
        for(int j=0;j<m;j++)
        arr[zero.get(i)][j]=0;
        for(int j=0;j<n;j++)
        arr[j][zero.get(i+1)]=0;
    }
    System.out.println("Matrix after alteration is -:");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
        System.out.print(arr[i][j]);
        }
        System.out.println();
    }
}
}