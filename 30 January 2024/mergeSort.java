import java.util.Scanner;

public class mergeSort {
    void sort(int arr[],int l,int r)
    {
        if(l<r)
        {
        int m=l+(r-l)/2;

        sort(arr,l,m);
        sort(arr,m+1,r);

        merge(arr,l,m,r);
        }
    }
    void merge(int arr[],int l,int m,int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    n=sc.nextInt();
    int [] arr=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++)
    {
         arr[i]=sc.nextInt();
    }
    mergeSort ob=new mergeSort();
    ob.sort(arr,0,n-1);
    for(int i=0;i<n;i++)
    System.out.print(arr[i]+",");
    }
    }
