import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class SortMatrix{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    PriorityQueue<Integer> pq=new PriorityQueue<>();
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
        }
    }
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(pq.size()<n)
            pq.add(arr[j][i]);
            else if(pq.size()==n)
            {
                System.out.print(pq.poll()+",");
                pq.add(arr[j][i]);
            }
        }
    }
        while(pq.size()!=0)
        System.out.print(pq.poll()+",");
    }


}
