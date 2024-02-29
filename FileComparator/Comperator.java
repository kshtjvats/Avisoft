//imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.time.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
// Class to compare text files and generate a report for differences
class TextComparator {
  static Scanner sc = new Scanner(System.in); // Scanner object for user input
  int c = 0; // Counter variable

  // Method to check if two files have the same content
  boolean isSame(String filepath, String filepath1) {
    boolean flag = true; // Flag to track if content is the same
    String line, line2; // Strings to store lines from the files
    String delimiter = "\\."; // Separator for splitting lines into sentences
    try {
      BufferedReader bufferReader = new BufferedReader(new FileReader(filepath)); // Reader for first file
      BufferedReader bufferReader2 = new BufferedReader(new FileReader(filepath1)); // Reader for second file
      // Read lines from both files simultaneously
      while ((line = bufferReader.readLine()) != null && (line2 = bufferReader2.readLine()) != null) {
        String[] sentences = line.split(delimiter); // Split line into sentences
        String[] sentences2 = line2.split(delimiter); // Split line from second file into sentences
        bufferReader.close(); // Close reader for first file
        bufferReader2.close(); // Close reader for second file
        // Iterate over sentences in each line
        for (int lineIterator = 0; lineIterator < sentences.length; lineIterator++) {
          String[] words = sentences[lineIterator].split(" "); // Split sentence into words
          String[] words2 = sentences2[lineIterator].split(" "); // Split sentence from second file into words
          // Iterate over words in each sentence
          for (int wordIterator = 0; wordIterator < words.length; wordIterator++) {
            // If corresponding words in the sentences are not equal, set flag to false
            if (!words[wordIterator].equals(words2[wordIterator])) {
              flag = false;
              break;
            }
          }
        }
      }
    } catch (IOException e) {
      // Handle IO exception
      System.err.println(e.getMessage());
    }
    return flag; // Return whether files have the same content
  }

  // Method to generate a report highlighting differences between two text files
  void CompareText(String filepath, String filepath1) {
    // If files have different content
    if (isSame(filepath, filepath1)==true)
    {
        System.out.println("Same files!");
    }
    else
    {
      String line, line2; // Strings to store lines from the files
      String delimiter = "\\."; // Separator for splitting lines into sentences
      try {
        BufferedReader bufferReader = new BufferedReader(new FileReader(filepath)); // Reader for first file
        BufferedReader bufferReader2 = new BufferedReader(new FileReader(filepath1)); // Reader for second file
        try 
        {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh mm a", Locale.ENGLISH); // Formatter for current date and time
        LocalDateTime now = LocalDateTime.now(); // Get current date and time
        System.out.println(dateTimeFormat.format(now)); // Print current date and time
        String path = "files/" + (String) dateTimeFormat.format(now) + ".txt"; // Path for the report file
        // Read lines from both files simultaneously
        while ((line = bufferReader.readLine()) != null && (line2 = bufferReader2.readLine()) != null) {
          String[] sentences = line.split(delimiter); // Split line into sentences
          String[] sentences2 = line2.split(delimiter); // Split line from second file into sentences
          bufferReader.close();
          bufferReader2.close(); //closing buffer readers
          if((String) dateTimeFormat.format(now)==null) //throwing custom exception for not retrieving local date or time
          {
        throw new Exception("Cannot Retrieve Local Date/Time");
          }
          // Write differences to the report file
          try (FileWriter writer = new FileWriter(path)) {
            writer.write("Line Number  Index   Actual  Expected\n"); // Header for the report
            // Iterate over sentences in each line
            for (int lineIterator = 0; lineIterator < sentences.length; lineIterator++) {
              String[] words = sentences[lineIterator].split(" "); // Split sentence into words
              String[] words2 = sentences2[lineIterator].split(" "); // Split sentence from second file into words
              // Iterate over words in each sentence
              for (int wordIterator = 0; wordIterator < words.length; wordIterator++) {
                // If corresponding words in the sentences are different, write to report
                if (!words[wordIterator].equals(words2[wordIterator]))
                  writer.write("Line:" + (lineIterator + 1) + " " + "Index " + wordIterator + " Actual :" + words[wordIterator] + " Expected :" + words2[wordIterator] + "\n");
              }
            }
            System.out.println("File saved in folder as " + path); // Inform user about the saved report
          } catch (NoSuchFileException e) {
            // Handle IO exception
            System.err.println(e.getMessage());
          }
        }
      }
      catch (Exception e) {
          // Handle the exception (e.g., print error message)
          System.err.println("Error: Unable to retrieve local date and time.");
          e.printStackTrace();
      }
     }catch (FileNotFoundException e) {
        // Handle IO exception
        e.printStackTrace();
      }
    }
  }
}

// Class to compare CSV files and generate a report for differences
class CsvComparator {
  static Scanner sc = new Scanner(System.in); // Scanner object for user input
  int c = 0; // Counter variable

  // Method to read CSV file and store its contents in a 2D array
  String[][] csv(String filepath) {
    String line; // String to store each line from the CSV file
    String csvSplitBy = ","; // Separator for splitting CSV fields
    int[] sz=getCSVDimensions(filepath); //finding size
    String[][] storage = new String[sz[0]][sz[1]]; // 2D array to store CSV data
    try (BufferedReader bufferReader = new BufferedReader(new FileReader(filepath))) {
      int[] dimensions = getCSVDimensions(filepath); // Get dimensions of the CSV file
      int c = 0; // Counter for rows
      // Read each line from the CSV file
      while ((line = bufferReader.readLine()) != null) {
        // Split the line into fields
        String[] data = line.split(csvSplitBy);

        // Store fields in the 2D array
        for (int i = 0; i < dimensions[1]; i++) {
          storage[c][i] = data[i];
        }
        c++; // Increment row counter
      }
    } catch (IOException e) {
      e.printStackTrace(); // Handle IO exception
    }
    return storage; // Return the 2D array containing CSV data
  }

  // Method to check if two CSV files have the same content
  boolean isSame(String[][] actual, String[][] expected) {
    boolean flag = true; // Flag to track if content is the same
    // Iterate over each cell of both CSV files
    for (int rowIterator = 0; rowIterator < actual.length; rowIterator++) {
      for (int columnIterator = 0; columnIterator < actual[0].length; columnIterator++) {
        // If corresponding cells in the files are different, set flag to false
        if (!actual[rowIterator][columnIterator].equals(expected[rowIterator][columnIterator])) {
          flag = false;
        }
      }
    }
    return flag; // Return whether files have the same content
  }

  // Method to compare two CSV files and generate a report highlighting differences
  void CompareCsv(String[][] actual, String[][] expected) {
    System.out.println("Enter 1 to avoid one field during comparison");
    int c = sc.nextInt(); // User input to avoid a field during comparison
    int ch = -1; // Variable to store user's choice of field to avoid
    // If user chooses to avoid a field during comparison
    if (c == 1) {
      System.out.println("Enter the field name to avoid during comparison");
      // Display field names for user to choose from
      for (int i = 0; i < actual[0].length; i++) {
        System.out.println((i + 1) + ": Omit " + actual[0][i]);
      }
      try{
      ch = sc.nextInt(); // User input for field to avoid
      if(ch>actual[0].length)
      throw new Exception("Invalid Choice");
      }
      catch(Exception e)
      {
        System.err.println(e.getMessage());
        return;
      }
    }
    // If files have different content
    if (!isSame(actual, expected)) {
      try{
      DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh mm a", Locale.ENGLISH); // Formatter for current date and time
      LocalDateTime now = LocalDateTime.now(); // Get current date and time
      System.out.println(dateTimeFormat.format(now)); // Print current date and time
      String path = "files/" + (String) dateTimeFormat.format(now) + ".csv"; // Path for the report file
      if ((String)dateTimeFormat.format(now)==null)
      {
        throw new Exception("Cannot Retrieve local time/date");
      }
      try (FileWriter writer = new FileWriter(path)) {
        writer.write("Omitted field:" + actual[0][ch - 1] + "\n"); // Write omitted field to report
        // Iterate over rows of the CSV files
        for (int rowIterator = -1; rowIterator < actual.length; rowIterator++) {
          // If it's the first row, write the header to the report
          if (rowIterator == -1) {
            writer.write("RowNumber,Expected,Actual\n");
            continue;
          } else {
            // Iterate over columns of the CSV files
            for (int columnIterator = 0; columnIterator < actual[0].length; columnIterator++) {
              // If user chose to avoid a field and the current column is the one to avoid, skip it
              if (columnIterator == ch - 1 && ch > -1) {
                continue;
              }
              // If corresponding cells in the files are different, write to report
              if (!actual[rowIterator][columnIterator].equals(expected[rowIterator][columnIterator])) {
                writer.write("Row:" + rowIterator + "," + actual[0][columnIterator] + ":" + actual[rowIterator][columnIterator] + "," + actual[0][columnIterator] + ":" + expected[rowIterator][columnIterator] + "\n");
              }
            }
          }
        }
      } catch (FileNotFoundException e) {
        // Handle IO exception
        System.err.println(e.getMessage());
      }
      System.out.println("File saved in folder as " + path); // Inform user about the saved report
    }
catch (Exception e) {
    // Handle the exception (e.g., print error message)
    System.err.println("Error: Unable to retrieve local date and time.");
    e.printStackTrace();
}
    }
  }

  // Method to get the dimensions (number of rows and columns) of a CSV file
  static int[] getCSVDimensions(String filePath) {
    try (BufferedReader bufferReader = new BufferedReader(new FileReader(filePath))) {
      int numRows = 0; // Counter for rows
      int numCols = 0; // Counter for columns
      String line; // String to store each line from the CSV file
      int[] dim = new int[2]; // Array to store dimensions
      // Read the first line to determine the number of columns
      if ((line = bufferReader.readLine()) != null) {
        String[] columns = line.split(",");
        numCols = columns.length; // Set number of columns
        numRows++; // Increment row counter
      }
      // Read remaining lines to determine the number of rows
      while ((line = bufferReader.readLine()) != null) {
        numRows++; // Increment row counter
      }
      dim[0] = numRows; // Set number of rows
      dim[1] = numCols; // Set number of columns
      return dim; // Return dimensions
    } catch (IOException e) {
      e.printStackTrace(); // Handle IO exception
    }
    return null;
  }
}
class Main {
  public static void main(String[] args) throws IOException {
    Set < String > fileNames = getFileNamesInFolder("files/"); // Get file names in the specified folder
    Scanner sc = new Scanner(System.in);
    int switchChoice=0;
    //while loop to execute switch case
    while(switchChoice!=-1)
    {
    System.out.println("Enter a choice : ");
    System.out.println("1 : Compare CSV Files");
    System.out.println("2 : Compare Text Files");
    System.out.println("1- : To exit!");
    try{
    switchChoice=sc.nextInt();
    }
    catch(InputMismatchException e)
    {
      System.err.println("Invalid entry");
      main(args);
    }
    //switch case to handle text or csv file exclusively based on input prefrence
    switch(switchChoice)
    {
    case 1:
    try {
      System.out.println("Enter the path of first csv file");
      String path1 = sc.next();
      System.out.println("Enter the path of second csv file");
      String path2 = sc.next();
      // Validate file names
      if (!fileNames.contains(path1) || !fileNames.contains(path2)) {
        throw new NoSuchFileException("Invalid file name, file does not exist");
      }

      // Validate file extensions
      if (!path1.contains(".csv") || !path2.contains(".csv")) {
        throw new NoSuchFileException("Invalid extension!");
      }
    // Create instances of comparators
      CsvComparator obj = new CsvComparator();
      // Read CSV files and perform comparison
      String[][] actual = obj.csv(path1);
      String[][] expected = obj.csv(path2);
      obj.CompareCsv(actual, expected); // Compare CSV files
    } catch (NoSuchFileException e) {
      System.err.println(e.getMessage());
    }
    break;
    case 2:
    try {
        System.out.println("Enter the path of first text file");
        String path1 = sc.next();
        System.out.println("Enter the path of second text file");
        String path2 = sc.next();
        // Validate file names
        if (!fileNames.contains(path1) || !fileNames.contains(path2)) {
          throw new NoSuchFileException("Invalid file name, file does not exist");
        }
  
        // Validate file extensions
        if (!path1.contains(".txt") || !path2.contains(".txt")) {
          throw new NoSuchFileException("Invalid extension!");
        }
      // Create instances of comparators
        TextComparator obj=new TextComparator();
        // Read text files and perform comparison
        obj.CompareText(path2, path1);
      } catch (NoSuchFileException e) {
        System.err.println(e.getMessage());
      }
      break;
      default:
      break;
    }
    }
    sc.close();
}
  // Method to get file names in a specified folder
  public static Set < String > getFileNamesInFolder(String directoryPath) {
    Set < String > fileNames = new HashSet < > (); // Set to store file names

    try {
      // Get the directory path as a Path object
      Path dirPath = Paths.get(directoryPath);

      // Iterate over the directory and add file names to the set
      Files.list(dirPath)
        .filter(Files::isRegularFile)
        .map(Path::getFileName)
        .map(Path::toString)
        //add files folder name exclusively
        .map(fileName -> "files/" + fileName)
        .forEach(fileNames::add);
    } catch (IOException e) {
      System.err.println("Directory not found");;
    }
    return fileNames; // Return set of file names
  }
}