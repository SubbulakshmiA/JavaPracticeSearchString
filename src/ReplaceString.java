import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

public class ReplaceString {
    static boolean wordPresent = false;
    public static void main(String[] args) throws IOException {

        //declare as empty
        String sourceFileName = "";
        String targetFileName = "";
        String oldString = "";
        String newString = "";

        //Through commandline
        System.out.println("please enter source file with path..");
        Scanner scanner=new Scanner(System.in);
        sourceFileName=scanner.nextLine();

        try{

//            if(FileExistOrNot.checkFileExists(sourceFileName)){
            if(isValidFile(sourceFileName)){

                System.out.println("FIle exist");
                System.out.println("please enter target file with path..");
                targetFileName=scanner.nextLine();
                System.out.println("please enter old string..");
                oldString=scanner.nextLine();
                if(!oldString.equals("") && wordExistsInFile(sourceFileName,oldString)){
                    System.out.println("please enter new string..");
                    newString=scanner.nextLine();

                }else {
                    System.out.println("Enter valid old string");
                }

            }
            replaceStringFromSourceToTarget(sourceFileName, targetFileName, oldString, newString);

        }catch (IOException e){
            System.out.println("Source FIle not exist or enter a valid source path");
            System.out.println(e);
        }
    }
    //Replace string method
    public static void replaceStringFromSourceToTarget(String sourceFileName, String targetFileName, String oldString, String newString)
            throws IOException {
        // Open the source file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
            String modifiedLine = line.replaceAll("\\b" + oldString + "\\b", newString);
                writer.write(modifiedLine);
                writer.newLine(); // Add a newline character to separate lines
            }
        }
    }

    private static boolean isValidFile(String fileName) {
        Path filePath = Paths.get(fileName);
        return Files.exists(filePath) && Files.isReadable(filePath) && !Files.isDirectory(filePath);     }

    private static boolean wordExistsInFile(String fileName, String word) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                return true;
            }
        }

    reader.close();
} catch (IOException e) {
    // Handle IOException
         e.printStackTrace();
         }
         return false;
}
}




