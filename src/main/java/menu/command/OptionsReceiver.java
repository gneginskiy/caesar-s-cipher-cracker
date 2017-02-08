package menu.command;

import cipher.cracker.CipherCracker;
import cipher.decoder.SubstitutionDecoder;
import cipher.encoder.SubstitutionEncoder;
import cipher.languages.LanguageSettings;
import cipher.languages.impls.EnglishSettings;
import util.ConsoleHelper;
import util.FileIoHelper;

import java.util.List;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 */
public class OptionsReceiver {
    private static final String DEFAULT_OUTPUT_FILENAME = "output.txt";
    private static final String PLEASE_ENTER_STRING_TO_ENCODE = "Please, enter string to encode:";
    private static final String PLEASE_ENTER_ALPHABETICAL_SHIFT = "Please, enter alphabetical shift:";
    private static final String PLEASE_ENTER_STRING_TO_DECODE = "Please, enter string to decode:";
    private static final String DECODED_STRING_MSG = "Decoded string:";
    private static final String ENCODED_STRING_MSG = "Encoded string:";
    private static final LanguageSettings languageSettings = EnglishSettings.getInstance();


    void decodeBreakingCipherStringFromFile() {
        String fileName = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_ENCODE);
        String msgToDecode = FileIoHelper.getStringFromFile(fileName);
        List<String> possiblyDecodedStrings = new CipherCracker(msgToDecode, languageSettings).getDecodedStrings();
        System.out.println("Possibly decoded strings:");
        ConsoleHelper.printLines(possiblyDecodedStrings);
    }

    void decodeBreakingCipherStringFromKb() {
        String msgToDecode = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_DECODE);
        List<String> possiblyDecodedStrings = new CipherCracker(msgToDecode, languageSettings).getDecodedStrings();
        System.out.println("Possibly decoded strings:");
        ConsoleHelper.printLines(possiblyDecodedStrings);
        FileIoHelper.saveStrToFile(possiblyDecodedStrings, DEFAULT_OUTPUT_FILENAME);
    }

    void decodeStringFromFile() {
        String fileName = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_DECODE);
        String msgToDecode = FileIoHelper.getStringFromFile(fileName);
        int shift = ConsoleHelper.getIntValueFromKeyboard(PLEASE_ENTER_ALPHABETICAL_SHIFT);
        String decodedString = new SubstitutionDecoder(msgToDecode, shift, languageSettings).getDecodedString();
        ConsoleHelper.printLines(DECODED_STRING_MSG, decodedString);
        FileIoHelper.saveStrToFile(decodedString, DEFAULT_OUTPUT_FILENAME);
    }

    void decodeStringFromKb() {
        String msgToDecode = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_DECODE);
        int shift = ConsoleHelper.getIntValueFromKeyboard(PLEASE_ENTER_ALPHABETICAL_SHIFT);
        String decodedString = new SubstitutionDecoder(msgToDecode, shift,languageSettings).getDecodedString();
        ConsoleHelper.printLines(DECODED_STRING_MSG, decodedString);
        FileIoHelper.saveStrToFile(decodedString, DEFAULT_OUTPUT_FILENAME);
    }

    void encodeStringFromFile() {
        String fileName = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_ENCODE);
        String msgToEncode = FileIoHelper.getStringFromFile(fileName);
        int shift = ConsoleHelper.getIntValueFromKeyboard(PLEASE_ENTER_ALPHABETICAL_SHIFT);
        String encodedString = new SubstitutionEncoder(msgToEncode, shift, languageSettings).getEncodedString();
        ConsoleHelper.printLines(ENCODED_STRING_MSG, encodedString);
        FileIoHelper.saveStrToFile(encodedString, DEFAULT_OUTPUT_FILENAME);
    }

    void encodeStringFromKb() {
        String msgToEncode = ConsoleHelper.getStrValueFromKeyboard(PLEASE_ENTER_STRING_TO_ENCODE);
        int shift = ConsoleHelper.getIntValueFromKeyboard(PLEASE_ENTER_ALPHABETICAL_SHIFT);
        String encodedString = new SubstitutionEncoder(msgToEncode, shift, languageSettings).getEncodedString();
        ConsoleHelper.printLines(ENCODED_STRING_MSG, encodedString);
        FileIoHelper.saveStrToFile(encodedString, DEFAULT_OUTPUT_FILENAME);
    }

    void exit() {
        System.exit(1);
    }

}
