import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            StringBuilder result = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                result.append(j);
                if (j < i) {
                    result.append("+");
                }
            }
            result.append("=").append(sum);
            System.out.println(result);
        }
    }
}