package cipher.encoder;


import cipher.languages.LanguageSettings;
import cipher.languages.impls.EnglishSettings;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Class for encoding substitution cipher encrypted message
 * using known shift
 */
public class SubstitutionEncoder {
    private final LanguageSettings languageSettings;
    //known shift which used for substitution decoding
    private final int shift;
    //encrypted message for decoding
    private final String msgToEncode;

    /**
     * @param msgToEncode message message to encode
     * @param shift known shift value which used for substitution cipher encoded message decoding
     * @param languageSettings - settings for particular language
     */
    public SubstitutionEncoder(String msgToEncode, int shift, LanguageSettings languageSettings) {
        this.msgToEncode = msgToEncode;
        this.shift = shift;
        this.languageSettings = languageSettings;
    }

    /**
     * @return msgToEncode encrypted with substitution cipher using specified shift
     */
    public String getEncodedString() {
        StringBuilder result = new StringBuilder();
        for (int pos = 0; pos < msgToEncode.length(); pos++) {
            char initialChar = msgToEncode.charAt(pos);
            char decodedChar = CharsEncodingHelper.shiftLetter(initialChar, shift, languageSettings);
            result.append(decodedChar);
        }
        return result.toString();
    }
}
