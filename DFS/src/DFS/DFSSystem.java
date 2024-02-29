package DFS;
import java.util.ArrayList;
import java.util.Objects;

// Class representing the Distributed File System (DFS) system
class DFSSystem {
    // ArrayList to store servers in the DFS system
    ArrayList<Server> server = new ArrayList<>();

    // Method to add a server to the DFS system
    public void addServer(Server server1) {
        // Adding the server to the list of servers
        server.add(server1);
        // Printing a success message
        System.out.println("Server added successfully");
    }

    // Method to upload a file to a specific server in the DFS system
    public void uploadFile(File file, Server server1) throws DFSException {
        // Checking if the server exists in the system
        if (server.contains(server1)) {
            // Uploading the file to the specified server
            server1.uploadFile(file);
        }
    }

    // Method to download a file from a specific server in the DFS system
    public void downloadFile(String fileName, Server server1) throws DFSException {
        // Iterating through all servers in the system
        for (Server server : server) {
            // Checking if the given server exists in the system
            if (Objects.equals(server1, server)) {
                // Downloading the file from the specified server
                server1.downloadFile(fileName);
            }
        }
    }

    // Method to replicate a file from a source server to a destination server in the DFS system
    public void replicateFile(File file, Server sourceServer, Server destinationServer) throws DFSException {
        int flag = 0;
        boolean check1 = false;
        boolean check2 = false;
        // Iterating through all servers in the system
        for (Server server : server) {
            // Checking if the source server exists in the system
            if (Objects.equals(sourceServer, server)) {
                check1 = true;
                // Checking if the file exists on the source server
                boolean store = server.fileExists(file.getFileName());
                if (store == true) {
                    flag++;
                }
            }
            // Checking if the destination server exists in the system
            if (Objects.equals(destinationServer, server)) {
                check2 = true;
                flag++;
            }
        }
        // Handling different scenarios based on server and file existence
        if (!check1) {
            // Throwing exception if the source server does not exist
            throw new DFSException("Source server does not exist");
        } else if (!check2) {
            // Throwing exception if the destination server does not exist
            throw new DFSException("Destination server does not exist");
        } else if (flag == 2) {
            // Replicating the file to the destination server if both servers and file exist
            destinationServer.replicateFile(file, destinationServer);
        } else {
            // Throwing exception if the file does not exist on the source server
            throw new DFSException("File does not exist");
        }
    }
}
