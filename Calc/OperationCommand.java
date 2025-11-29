package Calc;

public class OperationCommand implements Command {

    private final Calculator receiver;
    private final String opSymbol;

    public OperationCommand(Calculator receiver, String opSymbol) {
        this.receiver = receiver;
        this.opSymbol = opSymbol;
    }

    @Override
    public void execute() {
        receiver.chooseOperation(opSymbol);
    }
}
