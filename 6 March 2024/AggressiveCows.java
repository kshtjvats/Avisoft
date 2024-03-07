import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AggressiveCows {
    // Function to check if it's possible to place 'k' cows with a minimum distance 'mid' between them
    static boolean isPossible(List<Integer> stalls, int k, int mid, int n) {
        int cowCount = 1;
        int lastPos = stalls.get(0);
        
        // Iterate through the stalls
        for (int stallIndex = 0; stallIndex < n; stallIndex++) {
            if (stalls.get(stallIndex) - lastPos >= mid) {
                cowCount++;
                // If 'k' cows are placed, return true
                if (cowCount == k) {
                    return true;
                }
                lastPos = stalls.get(stallIndex);
            }
        }
        // If not possible to place 'k' cows, return false
        return false;
    }

    // Function to find the minimum distance such that 'k' cows can be placed with that minimum distance between them
    static int aggressiveCows(List<Integer> stalls, int k) {
        stalls.sort(null); // Sort the stalls array
        int start = 0;
        int n = stalls.size();
        int end = stalls.get(n - 1);
        int ans = -1;
        int mid = start + (end - start) / 2;

        // Perform binary search to find the minimum distance
        while (start <= end) {
            if (isPossible(stalls, k, mid, n)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of stalls
        System.out.println("Enter the number of stalls:");
        int numOfStalls = scanner.nextInt();
        Integer[] stallsArray = new Integer[numOfStalls];
        System.out.println("Enter the positions of stalls:");
        for (int stallIndex = 0; stallIndex < numOfStalls; stallIndex++) {
            stallsArray[stallIndex] = scanner.nextInt();
        }
        List<Integer> stalls = Arrays.asList(stallsArray);

        // Input value of k
        System.out.println("Enter the number of cows:");
        int numOfCows = scanner.nextInt();

        // Find and print the minimum distance
        int result = aggressiveCows(stalls, numOfCows);
        System.out.println("Minimum distance for aggressive cows: " + result);

        scanner.close();
    }
}
