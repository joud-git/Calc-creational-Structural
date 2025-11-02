package Calc;

final class AddOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
