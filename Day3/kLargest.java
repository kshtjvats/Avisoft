import java.util.PriorityQueue;
import java.util.Scanner;
public class kLargest {
    public static void main(String[] args) {
    PriorityQueue pq=new PriorityQueue<Integer>((a,b)->(b-a));
    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    n=sc.nextInt();
    int [] arr=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            pq.add(arr[i]);
        }
        System.out.println("Enter k");
        int k=sc.nextInt();
    for(int i=0;i<k;i++)
    {
        System.out.print(pq.poll()+",");
    }
}
}
