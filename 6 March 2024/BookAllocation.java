import java.util.List;
import java.util.Scanner;

public class BookAllocation {
    // Function to check if it's possible to allocate books with given constraints
    static boolean isPossible(List<Integer> arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int bookIndex = 0; bookIndex < n; bookIndex++) {
            if (pageSum + arr.get(bookIndex) <= mid) {
                pageSum += arr.get(bookIndex);
            } else {
                studentCount++;
                if (studentCount > m || arr.get(bookIndex) > mid) {
                    return false;
                }
                pageSum = arr.get(bookIndex);
            }
            if (studentCount > m) {
                return false;
            }
        }
        return true;
    }

    // Function to allocate books
    static int allocateBooks(List<Integer> arr, int n, int m) {
        int start = 0;
        int sum = 0;
        
        // Calculate the sum of all pages
        for (int bookIndex = 0; bookIndex < n; bookIndex++) {
            sum += arr.get(bookIndex);
        }
        
        int end = sum;
        int ans = -1;
        int midpoint = start + (end - start) / 2;

        // Perform binary search to find the minimum number of pages
        while (start <= end) {
            if (isPossible(arr, n, m, midpoint)) {
                ans = midpoint;
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }
            midpoint = start + (end - start) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of books
        System.out.println("Enter the number of books:");
        int numOfBooks = scanner.nextInt();
        Integer[] pagesArray = new Integer[numOfBooks];
        
        // Input the number of students
        System.out.println("Enter the number of students:");
        int numOfStudents = scanner.nextInt();
        
        // Input the number of pages of each book
        System.out.println("Enter the number of pages for each book:");
        for (int bookIndex = 0; bookIndex < numOfBooks; bookIndex++) {
            pagesArray[bookIndex] = scanner.nextInt();
        }
        
        // Allocate books and print the minimum number of pages
        int result = allocateBooks(List.of(pagesArray), numOfBooks, numOfStudents);
        System.out.println("Minimum number of pages for each student: " + result);

        scanner.close();
    }
}

