package Calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class RoundingOperation extends OperationDecorator {
    private final int scale;

    public RoundingOperation(Operation delegate, int scale) {
        super(delegate);
        this.scale = Math.max(0, scale);
    }

    @Override
    public double apply(double a, double b) {
        double rawResult = super.apply(a, b);
        BigDecimal bd = new BigDecimal(rawResult);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}