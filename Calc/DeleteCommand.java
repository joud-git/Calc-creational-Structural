package Calc;

public class DeleteCommand implements Command {

    private final Calculator receiver;

    public DeleteCommand(Calculator receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.deleteLastDigit();
    }
}
