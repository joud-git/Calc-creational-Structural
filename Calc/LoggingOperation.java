package Calc;

public final class LoggingOperation extends OperationDecorator {
    public LoggingOperation(Operation delegate) {
        super(delegate);
    }

    @Override
    public double apply(double a, double b) {
        System.out.println("[LOG] Executing operation: " + delegate.getClass().getSimpleName());
        System.out.println("[LOG] Operands: a=" + a + ", b=" + b);
        double result = super.apply(a, b);
        System.out.println("[LOG] Result: " + result);
        return result;
    }
}