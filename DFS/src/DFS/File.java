package DFS;
// Class representing a file in the Distributed File System (DFS)
class File {
    // Attributes of the file
    private String fileName;    // Name of the file
    private int fileSize;       // Size of the file
    private boolean isReplicated;   // Flag indicating whether the file is replicated

    // Constructor to initialize the file attributes
    public File(String fileName, int fileSize, boolean isReplicated) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = isReplicated;
    }

    // Method to get the size of the file
    public int getFileSize() {
        return fileSize;
    }

    // Method to get the name of the file
    public String getFileName() {
        return fileName;
    }

    // Method to check if the file is replicated
    public boolean isReplicated() {
        return isReplicated;
    }
}