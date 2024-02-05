import java.util.Scanner;

public class countSum{
    public static void main(String[] args) {
       int n;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter length of array");
       n=sc.nextInt();
       int[] arr=new int[n];
       System.out.println("Enter elms of array");
       for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();
       System.out.print("Sum of array is ="+cnt(arr,arr.length-1));
     }
    static int cnt(int[] arr,int l)
    {
        if (l<0)
        return 0;

        return (arr[l]+cnt(arr,l-1));
}
}