package DFS;
import java.util.ArrayList;
import java.util.Objects;

// Class representing the FileSystem and containing the main method
public class FileSystem {
    // Main method to demonstrate the functionality of the Distributed File System (DFS)
    public static void main(String[] args) {
        // Creating servers with different configurations
        Server server1 = new Server(1, 1000); // Server with ID 1 and size 100 MB
        Server server2 = new Server(2, 1500); // Server with ID 2 and size 150 MB
        Server server3 = new Server(3, 100);   // Server with ID 3 and size 100 MB

        // Create a DFS system and add servers to it
        DFSSystem dfsSystem = new DFSSystem();
        dfsSystem.addServer(server1);
        dfsSystem.addServer(server2);

        // Creating files with different attributes
        File file1 = new File("file1.txt", 50, false);
        File file2 = new File("file2.txt", 120, true);
        File file3 = new File("file3.txt", 80, false);

        try {
            // Upload files to servers
            dfsSystem.uploadFile(file1, server1);
            dfsSystem.uploadFile(file2, server1);
            dfsSystem.uploadFile(file3, server2);

            // Download files from servers
            dfsSystem.downloadFile("file1.txt", server1);
            dfsSystem.downloadFile("file2.txt", server1);
            dfsSystem.downloadFile("file3.txt", server2);

            // Replicate files between servers
            dfsSystem.replicateFile(file1, server1, server3);
            dfsSystem.replicateFile(file2, server1, server2);
        } catch (DFSException e) {
            // Catching and printing DFSException if it occurs during the operations
            System.out.println("DFS Exception: " + e.getMessage());
        }
    }
}