import java.util.ArrayList;
import java.util.Scanner;
public class SumOfZeros{
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
        zero.add(j);
        }
       }
    }
    int sum=0;
    for(int i=0;i<zero.size();i=i+2)
    {
        if(zero.get(i)>0)
        sum+=arr[zero.get(i)-1][zero.get(i+1)];
        if(zero.get(i)<n-1)
        sum+=arr[zero.get(i)+1][zero.get(i+1)];
        if(zero.get(i+1)<m-1)
        sum+=arr[zero.get(i)][zero.get(i+1)+1];
        if(zero.get(i+1)>0)
        sum+=arr[zero.get(i)][zero.get(i+1)-1];

    }
    System.out.println("Sum ="+sum);
}
}