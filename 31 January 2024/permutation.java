import java.util.Scanner;
public class permutation{
    public static void main(String[] args) {
        String s,s1;
        System.out.println("Enter your sentences");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        s1=sc.nextLine();
        s=s.trim();
        int []arr=new int[126];
        for(int i=0;i<126;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)]+=1;
            arr[s1.charAt(i)]-=1;
        }
        boolean flag=true;
        for(int i=0;i<s.length();i++)
        {
            if(arr[s.charAt(i)]!=0)
            {
            flag=false;
            break;
        }
    }
       System.out.println(flag);
        sc.close();
    }
}