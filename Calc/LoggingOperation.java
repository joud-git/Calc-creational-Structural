package Calc;

public final class LoggingOperation extends OperationDecorator {
    public LoggingOperation(Operation delegate) {
        super(delegate);
    }

    @Override
    public double apply(double a, double b) {
        // Use metadata methods instead of getClass().getSimpleName()
        System.out.println("[LOG] Executing operation: " + getName() + " (" + getSymbol() + ")");
        System.out.println("[LOG] Operands: a=" + a + ", b=" + b);
        double result = super.apply(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }
}