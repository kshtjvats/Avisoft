import java.util.Scanner;
public class q4{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        int p=1;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            p=p*arr[i];
        }
        System.out.print("(");
        for(int i=0;i<n;i++)
        {
        System.out.print(p/arr[i]+",");
        }
        System.out.print(")");
        }
    }
