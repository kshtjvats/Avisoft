import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array in sorted order");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int s;
        System.out.println("Enter desired sum");
        s=sc.nextInt();
        int k,j;
        int sum=0;
        for(int i=0;i<n-2;i++)
        {
            
            if(i>0&&arr[i]==arr[i-1]) continue;
            j=i+1;
            k=n-1;
            
            while(k>j)
            {
            sum=arr[i]+arr[j]+arr[k];
            if(sum>s)
            --k;
            else if(sum<s)
            ++j;
            else if(sum==s)
            {
                System.out.print("("+arr[i]+","+arr[j]+","+arr[k]+"),");
                k--;
                j++;
                while(k>j&&arr[j]==arr[j-1]) ++j;
                while(k>j&&arr[k]==arr[k+1]) --k;
            }
        }
    }
}
}
