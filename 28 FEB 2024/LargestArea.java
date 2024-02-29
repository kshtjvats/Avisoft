import java.util.Scanner;
import java.util.Stack;

class LargestArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array:");
        int sizeOfArray = scanner.nextInt();
        int[] heights = new int[sizeOfArray];
        System.out.println("Enter " + sizeOfArray + " elements of array:");
        for (int index = 0; index < sizeOfArray; index++) {
            heights[index] = scanner.nextInt();
        }
        System.out.println("Max area:" + findMaxHistogram(heights));
        scanner.close();
    }

    public static int findMaxHistogram(int[] heights) {
        // Stack to hold index of previous smallest and next smallest heights
        Stack<Integer> stack = new Stack<>();
        // Arrays to store indices of previous and next smallest histograms
        int[] prevSmallest = new int[heights.length];
        int[] nextSmallest = new int[heights.length];

        // Fill the prevSmallest array
        for (int currentIndex = 0; currentIndex < heights.length; currentIndex++) {
            while (!stack.isEmpty() && heights[currentIndex] <= heights[stack.peek()]) {
                // If previous smallest index has equal or more height, pop it and look for next index in stack
                stack.pop();
            }
            prevSmallest[currentIndex] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(currentIndex);
        }
        // Fill the nextSmallest array
        stack.clear(); // Clear stack for reusing
        for (int currentIndex = heights.length - 1; currentIndex >= 0; currentIndex--) {
            while (!stack.isEmpty() && heights[currentIndex] <= heights[stack.peek()]) {
                // If next smallest index has equal or more height, pop it and look for next index in stack
                stack.pop();
            }
            nextSmallest[currentIndex] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(currentIndex);
        }
        // Calculate the max area
        int maxArea = 0;
        for (int currentIndex = 0; currentIndex < heights.length; ++currentIndex) {
            int area = heights[currentIndex] * (nextSmallest[currentIndex] - prevSmallest[currentIndex] + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
