package menu.command;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 * Concrete menu command.
 * This command handles user input and breaks substitution cipher for message loaded from file
 */
public class DecodeBreakingCipherStringFromFileCommand implements Command {
    private OptionsReceiver receiver;

    public DecodeBreakingCipherStringFromFileCommand(OptionsReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.decodeBreakingCipherStringFromFile();
    }
}
