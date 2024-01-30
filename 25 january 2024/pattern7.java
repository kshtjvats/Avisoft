import java.util.Scanner;

public class pattern7 {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=n;i>=1;i--)
        {
            for(int z=1;z<i;z++)
            System.out.print(" ");
            for(int j=1;j<=n-i+1;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
