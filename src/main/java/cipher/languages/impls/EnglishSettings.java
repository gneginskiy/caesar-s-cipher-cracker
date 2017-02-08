package cipher.languages.impls;

import cipher.languages.LanguageSettings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * This class provides known letter frequencies, first/last letters codepoints
 * and alphabet size for English language
 */
public final class EnglishSettings implements LanguageSettings {

    private static final int ALPHABET_LETTERS_COUNT = 26;
    private static final int LAST_UPPERCASE_LETTER_CODEPOINT  = 90; //A
    private static final int FIRST_UPPERCASE_LETTER_CODEPOINT = 65; //Z
    private static final int FIRST_LOWERCASE_LETTER_CODEPOINT = 97; //a
    private static final int LAST_LOWERCASE_LETTER_CODEPOINT = 122; //z

    private static LanguageSettings instance = new EnglishSettings();

    private EnglishSettings() {;}

    public static LanguageSettings getInstance() {
        return instance;
    }

    //English letters average occurrence frequencies
    private static final Map<Character, Double> LETTERS_PERCENTAGE = Collections.unmodifiableMap(
            new HashMap<Character, Double>() {{
                put('a', 8.167);
                put('b', 1.492);
                put('c', 2.782);
                put('d', 4.253);
                put('e', 12.702);
                put('f', 2.228);
                put('g', 2.015);
                put('h', 6.094);
                put('i', 6.966);
                put('j', 0.153);
                put('k', 0.772);
                put('l', 4.025);
                put('m', 2.406);
                put('n', 6.749);
                put('o', 7.507);
                put('p', 1.929);
                put('q', 0.095);
                put('r', 5.987);
                put('s', 6.327);
                put('t', 9.056);
                put('u', 2.758);
                put('v', 0.978);
                put('w', 2.360);
                put('x', 0.150);
                put('y', 1.974);
                put('z', 0.074);
            }}
    );

    @Override
    public Map<Character, Double> getLetterFrequencies() {
        return LETTERS_PERCENTAGE;
    }

    @Override
    public int getAlphabetLettersCount() {
        return ALPHABET_LETTERS_COUNT;
    }

    @Override
    public int getLastUppercaseLetterCodepoint() {
        return LAST_UPPERCASE_LETTER_CODEPOINT;
    }

    @Override
    public int getFirstUppercaseLetterCodepoint() {
        return FIRST_UPPERCASE_LETTER_CODEPOINT;
    }

    @Override
    public int getFirstLowercaseLetterCodepoint() {
        return FIRST_LOWERCASE_LETTER_CODEPOINT;
    }

    @Override
    public int getLastLowercaseLetterCodepoint() {
        return LAST_LOWERCASE_LETTER_CODEPOINT;
    }


}
