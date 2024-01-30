import java.util.Scanner;
public class SumOfInfiniteArray {    //Question 5
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        int []sum=new int[n+1];
        sum[0]=0;
        int k=1;
        int s=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum[k]=s+arr[i];
            s=s+arr[i];
            k++;
        }
        int q;
        System.out.println("Enter the number of queries");
        q=sc.nextInt();
        int []qr=new int[q];
        int max=0;
        System.out.println("Enter query ranges");
        for(int i=0;i<q;i++)
        {
            qr[i]=sc.nextInt();
        }
        int ans=0;
        for(int i=0;i<q;i++)
        {
            if(i%2==0)
            {
           ans+=(qr[i+1])/n*sum[n]+sum[qr[i+1]%n]-sum[qr[i]-1];
           System.out.println("Sum of elements "+qr[i]+" to "+qr[i+1]+" is="+ans);
           ans=0;
        }
    }

    }
}