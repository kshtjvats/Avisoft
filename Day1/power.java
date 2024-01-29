import java.util.Scanner;

public class power {
    public static void main(String[] args) {
    int n,x;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the power");
    n=sc.nextInt();
    System.out.println("Enter the number");
    x=sc.nextInt();
    if(n==0||n<0)
    System.out.println("1");
    else
    {
    int ans=x;
    for(int i=1;i<n;i++)
    ans=ans*x;
    System.out.println(x+"^"+n+"="+ans);
    }
}
}
