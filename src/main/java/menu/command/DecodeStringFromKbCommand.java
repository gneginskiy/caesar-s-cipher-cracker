package menu.command;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 * Concrete menu command.
 */
//Concrete menu.command
public class DecodeStringFromKbCommand implements Command {
    private OptionsReceiver receiver;

    public DecodeStringFromKbCommand(OptionsReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.decodeStringFromKb();
    }
}
