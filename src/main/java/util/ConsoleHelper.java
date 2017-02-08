package util;

import java.util.*;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Utility class with methods for getting values from console
 */
public class ConsoleHelper {
    public static final String INCORRECT_INTEGER_VALUE_MSG = "Incorrect value, please enter integer value.";

    /**
     * @param messagesBefore messages that will be showed before value input
     * @return integer value entered from keyboard by user
     */
    public static int getIntValueFromKeyboard(String... messagesBefore) {
        while (true) {
            try {
                Arrays.asList(messagesBefore).forEach(System.out::println);
                return new Scanner(System.in).nextInt();
            } catch (NoSuchElementException e) {
                System.out.println(INCORRECT_INTEGER_VALUE_MSG);
            }
        }
    }

    /**
     * @param messagesBefore messages that will be showed before value input
     * @return string value entered from keyboard by user
     */
    public static String getStrValueFromKeyboard(String... messagesBefore) {
        Arrays.asList(messagesBefore).forEach(System.out::println);
        return new Scanner(System.in).nextLine();
    }

    /**
     * @param lines to be printed
     */
    public static void printLines(List<String> lines) {
        lines.forEach(System.out::println);
    }

    /**
     * @param lines to be printed
     */
    public static void printLines(String... lines) {
        printLines(Arrays.asList(lines));
    }
}
