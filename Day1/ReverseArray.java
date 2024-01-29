import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] num=new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            num[i]=sc.nextInt();
        }
        int a=0,b=n-1,c=0; //c being temporary variable
        while(b>=a)
        {
            c=num[a];
            num[a]=num[b]; //swapping
            num[b]=c;
            a=a+1;
            b=b-1;
        }
        System.out.println("Reversed array is ");
        for(int i=0;i<n;i++)
        System.err.print(num[i]+",");
    }
}
