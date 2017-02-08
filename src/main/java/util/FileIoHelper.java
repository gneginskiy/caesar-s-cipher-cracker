package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Utility class which includes methods for FILE I/O
 */
public class FileIoHelper {

    private static final String CANT_LOAD_FILE_MSG = "Something went wrong. Can't load file content. Please try again";
    private static final String FILE_WONT_BE_SAVED_MSG = "Something went wrong. File will not be saved.";
    private static final String DECODED_STRING_HAS_BEEN_SAVED_MSG = "Decoded string has been saved to ";

    public static void saveStrToFile(String strToSave, String outputFileName) {
        saveStrToFile(Collections.singletonList(strToSave), outputFileName);
    }

    public static String getStringFromFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println(CANT_LOAD_FILE_MSG);
            return "";
        }
    }

    public static void saveStrToFile(List<String> stringsToSave, String outputFileName) {
        System.out.println(DECODED_STRING_HAS_BEEN_SAVED_MSG + outputFileName);
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            stringsToSave.forEach(writer::print);
        } catch (FileNotFoundException e) {
            System.out.println(FILE_WONT_BE_SAVED_MSG);
        }
    }
}
