import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define a TrieNode class to represent each node in the Trie structure
class TrieNode {
    int frequency = 0; // Frequency of the current character
    TrieNode[] children = new TrieNode[26]; // Array to store children nodes

    // Constructor to initialize TrieNode
    TrieNode() {
        frequency = 0;
        // Initialize children nodes array
        for (int childIndex = 0; childIndex < 26; childIndex++) {
            children[childIndex] = null;
        }
    }
}

// Main class containing the prefix finding logic
public class ShortestUniquePrefix {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        TrieNode root = new TrieNode(); // Create the root of the Trie
        System.out.println("Enter size of array");
        int sizeOfArray=scanner.nextInt();
        String[] words = new String[sizeOfArray]; // Input words array
        System.out.println("Enter words");
        for(int arrayIterator=0;arrayIterator<sizeOfArray;arrayIterator++)
        {
            words[arrayIterator]=scanner.next();
        }
        List<String> answer = new ArrayList<String>(); // List to store results

        // Building Trie
        // Loop through each word and build the Trie
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            buildTrie(words[wordIndex], root); // Call method to build Trie for each word
        }

        // Finding shortest unique prefixes
        // Loop through each word and find its shortest unique prefix
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            answer.add(findShortestUniquePrefix(words[wordIndex], root)); // Call method to find prefix
        }
        //Printing the results
        System.out.print("[");
        for(String word:answer)
        {
            System.out.print(word+",");
        }
        System.out.print("]");
        scanner.close();//closing scanner file
    }

    // Method to build the Trie for a given word
    static void buildTrie(String word, TrieNode root) {
        TrieNode current = root; // Start from the root of the Trie
        // Loop through each character in the word
        for (int charIndex = 0; charIndex < word.length(); charIndex++) {
            char character = word.charAt(charIndex); // Get the current character
            int index = character - 'a'; // Calculate the index of the character in the children array
            // If the child node for the current character doesn't exist, create a new node
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index]; // Move to the child node
            current.frequency++; // Increment the frequency of the current character
        }
    }

    // Method to find the shortest unique prefix for a given word
    static String findShortestUniquePrefix(String word, TrieNode root) {
        TrieNode current = root; // Start from the root of the Trie
        StringBuilder prefix = new StringBuilder(); // StringBuilder to store the prefix
        // Loop through each character in the word
        for (int charIndex = 0; charIndex < word.length(); charIndex++) {
            char character = word.charAt(charIndex); // Get the current character
            int index = character - 'a'; // Calculate the index of the character in the children array
            // If the frequency of the current node is greater than or equal to 1, break the loop
            if (current.frequency == 1) {
                break;
            }
            prefix.append(character); // Append the character to the prefix
            current = current.children[index]; // Move to the child node
        }
        return prefix.toString(); // Return the prefix as a string
    }
}
