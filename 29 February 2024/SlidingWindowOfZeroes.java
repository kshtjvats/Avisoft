import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class NegativeInputException extends Exception {
    NegativeInputException(String message) {
        super(message);
    }
}

class SlidingWindowOfZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            try {
                System.out.println("Enter the size of the array");
                int sizeOfArray = scanner.nextInt();
                System.out.println("Enter the value of B");
                int B = scanner.nextInt();
                int[] Array = new int[sizeOfArray];
                if (sizeOfArray < 0 || B < 0)
                    throw new NegativeInputException("Negative sizes are not allowed. Please try again.");
                for (int iterator = 0; iterator < sizeOfArray; iterator++) {
                    System.out.print("Enter element " + (iterator + 1) + " :");
                    Array[iterator] = scanner.nextInt();
                }
                SlidingWindowOfZeroes obj = new SlidingWindowOfZeroes();
                List<Integer> answer = obj.maximumWindowSize(Array, B);
                System.err.print("[");
                for (int IndexIterator = answer.get(0); IndexIterator <= answer.get(1); IndexIterator++)
                    if (IndexIterator != answer.get(1))
                        System.out.print(IndexIterator + ",");
                    else
                        System.out.print(IndexIterator);
                System.err.print("]");
            } catch (InputMismatchException e) {
                System.err.println("Invalid input type");
                main(args);
            }
        } catch (NegativeInputException e) {
            System.err.println(e.getMessage());
            main(args);
        }
    }

    // Method to find the maximum window size of zeros
    List<Integer> maximumWindowSize(int[] Array, int B) {
        // List to store the start and end indices of the maximum window
        List<Integer> ListOfIndex = new ArrayList<Integer>();
        ListOfIndex.add(0); // Initialize start index
        ListOfIndex.add(0); // Initialize end index
        int zeroCounter = 0; // Counter to track zeros
        int forwardPointer = 0; // Pointer to move forward in the array
        int movingPointer = 0; // Pointer to iterate over the array
        int ans = 0; // Current window size
        int max = 0; // Maximum window size

        for (movingPointer = 0; movingPointer < Array.length; movingPointer++) {
            // Increment zeroCounter if the current element is zero
            if (Array[movingPointer] == 0)
                zeroCounter++;

            // Slide the window forward until zeroCounter is within limit B
            while (zeroCounter > B) {
                // If the element pointed by forwardPointer is zero, decrement zeroCounter
                if (Array[forwardPointer] == 0) {
                    zeroCounter--;
                }
                forwardPointer++;
            }

            // Update the current window size
            ans = movingPointer - forwardPointer + 1;

            // Update the maximum window size and its indices if a new maximum is found
            if (ans > max) {
                ListOfIndex.set(0, forwardPointer); // Update start index
                ListOfIndex.set(1, movingPointer); // Update end index
                max = ans; // Update maximum window size
            }
        }
        return ListOfIndex; // Return the list containing the start and end indices of the maximum window
    }
}
