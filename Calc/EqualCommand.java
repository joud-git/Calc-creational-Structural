package Calc;

public class EqualCommand implements Command {

    private final Calculator receiver;

    public EqualCommand(Calculator receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.compute();
    }
}
