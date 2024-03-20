import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashSet {
    int size=1000000;
    int[] array;

    HashSet() {
        array = new int[size];
    }

    void add(int element) {
        if (!contains(element)) {
            hashSetElements.add(element);
        }
    }

    boolean contains(int element) {
        return hashSetElements.contains(element);
    }

    void remove(int element) {
        if (contains(element)) {
            hashSetElements.remove(Integer.valueOf(element)); // Remove by object
            System.out.println(element);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet hashSet = new HashSet();
        List<int[]> queryList = new ArrayList<int[]>();
        System.out.println("Enter the size of your query");
        int size = scanner.nextInt();
        for (int iterator = 0; iterator < size; iterator++) {
            int[] queries = new int[2]; // Create a new array for each query
            queries[0] = scanner.nextInt();
            queries[1] = scanner.nextInt();
            queryList.add(queries);
        }
        for (int[] query : queryList) {
            switch (query[0]) {
                case 1:
                    hashSet.add(query[1]);
                    break;
                case 2:
                    System.out.println(hashSet.contains(query[1]));
                    break;
                case 3:
                    hashSet.remove(query[1]);
                    break;
                default:
                    break;
            }
        }

    }
}
