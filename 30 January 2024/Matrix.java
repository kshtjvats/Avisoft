import java.util.PriorityQueue;
import java.util.Scanner;

public class Matrix {
     public static void main(String[] args) {
        int n;
        int sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of arrays");
        int a=sc.nextInt();
        int []l=new int[a];
        for(int i=0;i<a;i++)
        {
        System.out.println("Enter size of array "+(i+1));
        l[i]=sc.nextInt();
        }
        int len=0;
        int [][]arr=new int[a][];
        for(int i=0;i<a;i++)
        {
            arr[i]=new int[l[i]];
            for(int j=0;j<l[i];j++)
            {
            System.out.println("Enter elements"+(j+1)+" of array "+(i+1));
            arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<l[i];j++)
            {
                if(i==j)
                {
                sum=sum+arr[i][j];
                arr[i][j]=0;
                }
            }
        }
        for(int i=0;i<a;i=i+a-1)
        {
            for(int j=0;j<l[i];j++)
            {
                sum=sum+arr[i][j];
                arr[i][j]=0;
            }
        }
        for(int i=0;i<a;i=i+a-1)
        {
            for(int j=0;j<l[i];j++)
            {
                sum=sum+arr[j][i];
                arr[j][i]=0;
            }
        }
        for(int i=0;i<a;i=i+a-1)
        {
                sum=sum+arr[i][l[i]-i-1];
                arr[i][l[i]-i-1]=0;
        }

        System.out.println(sum);
    }
}
