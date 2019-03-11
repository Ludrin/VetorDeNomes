package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {

	public static String getFileContentAsSingleString(String filePath) {
		String fileSentence = "";
		try {
			Scanner scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()) {
				fileSentence = fileSentence + scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Sentence from file: " + fileSentence);
		return fileSentence;
	}
}
