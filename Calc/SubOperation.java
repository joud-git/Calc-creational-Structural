package Calc;

final class SubOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
