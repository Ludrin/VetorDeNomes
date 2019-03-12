package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains utility methods to create and manipulate a vocabulary.
 *
 * @author Ernani
 *
 */
public class VocabularyUtils {

    /**
     * Creates a String[] of single words in sequence of a given String sentence.
     *
     * @param sentence the sentence in a String
     * @return a String[] containing a sequence of single words
     */
    public static String[] createSingleWordArray(String sentence) {
        return createWordArrayFromPattern(sentence, " ");
    }

    /**
     * Creates a String[] of double words in sequence of a given String sentence.
     * If the sentence has an odd number of words then one of the sequence elements will have a single word.
     *
     * @param sentence the sentence in a String
     * @return a String[] containing a sequence of double words
     */
    public static String[] createDoubleWordArray(String sentence) {
        return createWordArrayFromPattern(sentence, "(?<=\\G\\S{1,30}\\s\\S{1,30})\\s");
    }

    /**
     * Creates a Set<String> composed of unique words from n String[]s.
     *
     * @param sentenceWords a n amount of String arrays to be combined
     * @return a Set<String> of unique words from the combined arrays received as parameters
     */
    public static Set<String> createVocabulary(String[]... sentenceWords) {
        String[] nonUniqueVocabulary = mergeArrays(sentenceWords);
        System.out.println("Non unique vocabulary: " + Arrays.toString(nonUniqueVocabulary));

        Set<String> uniqueVocabulary = new HashSet<>();
        uniqueVocabulary = Arrays.stream(nonUniqueVocabulary).collect(Collectors.toSet());
        System.out.println("Unique vocabulary: " + uniqueVocabulary.toString());

        return uniqueVocabulary;
    }

    private static String[] mergeArrays(String[]... arrays) {
        return Stream.of(arrays)
                .flatMap(Stream::of)
                .toArray(String[]::new);
    }

    /**
     * Counts the occurrences of each word in a String[] given a vocabulary.
     * The words count are added in an int array at the same positions as the correspondent word of the vocabulary Set.
     *
     * @param sentenceWords       a String[] containing the words to be counted
     * @param vocabulary          a Set<String> containing the unique vocabulary words
     * @param wordOccurenceVector a int array with the same lenght as the vocabulary
     */
    public static void countWordsInVocabulary(String[] sentenceWords, Set<String> vocabulary, int[] wordOccurenceVector) {
        Arrays.stream(sentenceWords).forEach(word -> {
            if (vocabulary.contains(word)) {
                int wordIndex = getIntex(vocabulary, word);
                wordOccurenceVector[wordIndex] = wordOccurenceVector[wordIndex] + 1;
            }
        });
    }

    /**
     * Creates a String[] of words in sequence by editing a given sentence.
     * The sentence is trimmed to eliminate trailing whitespaces, removed of punctuation and split according to a given pattern.
     *
     * @param sentence     a String containing a sentence to be edited
     * @param splitPattern a String containing a pattern to split the sentence
     * @return a String[] with the words from the sentence
     */
    private static String[] createWordArrayFromPattern(String sentence, String splitPattern) {
        sentence.trim();
        sentence = sentence.replaceAll("[^A-zÀ-ÿ0-9]+", " ");
        sentence = sentence.toUpperCase();
        String[] wordsFromSentence = sentence.split(splitPattern);

        System.out.println("Array of separated words: " + Arrays.toString(wordsFromSentence));
        return wordsFromSentence;
    }

    /**
     * Gets the index of an element in a Set.
     * The Set is converted into an ArrayList which already has an indexOf method to avoid an iteration logic over the Set.
     *
     * @param vocabularySet the Set<String> containing the vocabulary
     * @param word          the word as a String to be searched for in the vocabulary Set
     * @return an int representing the index of the word in the vocabulary
     */
    private static int getIntex(Set<String> vocabularySet, String word) {
        return new ArrayList<>(vocabularySet).indexOf(word);
    }

}
