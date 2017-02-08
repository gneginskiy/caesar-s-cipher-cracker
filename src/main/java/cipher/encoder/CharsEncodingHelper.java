package cipher.encoder;

import cipher.languages.LanguageSettings;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Class allows to encode english letters with substitution cipher
 * making alphabetic circular shift
 */
public class CharsEncodingHelper {

    /***
     * @param initialChar char value to encode
     * @param shift for substitution cipher
     * @param languageSettings settings for particular language
     * @return encoded letter, or the same value, if initialChar not a letter
     */
    public static char shiftLetter(char initialChar, int shift, LanguageSettings languageSettings) {
        boolean isNotAletter = !Character.isLetter(initialChar);
        if (isNotAletter) {
            return initialChar;
        }
        int reducedShift = shift % (languageSettings.getAlphabetLettersCount()- 1);
        int encodedCharCodePoint = initialChar + reducedShift;
        boolean isUpperCase = Character.isUpperCase(initialChar);
        return getCharWithCircularShift(encodedCharCodePoint, isUpperCase,languageSettings);
    }

    /***
     * @param encodedCharCodePoint code point of char after the shift
     * @param isUpperCase is letter uppercase
     * @param languageSettings  settings for particular language
     * @return char value with circular shift applied
     */
    private static char getCharWithCircularShift(int encodedCharCodePoint, boolean isUpperCase, LanguageSettings languageSettings) {
        int lastLetterCodePoint  = isUpperCase ? languageSettings.getLastUppercaseLetterCodepoint(): languageSettings.getLastLowercaseLetterCodepoint();
        int firstLetterCodePoint = isUpperCase ? languageSettings.getFirstUppercaseLetterCodepoint(): languageSettings.getFirstLowercaseLetterCodepoint();
        if (encodedCharCodePoint > lastLetterCodePoint) {
            encodedCharCodePoint = encodedCharCodePoint - lastLetterCodePoint + firstLetterCodePoint - 1;
        } else if (encodedCharCodePoint < firstLetterCodePoint) {
            encodedCharCodePoint = lastLetterCodePoint - firstLetterCodePoint + encodedCharCodePoint + 1;
        }
        return (char) encodedCharCodePoint;
    }
}
