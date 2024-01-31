import java.util.Scanner;
public class CompressString{
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
        for(int i=0;i<s.length();i++)
        {
            if(arr[s.charAt(i)]>0)
            {
            System.out.print((char)s.charAt(i));
            System.out.print(arr[s.charAt(i)]);
            arr[s.charAt(i)]=0;
            }
        }
        sc.close();
    }
}