package Calc;

public final class OperationFactory {

    private static boolean enableLogging = false;
    private static boolean enableRounding = false;
    private static int roundingScale = 2;
    private static boolean enableValidation = false;

    private OperationFactory() {}

    public static Operation of(String symbol) {
        if (symbol == null) return null;
        
        Operation operation = createBaseOperation(symbol);
        if (operation == null) return null;
        
        operation = applyDecorators(operation, symbol);
        
        return operation;
    }
    
    private static Operation createBaseOperation(String symbol) {
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
    
    private static Operation applyDecorators(Operation operation, String symbol) {
        if (enableValidation && (symbol.equals("/") || symbol.equals("÷"))) {
            operation = new ValidatedDivideOperation(operation);
        }
        
        if (enableRounding) {
            operation = new RoundingOperation(operation, roundingScale);
        }
        
        if (enableLogging) {
            operation = new LoggingOperation(operation);
        }
        
        return operation;
    }
    
    public static void setLoggingEnabled(boolean enabled) {
        enableLogging = enabled;
    }
    
    public static void setRoundingEnabled(boolean enabled) {
        enableRounding = enabled;
    }
    
    public static void setRoundingScale(int scale) {
        roundingScale = scale;
    }
    
    public static void setValidationEnabled(boolean enabled) {
        enableValidation = enabled;
    }
}