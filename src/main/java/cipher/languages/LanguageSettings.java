package cipher.languages;

import java.util.Map;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 * Interface of class with settings for particular language
 */

public interface LanguageSettings {
    Map<Character, Double> getLetterFrequencies();

    int getAlphabetLettersCount();

    int getLastUppercaseLetterCodepoint();

    int getFirstUppercaseLetterCodepoint();

    int getFirstLowercaseLetterCodepoint();

    int getLastLowercaseLetterCodepoint();
}
