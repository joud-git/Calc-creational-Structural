package Calc;

public class DotCommand implements Command {

    private final Calculator receiver;

    public DotCommand(Calculator receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.handleDot();
    }
}
