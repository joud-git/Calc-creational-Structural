package Calc;

public interface Operation {
    double apply(double a, double b);

    default String getSymbol() {
        return "?";
    }
   
    default String getName() {
        return "Unknown Operation";
    }
}
