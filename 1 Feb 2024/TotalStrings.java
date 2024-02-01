import java.util.Scanner;
public class TotalStrings{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in) ;
    System.out.println("Enter your number");
    int n=sc.nextInt();
    int sum;
    sum=1; //all a
    sum=sum+2*n; //1b or 1c rest all a
    sum=sum+n*(n-1); //1 b &1c
    sum=sum+(n*(n-1)*(n-2))/2; //1b &2c
    sum=sum+(n*(n-1))/2; //a &2c
    System.out.println(sum);
}
}
