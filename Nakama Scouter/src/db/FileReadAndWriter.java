package db;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class handles all reading and writing to files at addresses provided
 * by the user.
 * Last updated: 4/12/21
 * @author Edward Hicks
 */

public class FileReadAndWriter implements FileReadAndWriterInterface {

    /**
     * This method creates a new file at the provided address.
     * @param _fileAddress
     */
    @Override
    public void createFile(String _fileAddress){
        try {
            File newFile = new File(_fileAddress);
            if (newFile.createNewFile())
                System.out.println("File created: " + newFile.getName());
            else
                System.out.println("File already exists.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    /**
     * This method reads the file at the provided address and returns the contents.
     * @param _fileAddress
     * @return
     */
    @Override
    public String readFile(String _fileAddress){
        String fileContents = "";
        try {
            File fileToRead = new File(_fileAddress);
            Scanner scanner = new Scanner(fileToRead);
            //Continuously read the contents of the file and add it to the output.
            while (scanner.hasNextLine()) {
                fileContents += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
            fileContents = "!AN_ERROR_HAS_OCCURRED!";
        }
        return fileContents;
    }

    /**
     * This method writes the provided content to the file at the provided address.
     * @param _fileAddress
     * @param _fileContents
     */
    @Override
    public void writeToFile(String _fileAddress, String _fileContents){
        try {
            FileWriter fileWriter = new FileWriter(_fileAddress);
            fileWriter.write(_fileContents);
            fileWriter.close();
            System.out.println("Successfully wrote to " + _fileAddress);
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    /**
     * This method deletes the file located at the provided address.
     * @param _fileAddress
     */
    @Override
    public void deleteFile(String _fileAddress) {
        File deadFile = new File(_fileAddress);
        if (deadFile.delete())
            System.out.println("Deleted file at " + _fileAddress);
        else
            System.out.println("Failed to delete the file.");
    }
}
