package cipher.decoder;

import cipher.encoder.SubstitutionEncoder;
import cipher.languages.LanguageSettings;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Class constructed for decoding encrypted messages
 * using known shift
 */
public class SubstitutionDecoder {
    //known shift which used for substitution decoding
    private final int shift;
    //encrypted message for decoding
    private final String msgToDecode;
    private final LanguageSettings languageSettings;

    /***
     * @param msgToDecode encrypted message message to decode
     * @param shift known shift value which used for substitution cipher encoded message decoding
     * @param languageSettings
     */
    public SubstitutionDecoder(String msgToDecode, int shift, LanguageSettings languageSettings) {
        this.msgToDecode = msgToDecode;
        this.shift = shift;
        this.languageSettings = languageSettings;
    }

    /***
     * @return decoded message
     */
    public String getDecodedString() {
        return new SubstitutionEncoder(msgToDecode, -shift, languageSettings).getEncodedString();
    }
}
