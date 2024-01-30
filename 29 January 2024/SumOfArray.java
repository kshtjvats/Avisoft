import java.util.Scanner;
public class SumOfArray{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        int sum=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        System.out.println("The sum of array is="+sum);
    }
}