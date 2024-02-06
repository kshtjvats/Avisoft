//QUESTION 11

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue{
public static void reverseQueue(Queue<Integer> queue) {
    if (queue.isEmpty()) {
        return;
    }

    int front = queue.poll();   //take first element after each recursive call
    reverseQueue(queue);
    queue.add(front);           //add the element present in front
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Queue<Integer> queue = new LinkedList<>();

    System.out.print("Enter the number of elements in the queue: ");
    int n = scanner.nextInt();
    System.out.println("Enter the elements of the queue:");
    for (int i = 0; i < n; i++) {
        int element = scanner.nextInt();
        queue.add(element);
    }


    reverseQueue(queue);
    System.out.println("Reversed Queue: " + queue);

    scanner.close();
}
}