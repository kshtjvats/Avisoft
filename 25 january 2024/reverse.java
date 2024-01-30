import java.util.Scanner;
import java.util.Vector;
public class reverse {
   public static void main(String[] args) {
    Vector<Integer>arr=new Vector<Integer>(1,1);
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter a number");
   int n=sc.nextInt();
   int in=0;
   int i=0;
   boolean flag=false;
   while(n!=0)
   {
      if(n%10!=0&& flag==false)
    {
    flag=true;
    i=in;
    }
    arr.add(n%10);
    in++;
    
    n=n/10;
   /*while(n!=0)
   {
    ne=ne*10+(n%10);
    n=n/10;
   }
   System.out.print(ne);
   } */
}
   for(int j=i;j<arr.size();j++)
   System.out.print(arr.get(j));
}
}