import java.util.Scanner;
public class HighestOccurence{
    public static void main(String[] args) {
        String s;
        System.out.println("Enter your sentence");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        s=s.trim();
        int []arr=new int[126];
        for(int i=0;i<126;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)]+=1;
        }
        int max=0;
        int maxv=0;
        for(int i=0;i<s.length();i++)
        {
            if(arr[s.charAt(i)]>max)
            {
            max=arr[s.charAt(i)];
            maxv=s.charAt(i);
            }
        }
        System.out.println((char)maxv);
        sc.close();
    }
}