import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class AppearsOnce {
  public static void main(String[] args) {
    Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
    Scanner sc=new Scanner(System.in);
    int n;
    System.out.println("Enter size of array");
    n=sc.nextInt();
    int[] arr=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
        hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
    }
    System.out.println("Element that appear only once are:");
    for(int i=0;i<n;i++)
    {
        if(hm.get(arr[i])<2)
        System.out.print(arr[i]+",");
    }
  }  
}
