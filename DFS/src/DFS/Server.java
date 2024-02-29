package DFS;
import java.util.ArrayList;
import java.util.Objects;

// Class representing a server in the Distributed File System (DFS)
class Server {
    // Attributes of the server
    private int serverId;   // ID of the server
    private int serverSize; // Size of the server in MB
    ArrayList<File> file = new ArrayList<>(); // List of files stored on the server

    // Constructor to initialize the server with ID and size
    public Server(int serverId, int serverSize) {
        this.serverId = serverId;
        this.serverSize = serverSize;
    }

    // Method to upload a file to the server
    public void uploadFile(File file1) throws DFSException {
        // Checking if there is enough free space on the server
        if (calculateFreeSpace() < file1.getFileSize()) {
            // Throwing exception if there is insufficient space
            throw new DFSException("Insufficient space on the server");
        }
        // Adding the file to the server and updating server size
        file.add(file1);
        serverSize -= file1.getFileSize();
    }

    // Method to check if a file with the given name exists on the server
    public boolean fileExists(String fileName) {
        for (File file : file) {
            if (Objects.equals(file.getFileName(), fileName)) {
                return true;
            }
        }
        return false;
    }

    // Method to download a file from the server
    public void downloadFile(String fileName) throws DFSException {
        for (File file : file) {
            if (Objects.equals(file.getFileName(), fileName)) {
                System.out.println("File is Downloaded");
                return;
            }
        }
        System.out.println("Not downloaded");
    }

    // Method to replicate a file from this server to another server
    public void replicateFile(File file, Server destinationServer) throws DFSException {
        System.out.println("File Replicated");
        destinationServer.uploadFile(file);
    }

    // Method to calculate the free space on the server
    private int calculateFreeSpace() {
        int usedSpace = 0;
        for (File file : file) {
            usedSpace += file.getFileSize();
        }
        return serverSize - usedSpace;
    }
}

