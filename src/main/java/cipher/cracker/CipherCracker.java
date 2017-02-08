package cipher.cracker;

import cipher.encoder.CharsEncodingHelper;
import cipher.decoder.SubstitutionDecoder;
import cipher.languages.LanguageSettings;

import java.util.*;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Provides functionality to break Caesar's substitution cipher
 * using letter frequency analysis and the method of least squares
 */
public class CipherCracker {
    private final LanguageSettings languageSettings;

    //amount of possibly decoded strings (in very rare cases algorithm can do wrong, so we have number of retries here)
    private static final int DECODED_STRINGS_AMOUNT = 3;
    //message encrypted with the substitution cipher
    private final String msgToDecode;

    /**
     * @param msgToDecode - message encrypted with substitution cipher for decoding
     * @param languageSettings - settings for particular language
     */
    public CipherCracker(String msgToDecode, LanguageSettings languageSettings) {
        this.msgToDecode = msgToDecode;
        this.languageSettings = languageSettings;
    }

    /***
     * @return list of possibly decrypted messages (descending order of probability of correct result)
     */
    public List<String> getDecodedStrings() {
        Map<Character, Integer> lettersOccurrences = getLettersOccurrences(msgToDecode);
        Map<Character, Double> lettersFrequencyPercentage = getFrequencyPercentage(lettersOccurrences);
        List<Integer> possibleShiftValues = getPossibleShiftValues(lettersFrequencyPercentage, DECODED_STRINGS_AMOUNT);
        return decodeStringsUsingShift(possibleShiftValues);
    }

    /***
     * @param lettersOccurrences - map which contains the number of occurrences for every letter
     *                             in the encrypted message. Every letter in the map is casted to lowercase.
     * @return map with frequency of occurrence (percentage) of every letter in the encrypted message.
     */
    private Map<Character, Double> getFrequencyPercentage(Map<Character, Integer> lettersOccurrences) {
        Map<Character, Double> lettersFrequencyPercentage = new HashMap<>();
        Integer lettersOccurrencesSum = lettersOccurrences.values().stream().reduce(0, Integer::sum);
        lettersOccurrences.keySet().forEach(
                letter -> {
                    double percentage = lettersOccurrences.get(letter) * 100. / lettersOccurrencesSum;
                    lettersFrequencyPercentage.put(letter, percentage);
                });
        return lettersFrequencyPercentage;
    }

    /***
     * @param msgToDecode message encrypted with substitution cipher for decoding
     * @return map which contains the number of occurrences for every letter in the encrypted message.
     *         Every letter in the map is casted to lowercase
     */
    private Map<Character, Integer> getLettersOccurrences(String msgToDecode) {
        Map<Character, Integer> result = new HashMap<>();
        for (int pos = 0; pos < msgToDecode.length(); pos++) {
            Character character = msgToDecode.charAt(pos);
            if (Character.isLetter(character)) {
                char lowerCaseLetter = Character.toLowerCase(character);
                Integer occurrences = result.getOrDefault(lowerCaseLetter, 0);
                result.put(lowerCaseLetter, occurrences + 1);
            }
        }
        return result;
    }

    /***
     * @param lettersFrequencyPercentage map with frequency of occurrence (percentage) of every letter in the encrypted message
     * @param shiftValuesAmount amount of possibly decoded strings
     *                                    (in very rare cases algorithm can do wrong, so we have number of retries here)
     * @return possible shift values for substitution cipher of this text (in descending order of correctness probability)
     */
    private List<Integer> getPossibleShiftValues(Map<Character, Double> lettersFrequencyPercentage, int shiftValuesAmount) {
        Map<Double, Integer> squareSumsToShiftPairs = new TreeMap<>();
        Map<Character, Double> lettersPercentagesEnglish = languageSettings.getLetterFrequencies();
        for (int shiftValue = 0; shiftValue < 25; shiftValue++) {
            double squareSum = 0;
            for (Character letter : lettersPercentagesEnglish.keySet()) {
                Double letterFrequencyPredefined = lettersPercentagesEnglish.get(letter);
                Character shiftedLetter = CharsEncodingHelper.shiftLetter(letter, shiftValue, languageSettings);
                Double letterFrequencyActual = lettersFrequencyPercentage.get(shiftedLetter);
                if (letterFrequencyActual == null) {
                    continue;
                }
                double square = Math.pow(letterFrequencyPredefined - letterFrequencyActual, 2);
                squareSum += square;
            }
            squareSumsToShiftPairs.put(squareSum, shiftValue);
        }
        ArrayList<Integer> shiftValues = new ArrayList<>();
        Iterator<Integer> sumsToShiftIterator = squareSumsToShiftPairs.values().iterator();
        for (int i = 0; i < shiftValuesAmount && sumsToShiftIterator.hasNext(); i++) {
            shiftValues.add(sumsToShiftIterator.next());
        }
        return shiftValues;
    }

    /***
     * @param possibleShiftValues several shift values for substitution cipher of this text (in descending order of correctness probability)
     * @return possibly decoded strings (uses provided shift values from parameter)
     */
    private List<String> decodeStringsUsingShift(List<Integer> possibleShiftValues) {
        ArrayList<String> result = new ArrayList<>();
        for (Integer shiftValue : possibleShiftValues) {
            result.add(new SubstitutionDecoder(msgToDecode, shiftValue, languageSettings).getDecodedString());
        }
        return result;
    }
}
