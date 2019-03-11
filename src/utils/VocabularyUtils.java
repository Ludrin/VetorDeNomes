package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VocabularyUtils {

	public static String[] createSingleWordArray(String sentence) {
		sentence.trim();
		sentence = sentence.replaceAll("[^A-zÀ-ÿ0-9]+", " ");
		sentence = sentence.toUpperCase();
		String[] wordsFromSentence = sentence.split(" ");

		System.out.println("Array of separated words: " + Arrays.toString(wordsFromSentence));
		return wordsFromSentence;
	}

	public static Set<String> createVocabulary(String[] wordsFirstSentence, String[] wordsSecondSentence) {
		String[] nonUniqueVocabulary = Stream
				.concat(Arrays.stream(wordsFirstSentence), Arrays.stream(wordsSecondSentence)).toArray(String[]::new);
		System.out.println("Non unique vocabulary: " + Arrays.toString(nonUniqueVocabulary));

		Set<String> uniqueVocabulary = new HashSet<>();
		uniqueVocabulary = Arrays.stream(nonUniqueVocabulary).collect(Collectors.toSet());
		System.out.println("Unique vocabulary: " + uniqueVocabulary.toString());

		return uniqueVocabulary;
	}

	public static void countWordsInVocabulary(String[] wordsFirstSentence, Set<String> vocabulary, int[] wordVector) {
		Arrays.stream(wordsFirstSentence).forEach(word -> {
			if (vocabulary.contains(word)) {
				int wordIndex = getIntex(vocabulary, word);
				wordVector[wordIndex] = wordVector[wordIndex] + 1;
			}
		});
	}

	public static int getIntex(Set<String> vocabulario, String palavra) {
		List<String> vocabularioList = new ArrayList<>(vocabulario);

		return vocabularioList.indexOf(palavra);
	}

}
