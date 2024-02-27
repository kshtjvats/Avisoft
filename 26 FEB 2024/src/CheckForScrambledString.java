import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CheckForScrambledString {

    public static int isScramble(String A, String B) {
        // Check if strings are equal
        if (A.equals(B)) {
            return 1;
        }

        // Check if lengths are different
        if (A.length() != B.length()) {
            return 0;
        }

        int n = A.length();
        return memoization(A, B, new HashMap<>(), 0, 0, n);
    }

    private static int memoization(String A, String B, Map<String, Integer> memo, int i, int j, int len) {
        String key = i + "-" + j + "-" + len;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (A.substring(i, i + len).equals(B.substring(j, j + len))) {
            memo.put(key, 1);
            return 1;
        }

        for (int k = 1; k < len; k++) {
            if ((memoization(A, B, memo, i, j, k) == 1 && memoization(A, B, memo, i + k, j + k, len - k) == 1) ||
                (memoization(A, B, memo, i, j + len - k, k) == 1 && memoization(A, B, memo, i + k, j, len - k) == 1)) {
                memo.put(key, 1);
                return 1;
            }
        }

        memo.put(key, 0);
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string A:");
        String A = scanner.next();
        System.out.println("Enter string B:");
        String B = scanner.next();
        int result = isScramble(A, B);
        System.out.println("Output: " + result);
        scanner.close();
    }
}
