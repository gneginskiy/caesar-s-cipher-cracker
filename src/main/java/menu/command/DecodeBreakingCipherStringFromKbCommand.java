package menu.command;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 * Concrete menu command.
 * This command handles user input and breaks substitution cipher for message entered in console by user
 */
public class DecodeBreakingCipherStringFromKbCommand implements Command {
    private OptionsReceiver receiver;

    public DecodeBreakingCipherStringFromKbCommand(OptionsReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.decodeBreakingCipherStringFromKb();
    }
}
