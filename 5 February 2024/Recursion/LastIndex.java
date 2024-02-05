import java.util.Scanner;
public class LastIndex{
    static int index=-1;
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n;
       System.out.println("Enter length of array");
       n=sc.nextInt();
       int[] arr=new int[n];
       System.out.println("Enter elms of array");
       for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();
       System.out.println("Enter target elms");
       int x=sc.nextInt();
       int res=lastIndex(arr,x,0);
       if(res==-1)
       System.out.println("No match found");
       else
       System.out.println("Found at ="+res);
     }
    static int lastIndex(int []arr,int x,int st)
    {
       if(st>arr.length)
       return index;
       if(arr[st]==x)
       {
        index=st;
        return index;
       }
       else
       lastIndex(arr,x,st+1);
       return index;
    }
}