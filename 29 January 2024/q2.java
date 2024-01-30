import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class q2{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        //Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
           // hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        //int c=0;
        /*for(int i=0;i<n;i++)
        {
          if(hm.get(arr[i])>0)
          {
            arr[c]=arr[i];
            hm.put(arr[i],0);
            c=c+1;
          }
          else
          continue;
        }
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
            arr[i+1]=0;
            c=i+1;
            }
        }
        for(int i=c;i<n;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+",");
        }*/
        //2 pointer 
        int i=1;
        int j=1;
        int c=1; //counter
        while(i<n)
        {
        if(arr[i]==arr[i-1])
        i++;
        else if(arr[i]!=arr[i-1])
        {
            c++;
            arr[j]=arr[i];
            i=i+1;
            j=j+1;
        }
        }
        System.out.println("Size of array="+c);
        for(int x=0;x<c;x++)
        System.err.print(arr[x]+",");
    }
}