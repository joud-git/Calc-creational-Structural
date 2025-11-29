package Calc;

public class ToggleSignCommand implements Command {

    private final Calculator receiver;

    public ToggleSignCommand(Calculator receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.toggleSign();
    }
}
