package cipher.encoder;

import cipher.languages.impls.EnglishSettings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 */
public class CharsEncodingHelperTest {

    private static final char ENCODED_CHAR_EXPECTED = 'c';
    private static final char INITIAL_CHAR = 'a';
    private static final int SHIFT_VALUE = 2;

    @Test
    public void substitutionDecodingTest() {
        char encodedChar = CharsEncodingHelper.shiftLetter(INITIAL_CHAR, SHIFT_VALUE, EnglishSettings.getInstance());
        assertEquals(ENCODED_CHAR_EXPECTED, encodedChar);
    }
}
