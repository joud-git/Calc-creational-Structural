package Calc;

public class StandardCalculatorBuilder implements CalculatorBuilder {

    private Calculator calculator;

    public StandardCalculatorBuilder() {
        this.calculator = CalculatorFactory.create();
    }

    @Override
    public void buildComponents() { }

    @Override
    public void buildContentSize() {
        calculator.setLocationRelativeTo(null);
    }

    @Override
    public void buildDisplay() {
        calculator.clear();
    }

    @Override
    public void buildEventHandlers() { }

    @Override
    public Calculator getCalculator() {
        return this.calculator;
    }
}
