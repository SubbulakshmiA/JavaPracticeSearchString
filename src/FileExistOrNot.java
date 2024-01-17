

import java.io.File;
import java.util.Scanner;

public class FileExistOrNot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String fileName = scanner.nextLine();
        // check for file exit or not
        if (checkFileExists(fileName)) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }
    //Method for checking file
    public static boolean checkFileExists(String fileName) {

        File file = new File(fileName);
        return file.exists();
    }
}







