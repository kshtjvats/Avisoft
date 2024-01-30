import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < 2 * i; j++) {
                System.out.print(j);
            }
            for (int j = 2 * i - 2; j >= i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}