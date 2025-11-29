package Calc;

public class NumberCommand implements Command {

    private final Calculator receiver;
    private final String digit;

    public NumberCommand(Calculator receiver, String digit) {
        this.receiver = receiver;
        this.digit = digit;
    }

    @Override
    public void execute() {
        receiver.appendNumber(digit);
    }
}
