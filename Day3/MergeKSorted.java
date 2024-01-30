//Question Number 8
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSorted {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        PriorityQueue pq=new PriorityQueue<>();
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
            pq.add(arr[i][j]);
            }
            len=len+l[i];
        }
        for(int i=0;i<len;i++)
        System.out.println(pq.poll());
    }
}
        
