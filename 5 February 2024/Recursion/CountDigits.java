import java.util.Scanner;
public class CountDigits{
    public static void main(String[] args) {
       int n;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter your number");
       n=sc.nextInt();
      System.out.println(count(n));
     }
    static int count(int n)
    {
        if(n==0)
        return 0;
        else
        return 1+count(n/10);
}
}