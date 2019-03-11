package teste;

import java.util.Arrays;
import java.util.Set;

import utils.FileUtils;
import utils.VocabularyUtils;

public class Teste {

	private static final String FIRST_FILE = "firstFile.txt";
	private static final String SECOND_FILE = "secondFile.txt";

	public static void main(String[] args) {
		String firstSentence = FileUtils.getFileContentAsSingleString(FIRST_FILE);
		String secondSentence = FileUtils.getFileContentAsSingleString(SECOND_FILE);

		String[] wordsFirstSentence = VocabularyUtils.createSingleWordArray(firstSentence);
		String[] wordsSecondSentence = VocabularyUtils.createSingleWordArray(secondSentence);

		Set<String> vocabulary = VocabularyUtils.createVocabulary(wordsFirstSentence, wordsSecondSentence);

		int[] wordVector = new int[vocabulary.size()];
		VocabularyUtils.countWordsInVocabulary(wordsFirstSentence, vocabulary, wordVector);
		VocabularyUtils.countWordsInVocabulary(wordsSecondSentence, vocabulary, wordVector);

		System.out.println(Arrays.toString(wordVector));
	}
}
