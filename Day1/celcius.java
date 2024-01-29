import java.util.Scanner;
public class celcius {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int S,E,W;
    System.out.println("Enter Start");
    S=sc.nextInt();
    System.out.println("Enter End");
    E=sc.nextInt();
    System.out.println("Enter Step");
    W=sc.nextInt();
    System.out.println("Conversions from "+S+"F° to C° is:");
    for(int i=S;i<=E;i=i+W)
    {
        float c=((i-32)*5/9);
        System.out.println(i+"F° = "+c+"C°");
    }
    }
}
