import java.util.Scanner;

public class TotalScore{
 public static void main(String[] args) {
    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of your array");
    n=sc.nextInt();
    if(n==0)
    System.out.println(0);
    else
    {
    int score=0;
    int[] arr=new int[n];
    System.out.println("Enter your array elements");
    for(int i=0;i<n;i++)
    {
    arr[i]=sc.nextInt();
    if(arr[i]==5)
    score+=5;
    else if(arr[i]%2==0)
    score+=1;
    else if(arr[i]%2!=0)
    score+=3;
    }
    System.out.println(score);
}
}
}