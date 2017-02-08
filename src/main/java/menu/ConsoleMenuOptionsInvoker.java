package menu;

import menu.command.Command;
import util.ConsoleHelper;

import java.util.*;

/**
 * Created by Grigory_Neginsky on 07-Feb-17.
 * This class designed to encapsulate some console menu functionality
 */
public class ConsoleMenuOptionsInvoker {
    private static final String TRY_AGAIN_MSG = "Incorrect value, please try again";

    private final List<String> menuLines;
    private final Map<Integer, Command> valuesToCommand;

    public ConsoleMenuOptionsInvoker() {
        this.menuLines = new ArrayList<>();
        this.valuesToCommand = new HashMap<>();
    }

    public ConsoleMenuOptionsInvoker addMenuLines(String... lines) {
        Arrays.asList(lines).forEach(menuLines::add);
        return this;
    }

    public ConsoleMenuOptionsInvoker assignOptionCommand(int numFromKb, Command command) {
        valuesToCommand.put(numFromKb, command);
        return this;
    }

    private void getOptionAndAct() {
        while (true) {
            int chosenOption = ConsoleHelper.getIntValueFromKeyboard();
            Command chosenCommand = valuesToCommand.get(chosenOption);
            if (chosenCommand != null) {
                chosenCommand.execute();
                break;
            }
            System.out.println(TRY_AGAIN_MSG);
        }
    }

    public void show() {
        while (true) {
            menuLines.forEach(System.out::println);
            this.getOptionAndAct();
        }
    }
}
