import java.util.Scanner;

public class ArrayProduct {

    // Function to calculate the product of elements at all positions in the array
    public static void arrayProducts(int n, int[] arr, int[] rarr) {
        // Calculate product of elements to the left of each element
        int product = 1;
        for (int i = 0; i < n; i++) {
            rarr[i] = product;
            product *= arr[i];
        }

        // Calculate product of elements to the right of each element and multiply with left product
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            rarr[i] *= product;
            product *= arr[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];  // Declare array of size n to store user input
        int[] rarr = new int[n]; // Declare array to store result

        // Prompt the user to enter the elements of the array
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the arrayProducts function to calculate product of elements at all positions
        arrayProducts(n, arr, rarr);

        // Print the elements of the result array
        System.out.print("rarr: ");
        for (int i = 0; i < n; i++) {
            System.out.print(rarr[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
