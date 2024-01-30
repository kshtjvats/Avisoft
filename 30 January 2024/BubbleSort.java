import java.util.Scanner;

public class BubbleSort {
void bb(int arr[],int n)
{
    int k=0;
    for(int i=0;i<n;i++)
    {
        int j=0;
        int temp=0;
        while(j<n-i-1)
        {
        if(arr[j+1]<arr[j])
        {
            temp=arr[j+1];
            arr[j+1]=arr[j];
            arr[j]=temp;
        }
        j++;
        }
    }
    k++;
}
public static void main(String[] args) {           
int n;
BubbleSort ob=new BubbleSort();
Scanner sc=new Scanner(System.in);
System.out.println("Enter size of array");
n=sc.nextInt();
int [] arr=new int[n];
System.out.println("Enter elements of array");
for(int i=0;i<n;i++)
    {
     arr[i]=sc.nextInt();
    }
ob.bb(arr,n);
for(int i=0;i<n;i++)
System.out.print(arr[i]+",");
}
}
