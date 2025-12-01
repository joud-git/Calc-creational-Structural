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
    
    @Override
    public String getSymbol() {
        return delegate.getSymbol();
    }
    
    @Override
    public String getName() {
        return delegate.getName();
    }
}
