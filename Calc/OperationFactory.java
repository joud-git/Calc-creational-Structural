package Calc;

public final class OperationFactory {

    private OperationFactory() {}

    public static Operation of(String symbol) {
        if (symbol == null) return null;
        switch (symbol) {
            case "+": return new AddOperation();
            case "-": return new SubOperation();
            case "*":
            case "×": return new MulOperation();
            case "/":
            case "÷": return new DivOperation();
            default:  return null;
        }
    }
}
