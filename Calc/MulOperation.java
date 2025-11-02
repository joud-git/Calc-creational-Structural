package Calc;

final class MulOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
