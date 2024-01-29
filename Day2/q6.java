import java.util.Scanner;
public class q6 {
    public static void main(String[] args) {
     int n,m;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of first array");
        n=sc.nextInt();
        int [] arr=new int[n];
        int p=0;
        int p1=0;
        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            p=p*10+arr[i];
        }
        System.out.println("Enter size of second array");
        m=sc.nextInt();
        int [] arr1=new int[m];
        System.out.println("Enter elements of array");
        for(int i=0;i<m;i++)
        {
            arr1[i]=sc.nextInt();
            p1=p1*10+arr1[i];
        }
        System.out.println((p+p1));
}
}
