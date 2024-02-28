import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.time.*;
import java.util.HashSet;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TextComperator{
    static Scanner sc = new Scanner(System.in);
    int c=0;
    String[][] text(String filepath) {
        String line;
        String csvSplitBy = "."; // CSV separator
        String[][]storage=new String[308][16];
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                int c=0;
                while ((line = br.readLine()) != null) {
                    // Split the line into fields
                    String[] data = line.split(csvSplitBy); 
                    storage[c]=data;
                    c++;
                    }
                    System.out.println(storage[1][2]);
                }
             catch (IOException e) {
                e.printStackTrace();
            }
            return storage;
}
}
class CsvComperator {
    static Scanner sc = new Scanner(System.in);
    int c=0;
    String[][] csv(String filepath) {
        String line;
        String csvSplitBy = ","; // CSV separator
        String[][]storage=new String[308][16];
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                int[] dimensions=getCSVDimensions(filepath);
                int c=0;
                while ((line = br.readLine()) != null) {
                    // Split the line into fields
                    String[] data = line.split(csvSplitBy); 
                    for(int i=0;i<dimensions[1];i++)
                    {
                    storage[c][i]=data[i];
                    }
                    c++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return storage;
        }
        boolean isSame(String[][]file1,String[][]file2)
        {
            boolean flag=true;
            for(int i=0;i<file1.length;i++)
        {
                    for(int j=0;j<file1[0].length;j++)
                    {
                        if(file1[i][j].equals(file2[i][j])==false)
                        {
                                flag=false;
                        }
                        }
                        
                    }
                        return flag;
        }
       void Comperator(String[][]file1,String[][]file2)
       {
        System.out.println("Enter 1 to avoid one field during comparison");
        int c=sc.nextInt();
        int ch=-1;
        if(c==1)
        {
        System.out.println("Enter the field name to avoid during comparison");
        for(int i=0;i<file1[0].length;i++)
        {
            System.out.println((i+1)+": Omitt "+file1[0][i]);
        }
        ch=sc.nextInt();
    }
        if(isSame(file1, file2)==false)
        {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy hh mm a", Locale.ENGLISH);
        LocalDateTime now=LocalDateTime.now();
        System.out.println(dtf.format(now));
        String path="files/"+(String)dtf.format(now)+".csv";
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("ommited field:"+file1[0][ch-1]+"\n");
        for(int i=-1;i<file1.length;i++)
        {
            if(i==-1)
            {
                writer.write("RowNumber,Expected,Actual\n");
                continue;
            }
            else
            {
            for(int j=0;j<file1[0].length;j++)
            {
                if(j==ch-1&&ch>-1)
                {
                continue;
                }
                if(file1[i][j].equals(file2[i][j])==false)
                {
                        writer.write("Row:"+i+","+file1[0][j]+":"+file1[i][j]+","+file1[0][j]+":"+file2[i][j]+"\n"); // CSV header
                }
                }
            }
        }
    }
                    catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.println("File saved in folder CSV COMPARE/"+path);
                }
            }
                static int[] getCSVDimensions(String filePath) {
                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        int numRows = 0;
                        int numCols = 0;
                        String line;
                        int[]dim=new int[2];
                        // Read the first line to determine the number of columns
                        if ((line = br.readLine()) != null) {
                            String[] columns = line.split(",");
                            numCols = columns.length;
                            numRows++;
                        }
                        // Read remaining lines to determine the number of rows
                        while ((line = br.readLine()) != null) {
                            numRows++;
                        }
                        return new int[]{numRows, numCols};
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }
class Main
{
    public static void main(String[] args)throws IOException{
        Set<String> fileNames = getFileNamesInFolder("files/");
        Scanner sc=new Scanner(System.in);
        try{
        System.out.println("Enter the path of first csv file");
        String path1=sc.nextLine();
        System.out.println("Enter the path of first csv file");
        String path2=sc.nextLine();
        if(fileNames.contains(path1)==false||fileNames.contains(path2)==false)
        throw new IOException("Invalid file name, file does not exist");
        if(path1.contains(".csv")==false||path2.contains(".csv")==false)
        throw new IOException("Invalid extension!");
        CsvComperator obj=new CsvComperator();
        TextComperator obj2=new TextComperator();
        String[][] file1=obj.csv(path1);
        String[][] file2=obj.csv(path2);
    

        obj.Comperator(file1, file2);
        obj2.text("files/Actual.txt");
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        
}
public static Set<String> getFileNamesInFolder(String directoryPath) {
    Set<String> fileNames = new HashSet<String>();

    try {
        // Get the directory path as a Path object
        Path dirPath = Paths.get(directoryPath);

        // Iterate over the directory and add file names to the set
        Files.list(dirPath)
             .filter(Files::isRegularFile)
             .map(Path::getFileName)
             .map(Path::toString)
             .map(fileName -> "files/" + fileName)
             .forEach(fileNames::add);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return fileNames;
}
}
