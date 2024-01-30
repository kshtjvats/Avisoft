import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutive {
    public static void main(String[] args) {
        HashSet<Integer>h=new HashSet<>();
        int n;
        int l,ce=0;
        int cl=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
         {
            arr[i]=sc.nextInt();
            h.add(arr[i]);
         }
        l=0;
        for(int i=0;i<n;i++)
        {
            if(h.contains(arr[i]-1)==false)
            {
                cl=1;
                ce=arr[i];
                while(h.contains(ce+1))
                {
                    cl++;
                    ce++;
                }
                l=Math.max(l,cl);
            }
        }
        System.out.println("Length of longest sequence is="+l);
}
}
