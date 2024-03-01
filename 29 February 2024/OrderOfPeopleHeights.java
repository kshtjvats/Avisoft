import java.util.ArrayList;
import java.util.Collections;

public class OrderOfPeopleHeights {

    // Method to order the heights of people based on the number of people in front of them
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        // Initialize an empty list to store the ordered heights
        ArrayList<Integer> order = new ArrayList<>();
        // List to store Node objects representing people with their heights and number of people in front of them
        ArrayList<Node> nodes = new ArrayList<>();
        // Variable to store the number of people
        int n;

        // Check if the input lists are null
        if (heights == null || infronts == null) {
            return order; // Return empty list if input lists are null
        }

        // Get the number of people
        n = heights.size();

        // Create a Binary Indexed Tree (BIT) data structure of size n
        Bit bit = new Bit(n);

        // Initialize the BIT with values 1 to n
        for (int i = 1; i <= n; i++) {
            bit.update(i, 1);
        }

        // Create Node objects for each person and add them to the 'nodes' list
        for (int i = 0; i < n; i++) {
            Node node = new Node(heights.get(i), infronts.get(i));
            nodes.add(node);
            order.add(0); // Initialize the 'order' list with zeros
        }

        // Sort the 'nodes' list based on heights (ascending order)
        Collections.sort(nodes);

        // Traverse the sorted 'nodes' list and update the 'order' list based on the number of people in front of each person
        for (int i = 0; i < n; i++) {
            Node node = nodes.get(i);
            int index = getIth(bit, node.infronts + 1, n); // Get the index where the current person should be placed
            order.set(index, node.height); // Update the 'order' list with the current person's height at the calculated index
        }

        return order; // Return the ordered heights
    }

    // Method to find the index of the i-th smallest element in the BIT
    public int getIth(Bit bit, int index, int n) {
        int start = 1;
        int end = n;
        int count = end - start + 1;
        int res = 0;

        // Binary search to find the index of the i-th smallest element
        while (count > 0) {
            int mid = (start + end) / 2;
            int val = bit.query(mid);

            if (val < index) {
                start = mid + 1;
            } else if (val > index) {
                end = mid - 1;
            } else if (val == index) {
                res = mid;
                end = mid - 1;
            }

            count /= 2;
        }

        // Update the BIT after finding the index
        bit.update(res, -1);

        return res - 1; // Return the index
    }

    // Class representing a person with height and number of people in front
    class Node implements Comparable<Node> {
        int height;
        int infronts;

        // Constructor to initialize a Node object with height and number of people in front
        public Node(int h, int i) {
            height = h;
            infronts = i;
        }

        // Method to compare Node objects based on height
        @Override
        public int compareTo(Node node) {
            return Integer.compare(height, node.height);
        }
    }

    // Class representing a Binary Indexed Tree (BIT)
    class Bit {
        int bit[];
        int N;

        // Constructor to initialize a BIT of size N
        public Bit(int N) {
            this.bit = new int[N + 10]; // Create BIT with additional space
            this.N = N;
        }

        // Method to update the BIT at index idx with value
        public void update(int idx, int value) {
            while (idx > 0 && idx <= N) {
                bit[idx] += value;
                idx += (idx & -idx); // Update the next index with bitwise operation
            }
        }

        // Method to query the sum of elements up to index idx in the BIT
        public int query(int idx) {
            int res = 0;

            while (idx > 0) {
                res += bit[idx]; // Accumulate the sum
                idx -= (idx & -idx); // Move to the previous index with bitwise operation
            }

            return res; // Return the sum
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        OrderOfPeopleHeights solution = new OrderOfPeopleHeights();

        // Static input for testing
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(5);
        heights.add(3);
        heights.add(2);
        heights.add(6);
        heights.add(1);
        heights.add(4);

        ArrayList<Integer> infronts = new ArrayList<>();
        infronts.add(0);
        infronts.add(1);
        infronts.add(2);
        infronts.add(0);
        infronts.add(3);
        infronts.add(2);

        // Get the ordered heights using the 'order' method and print the result
        ArrayList<Integer> result = solution.order(heights, infronts);
        System.out.println("Ordered heights: " + result);
    }
}
