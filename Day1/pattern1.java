import java.util.Scanner;
public class pattern1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=64+i;j<=64+2*i-1;j++)
            {
                System.out.print((char)j);
            }
            System.out.println();
        }
    }
}