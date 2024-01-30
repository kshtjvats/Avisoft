import java.util.Scanner;
public class count {
    public static void main(String[] args) {
        int c=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        if(n<0)
        n=-n;
        while(n!=0)
        {
        n=n/10;
        c=c+1;
        }
        System.err.println(c);
    }
}