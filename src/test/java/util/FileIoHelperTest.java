package util;

import cipher.encoder.SubstitutionEncoder;
import cipher.languages.LanguageSettings;
import cipher.languages.impls.EnglishSettings;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 */
public class FileIoHelperTest {

    private static final String STRING_SAVED_TO_FILE = "It's just string for the test";
    private static final String OUTPUT_FILE_NAME = "output.extension_here";

    @Test
    public void fileIoTest() {
        FileIoHelper.saveStrToFile(STRING_SAVED_TO_FILE, OUTPUT_FILE_NAME);
        String stringFromFile = FileIoHelper.getStringFromFile(OUTPUT_FILE_NAME);
        assertEquals(STRING_SAVED_TO_FILE,stringFromFile);
    }
}
