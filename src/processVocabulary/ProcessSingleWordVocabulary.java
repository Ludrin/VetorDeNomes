package processVocabulary;

import java.util.Arrays;
import java.util.Set;

import utils.FileUtils;
import utils.VocabularyUtils;

/**
 * Reads the contents of two files, creates a vocabulary for their content as single words in sequence
 * and counts how much times each the words of each file are used.
 * 
 * @author Ernani
 *
 */
public class ProcessSingleWordVocabulary {

    private static final String FIRST_FILE = "firstFile.txt";
    private static final String SECOND_FILE = "secondFile.txt";

    public static void main(String[] args) {
        String firstSentence = FileUtils.getFileContentAsSingleString(FIRST_FILE);
        String secondSentence = FileUtils.getFileContentAsSingleString(SECOND_FILE);

        String[] wordsFirstSentence = VocabularyUtils.createSingleWordArray(firstSentence);
        String[] wordsSecondSentence = VocabularyUtils.createSingleWordArray(secondSentence);

        Set<String> vocabulary = VocabularyUtils.createVocabulary(wordsFirstSentence, wordsSecondSentence);

        int[] wordOccurrenceVectorFirstSentence = new int[vocabulary.size()];
        VocabularyUtils.countWordsInVocabulary(wordsFirstSentence, vocabulary, wordOccurrenceVectorFirstSentence);
        System.out.println(Arrays.toString(wordOccurrenceVectorFirstSentence));

        int[] wordOccurrenceVectorSecondSentence = new int[vocabulary.size()];
        VocabularyUtils.countWordsInVocabulary(wordsSecondSentence, vocabulary, wordOccurrenceVectorSecondSentence);
        System.out.println(Arrays.toString(wordOccurrenceVectorSecondSentence));
    }
}
