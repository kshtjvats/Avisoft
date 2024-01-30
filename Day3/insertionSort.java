import java.util.Scanner;

public class insertionSort {
void ins(int arr[],int n)
{
for(int i=1;i<n;i++)
{
    int temp=arr[i];
    int j=i-1;
    for(;j>=0;j--)
    {
        if(arr[j]>temp)
        {
            arr[j+1]=arr[j];
        }
        else
        continue;
    }
    arr[j+1]=temp;
}
}
public static void main(String[] args) {           
int n;
insertionSort ob=new insertionSort();
Scanner sc=new Scanner(System.in);
System.out.println("Enter size of array");
n=sc.nextInt();
int [] arr=new int[n];
System.out.println("Enter elements of array");
for(int i=0;i<n;i++)
    {
     arr[i]=sc.nextInt();
    }
ob.ins(arr,n);
for(int i=0;i<n;i++)
System.out.print(arr[i]+",");
}
}

