/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatewords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author sami
 */
public class DuplicateWords {

    private static final String INPUT = "Cat cat cat cattie cat";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> wordsWithCase = DuplicateWords(INPUT);
        List<String> wordsWithoutCase = DuplicateWordsDespiteOfCase(INPUT);
        CountDuplicateWords(INPUT, wordsWithCase);
        CountDuplicateWords(INPUT, wordsWithoutCase);
    }

    /**
     * Find the duplicate words with regards of upper and lower case
     * @param inputValue Input String
     * @return duplicateWords List of the words which are duplicated in the string.
     */
    private static List<String> DuplicateWords(String inputValue) {
        String[] breakWords = inputValue.split("\\s+");
        List<String> duplicateWords = new ArrayList<>();
        for (String word : breakWords) {
            if (!duplicateWords.contains(word)) {
                duplicateWords.add(word);
            }
        }
        return duplicateWords;
    }

    /**
     * Find the duplicate words despite of upper and lower case
     * @param inputValue Input String
     * @return duplicateWords List of the words which are duplicated in the string.
     */
    private static List<String> DuplicateWordsDespiteOfCase(String inputValue) {
        inputValue = inputValue.toLowerCase();
        String[] breakWords = inputValue.split("\\s+");
        List<String> duplicateWords = new ArrayList<>();
        for (String word : breakWords) {
            if (!duplicateWords.contains(word)) {
                duplicateWords.add(word);
            }
        }
        return duplicateWords;
    }

	/**
     * Found the Iteration of the the duplicated words in the string
     * @param inputValue Input String
     * @param duplicatedWords List of the duplicated words
     */
    private static void CountDuplicateWords(String inputValue, List<String> duplicatedWords) {
        int i;
        Pattern pattern;
        Matcher matcher;
        System.out.println("Duplicate Words With respect of Upper and Lower Case: " + duplicatedWords);
        for (String value : duplicatedWords) {
            i = 0;
            pattern = Pattern.compile(value);
            matcher = pattern.matcher(inputValue);
            while (matcher.find()) {
                i++;
            }
            System.out.println(i);
        }
    }
}
