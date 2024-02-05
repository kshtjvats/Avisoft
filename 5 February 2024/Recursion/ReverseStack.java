import java.util.Scanner;

public class ReverseStack{
    public static void main(String[] args) {
        int n;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter length of array");
       n=sc.nextInt();
       int[] arr=new int[n];
       System.out.println("Enter elms of array");
       for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();
       rev(arr,n,0);
       System.out.println("Reversed Stack is");
       for(int i=0;i<n;i++)
       System.out.print(arr[i]+",");
     }
    static void rev(int[] arr,int l,int s)
    {
        if(l>s)
        {
        int t=arr[l-1];
        arr[l-1]=arr[s];
        arr[s]=t;
        rev(arr,l-1,s+1);
        }
}
}