package Calc;

public class App {
    public static void main(String[] args) {
        CalculatorBuilder builder = new StandardCalculatorBuilder();
        CalculatorEngineer engineer = new CalculatorEngineer(builder);
        engineer.makeCalculator();
        Calculator calculator = engineer.getCalculator();
        calculator.setVisible(true);
    }
}
