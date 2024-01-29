import java.util.Scanner;

public class ReverseAfterM{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter position m");
        int m=sc.nextInt();
        m=m-1;
        int e=n-1;
        int c=0;
        while(m<e);
        {
        c=arr[m];
        arr[m]=arr[e];
        arr[e]=c;
        e=e-1;
        m=m+1;
        }
        System.err.println("Reversed array after m is ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+",");
        }
    }
}