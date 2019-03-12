package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Contains utility methods to read content from files.
 *
 * @author Ernani
 *
 */
public class FileUtils {

    /**
     * Reads the content of a file and stores it into a single line String.
     * This was build with .txt files in mind. Other types of files may not work.
     *
     * @param filePath The system path were the desired file is located
     * @return The content of the path in a String.
     */
    public static String getFileContentAsSingleString(String filePath) {
        String fileSentence = "";
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                fileSentence = fileSentence + scanner.nextLine() + " ";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileSentence;
    }

    /**
     * Reads the content of a file and stores each line into a Set<String> element.
     * This was build with .txt files in mind. Other types of files may not work.
     *
     * @param filePath The system path were the desired file is located
     * @return The content of the path in a Set<String>.
     */
    public static Set<String> getFileContentAsStringSet(String filePath) {
        Set<String> fileWords = new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                fileWords.add(scanner.nextLine().toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileWords;
    }
}
