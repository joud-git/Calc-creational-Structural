package Calc;

public class CalculatorEngineer {

    private final CalculatorBuilder builder;

    public CalculatorEngineer(CalculatorBuilder builder) {
        this.builder = builder;
    }

    public void makeCalculator() {
        builder.buildComponents();
        builder.buildContentSize();
        builder.buildDisplay();
        builder.buildEventHandlers();
    }

    public Calculator getCalculator() {
        return builder.getCalculator();
    }
}
