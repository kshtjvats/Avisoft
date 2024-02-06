import java.util.Scanner;
import java.util.Stack;
public class SortStack {
  public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, temp);
        }
    }

    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter the number of elements in the stack: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the stack:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        sortStack(stack);
        System.out.println("Sorted stack: " + stack);


    }
}


