package Calc;

public class ClearCommand implements Command {

    private final Calculator receiver;

    public ClearCommand(Calculator receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.clear();
    }
}
