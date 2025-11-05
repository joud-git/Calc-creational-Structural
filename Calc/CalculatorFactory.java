package Calc;

public final class CalculatorFactory {

    private CalculatorFactory() {}

    public static Calculator create() {
        return new Calculator();
    }
}