import java.util.Scanner;
public class Query{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n,q;
    System.out.println("Enter size of array");
    n=sc.nextInt();
    int sum=0;double p=1;
    int[] arr=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt(); 
    }
    System.out.println("Enter q");
    q=sc.nextInt();
    switch (q) {
        case 1:
            for(int i=0;i<n;i++)
            sum=sum+arr[i];
            System.out.println("Sum is="+sum);
            break;
        case 2:
            for(int i=0;i<n;i++)
            p=p*arr[i];
            System.out.println("Product is="+p);
            break;
    
        default:
            break;
    }
}
}