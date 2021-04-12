package db;

/**
 * This interface will define methods needed to read and write to files
 * Last Updated: 4/12/21
 * @author Edward Hicks
 */

public interface FileReadAndWriterInterface {
    public void createFile(String _fileAddress);
    public String readFile(String _fileAddress);
    public void writeToFile(String _fileAddress, String _fileContents);
    public void deleteFile(String _fileAddress);
}
