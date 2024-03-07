package VotingSystem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CSVParser {
    public Map<String, String> convertCsvToMap(String filepath) {
        Map<String, String> credentials = new HashMap<>();
        String csvSplitBy = ",";

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(filepath))) {
            bufferReader.readLine(); // Skip header line

            // Read each line of the CSV file
            String line;
            while ((line = bufferReader.readLine()) != null) {
                // Split the line into fields using the CSV separator
                String[] data = line.split(csvSplitBy);

                // Store data into the map (assuming data[0] is key and data[1] is value)
                credentials.put(data[0], data[1]);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            // Print error message if the file is not found
            System.err.println("File not found: " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            // Print error message for other I/O errors
            System.err.println("Error reading file: " + ioException.getMessage());
        }

        // Return the map containing credentials
        return credentials;
    }
}
