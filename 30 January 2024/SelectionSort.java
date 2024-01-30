//Question number 10
import java.util.Scanner;
public class SelectionSort {
    void Ss(int arr[],int n)               //selection sort function
        {
        int c=0;int j=0;int ind=0;
        for(int i=0;i<n-1;i++)
        {
          int min=arr[i];
          for(j=i+1;j<n;j++)
          {
            if(arr[j]<min)
            {
                min=arr[j];
                ind=j;
            }
          }
          if(min!=arr[i])
          {
            c=arr[i];
            arr[i]=min;
            arr[ind]=c; 
          }
        }
    }   
public static void main(String[] args) {           
int n;
SelectionSort ob=new SelectionSort();
Scanner sc=new Scanner(System.in);
System.out.println("Enter size of array");
n=sc.nextInt();
int [] arr=new int[n];
System.out.println("Enter elements of array");
for(int i=0;i<n;i++)
    {
     arr[i]=sc.nextInt();
    }
ob.Ss(arr,n);
for(int i=0;i<n;i++)
System.out.print(arr[i]+",");
}
}