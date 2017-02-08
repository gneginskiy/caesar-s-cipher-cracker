package cipher.encoder;

import cipher.decoder.SubstitutionDecoder;
import cipher.languages.LanguageSettings;
import cipher.languages.impls.EnglishSettings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 */
public class SubstitutionEncoderTest {
    private static final String MSG_TO_ENCODE = "Something went great!";
    private static final String ENCRYPTED_MSG_EXPECTED = "Bxvncqrwp fnwc panjc!";
    private static final int ENCRYPTION_KNOWN_SHIFT = 9;

    @Test
    public void substitutionEncodingTest1() {
        LanguageSettings langSettings = EnglishSettings.getInstance();
        SubstitutionEncoder decoder = new SubstitutionEncoder(MSG_TO_ENCODE, ENCRYPTION_KNOWN_SHIFT, langSettings);
        assertEquals(ENCRYPTED_MSG_EXPECTED, decoder.getEncodedString());
    }

    @Test //and vice versa
    public void substitutionEncodingTest2() {
        LanguageSettings langSettings = EnglishSettings.getInstance();
        String msgToEncode = ENCRYPTED_MSG_EXPECTED;
        String encodedMsg = MSG_TO_ENCODE;
        int shift = -ENCRYPTION_KNOWN_SHIFT;
        SubstitutionEncoder decoder = new SubstitutionEncoder(msgToEncode, shift, langSettings);
        assertEquals(encodedMsg, decoder.getEncodedString());
    }
}
