import java.util.Scanner;
import java.util.Stack;

class UnixFilePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file to simplify:");
        String filePath = scanner.next();
        System.out.println("Simplified path: " + simplifyFilePath(filePath));
        scanner.close();
    }

    // Method to simplify the path of a directory and return it
    public static String simplifyFilePath(String filePath) {
        String[] directories = filePath.split("/"); // Split directory names and add them to a list
        Stack<String> stack = new Stack<String>(); // Create a stack to simplify the path

        // Add directories to the path
        for (String directory : directories) {
            if (directory.equals("..")) // Going a step upwards in directory hierarchy
                stack.pop();
            else if (!directory.isEmpty() && !directory.equals(".")) // Push if it's a directory
                stack.push(directory);
        }

        // Construct simplified path by iterating over the stack
        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String directory : stack) {
            simplifiedPath.append(directory).append("/");
        }

        // Check for a trailing slash at the end of the string
        if (simplifiedPath.length() > 1) {
            simplifiedPath.deleteCharAt(simplifiedPath.length() - 1); // Remove trailing slash
        }
        return simplifiedPath.toString();
    }
}
