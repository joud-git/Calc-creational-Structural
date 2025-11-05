package Calc;

public final class ValidatedDivideOperation extends OperationDecorator {
    public ValidatedDivideOperation(Operation delegate) {
        super(delegate);
    }

    @Override
    public double apply(double a, double b) {
        if (delegate instanceof DivOperation && b == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return super.apply(a, b);
    }
}