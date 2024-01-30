import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();
        int p=N;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(j!=p)
                System.out.print(j);
                else
                System.out.print("*");
            }
            p--;
            System.out.println();
        }
    }
}