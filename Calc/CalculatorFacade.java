package Calc;

import javax.swing.SwingUtilities;

public class CalculatorFacade {
    
    public static void createAndShowCalculator() {
        SwingUtilities.invokeLater(() -> {
            CalculatorBuilder builder = new StandardCalculatorBuilder();
            CalculatorEngineer engineer = new CalculatorEngineer(builder);
            engineer.makeCalculator();
            Calculator calculator = engineer.getCalculator();
            calculator.setVisible(true);
        });
    }
    
    public static void createAndShowCalculator(CalculatorBuilder builder) {
        SwingUtilities.invokeLater(() -> {
            CalculatorEngineer engineer = new CalculatorEngineer(builder);
            engineer.makeCalculator();
            Calculator calculator = engineer.getCalculator();
            calculator.setVisible(true);
        });
    }
    
    public static Calculator createCalculator() {
        CalculatorBuilder builder = new StandardCalculatorBuilder();
        CalculatorEngineer engineer = new CalculatorEngineer(builder);
        engineer.makeCalculator();
        return engineer.getCalculator();
    }
    
    public static Calculator createCalculator(CalculatorBuilder builder) {
        CalculatorEngineer engineer = new CalculatorEngineer(builder);
        engineer.makeCalculator();
        return engineer.getCalculator();
    }
}