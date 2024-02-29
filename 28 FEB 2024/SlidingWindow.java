import java.util.Scanner;
import java.util.List;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.ArrayDeque;
import java.util.ArrayList;

class SlidingWindow{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //using a try catch block to handle exceptions while input
        try{ 
        System.out.println("Enter the size of the input array:");
        int sizeOfArray = scanner.nextInt();
        System.out.println("Enter the window size:");
        int windowSize = scanner.nextInt();
        scanner.close();
        if(sizeOfArray <0||windowSize<0)
        {
            System.out.println("Invlaid input");
            main(args);
        }
        int[] array = new int[sizeOfArray];
        System.out.println("Enter the " + sizeOfArray + " elements of the input array:");
        for (int index = 0; index < sizeOfArray; ++index)
            array[index] = scanner.nextInt();
        List<Integer> resultArray = slidingWindowMaximum(array, windowSize);
        // Print the resultant array of maximum elements
        for (int index = 0; index < resultArray.size(); ++index)
            System.out.println(resultArray.get(index));
    }
    //basic Input mismatch exception
    catch(InputMismatchException e)
    {
        System.err.println("Invalid input");
        main(args);
    }
}

    // Calculates the sliding window maximum array
    public static List<Integer> slidingWindowMaximum(int[] array, int windowSize) {
        // List to store the result
        List<Integer> resultArray = new ArrayList<Integer>();
        // Deque to keep track of the index of the max element in the window
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            if (!deque.isEmpty() && (currentIndex - windowSize) == deque.peekFirst()) // When the first element exits the window
                deque.pollFirst();
            while (!deque.isEmpty() && array[currentIndex] > array[deque.peekLast()]) // If the currentIndex element is greater than the last max element index added
                deque.pollLast();
            deque.add(currentIndex); // Add the currentIndex element
            if (currentIndex >= (windowSize - 1)) // Start adding to the result when the first window is reached
                resultArray.add(array[deque.peekFirst()]);
        }
        return resultArray;
    }
}
