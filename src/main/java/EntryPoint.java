import menu.command.*;
import menu.ConsoleMenuOptionsInvoker;
import util.ConsoleHelper;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * Entry-point of application. Launches main menu
 */
public class EntryPoint {
    public static void main(String[] args) {
        ConsoleHelper.printLines(
                "=====================================================================",
                "|      Welcome to Caesar's Substitution Cipher Encoder              |",
                "====================================================================="
        );

        ConsoleMenuOptionsInvoker mainMenu = new ConsoleMenuOptionsInvoker().addMenuLines(
                "=====================================================================",
                "| Please, choose an option:                                         |",
                "|        1. Encode message from keyboard                            |",
                "|        2. Encode message from file                                |",
                "|        3. Decode message from keyboard with known shift           |",
                "|        4. Decode message from file with known shift               |",
                "|        5. Crack encoded message cipher (input from keyboard)      |",
                "|        6. Crack encoded message cipher (input from file)          |",
                "|        0. Exit                                                    |",
                "====================================================================="
        );

        OptionsReceiver receiver = new OptionsReceiver();
        mainMenu.assignOptionCommand(1, new EncodeStringFromKbCommand(receiver))
                .assignOptionCommand(2, new EncodeStringFromFileCommand(receiver))
                .assignOptionCommand(3, new DecodeStringFromKbCommand(receiver))
                .assignOptionCommand(4, new DecodeStringFromFileCommand(receiver))
                .assignOptionCommand(5, new DecodeBreakingCipherStringFromKbCommand(receiver))
                .assignOptionCommand(6, new DecodeBreakingCipherStringFromFileCommand(receiver))
                .assignOptionCommand(0, new ExitCommand(receiver))
                .show();
    }
}
