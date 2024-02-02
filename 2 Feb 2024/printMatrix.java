import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class printMatrix{
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
        System.out.print(arr[j][Math.abs(j+i)]+" ");
        }
        m--;
        System.out.println();
}}}