import java.util.Scanner;

public class starPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            if (i <= (N + 1) / 2) {
                for (int j = 0; j < N / 2 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < i - N / 2 - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * (N - i) + 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}