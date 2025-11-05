package Calc;

public abstract class OperationDecorator implements Operation {
    protected final Operation delegate;

    protected OperationDecorator(Operation delegate) {
        this.delegate = delegate;
    }

    @Override
    public double apply(double a, double b) {
        return delegate.apply(a, b);
    }
}