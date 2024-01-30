import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateInArray {
  public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        /*Set<Integer> set=new HashSet<Integer>();                  Hash set approach
        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++)
        {
        arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
        if(!set.add(arr[i]))
        System.err.print("Repeating Characters are="+arr[i]+",");
        }  */

        /*Approach2  Declare a 100 size array named counter, initialize each index with 0 and while inserting elm in main 
        array use counter[arr[i]]+=1;*/
        System.out.println("Enter elements of array");
        int max=0;
        for(int i=0;i<n;i++)
        {
        arr[i]=sc.nextInt();
        if(arr[i]>max)
        max=arr[i];
        }
        int [] counter=new int[max+1];
        for(int i=0;i<max;i++)
        {
        counter[i]=0;
        }
        for(int i=0;i<n;i++)
        {
        counter[arr[i]]+=1;
        }
        System.out.print("Repeating Charcter is=");
        for(int i=0;i<n;i++)
        {
        if(counter[arr[i]]>1)
        {
        System.out.print(arr[i]+",");
        counter[arr[i]]=0;
        }
    }
}
}