package menu.command;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 * Concrete menu command.
 * This command handles user input and applies substitution cipher for message entered in console by user
 */
public class DecodeStringFromFileCommand implements Command {
    private OptionsReceiver receiver;

    public DecodeStringFromFileCommand(OptionsReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.decodeStringFromFile();
    }
}
