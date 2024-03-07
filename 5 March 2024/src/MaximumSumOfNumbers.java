import java.util.ArrayList;
import java.util.List;
public class MaximumSumOfNumbers {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        int[] maxNumbers = getMaxNumbers(array);
        System.out.println("Maximum numbers from each index: " + maxNumbers[0] + ", " + maxNumbers[1]);
    }
    // Function to find maximum numbers from each index in a 2D array
    static int[] getMaxNumbers(int[][] array) {
        // List to store the maximum values obtained so far
        List<Integer> maxValues = new ArrayList<>();
        // Array to store the maximum numbers from each index
        int[] maxNumbers = new int[2];

        // Add the maximum value from the first column to the list
        maxValues.add(Math.max(array[0][0], array[1][0]));
        maxNumbers[0] = maxValues.get(0);

        // If there is only one column, return the maximum values found
        if (array[0].length == 1)
            return maxNumbers;

        // Add the maximum value from the second column to the list
        maxValues.add(Math.max(array[0][1], array[1][1]));
        maxNumbers[1] = maxValues.get(1);

        // Iterate through the remaining columns
        for (int iterator = 2; iterator < array[0].length; iterator++) {
            // Calculate the maximum value considering the current column and the previous two columns
            int maxSum = Math.max(Math.max(array[0][iterator], array[1][iterator]) + maxValues.get(iterator - 2), maxValues.get(iterator - 1));
            maxValues.add(maxSum);

            // Update the maximum numbers if the current number is greater
            int currentMax = Math.max(array[0][iterator], array[1][iterator]);
            if (currentMax > maxNumbers[0])
                maxNumbers[0] = currentMax;
            else if (currentMax > maxNumbers[1])
                maxNumbers[1] = currentMax;
        }

        // Return the array containing the maximum numbers from each index
        return maxNumbers;
    }
}
