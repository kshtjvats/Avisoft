import java.util.Scanner;
public class pattern5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=0;
        for(int i=n;i>=1;i--)
        {
            for(int j=64+n-x;j<=64+n;j++)
            {
                System.out.print((char)j);
            }
            x++;
            System.out.println();
        }
    }
}