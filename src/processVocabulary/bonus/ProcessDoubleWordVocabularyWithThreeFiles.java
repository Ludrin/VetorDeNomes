package processVocabulary.bonus;

import java.util.Arrays;
import java.util.Set;

import utils.FileConstants;
import utils.FileUtils;
import utils.VocabularyUtils;

/**
 * Reads the contents of three files, creates a vocabulary for their content as double words in sequence
 * and counts how much times each the words of each file are used.
 *
 * @author Ernani
 *
 */
public class ProcessDoubleWordVocabularyWithThreeFiles {

    public static void main(String[] args) {
        String firstSentence = FileUtils.getFileContentAsSingleString(FileConstants.FIRST_FILE);
        String secondSentence = FileUtils.getFileContentAsSingleString(FileConstants.SECOND_FILE);
        String thirdSentence = FileUtils.getFileContentAsSingleString(FileConstants.THIRD_FILE);

        String[] wordsFirstSentence = VocabularyUtils.createDoubleWordArray(firstSentence);
        String[] wordsSecondSentence = VocabularyUtils.createDoubleWordArray(secondSentence);
        String[] wordsThirdSentence = VocabularyUtils.createDoubleWordArray(thirdSentence);

        Set<String> vocabulary = VocabularyUtils.createVocabulary(wordsFirstSentence, wordsSecondSentence, wordsThirdSentence);

        int[] wordOccurrenceVectorFirstSentence = new int[vocabulary.size()];
        VocabularyUtils.countWordsInVocabulary(wordsFirstSentence, vocabulary, wordOccurrenceVectorFirstSentence);
        System.out.println(Arrays.toString(wordOccurrenceVectorFirstSentence));

        int[] wordOccurrenceVectorSecondSentence = new int[vocabulary.size()];
        VocabularyUtils.countWordsInVocabulary(wordsSecondSentence, vocabulary, wordOccurrenceVectorSecondSentence);
        System.out.println(Arrays.toString(wordOccurrenceVectorSecondSentence));

        int[] wordOccurrenceVectorThirdSentence = new int[vocabulary.size()];
        VocabularyUtils.countWordsInVocabulary(wordsThirdSentence, vocabulary, wordOccurrenceVectorThirdSentence);
        System.out.println(Arrays.toString(wordOccurrenceVectorThirdSentence));
    }

}
