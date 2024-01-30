import java.util.Scanner;
public class SearchInsertPos {    //Question 13
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        int target;
        System.out.println("Enter target elm");
        target=sc.nextInt();
        System.out.println("Enter elements of array");
        int c=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]<target)
            c++;
        }
            System.out.println("The Position of "+target+" is = "+c);
        }
        }