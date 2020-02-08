public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        return new Length(calculateValue(unit), unit);
    }

    private double calculateValue(Unit unit) {
        double value = this.value;
        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                value = value / 3;
            }
            if (unit == Unit.INCH) {
                value = value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                value = value * 36;
            } else if (unit == Unit.FOOT) {
                value = value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                value = value / 12;
            } else if (unit == Unit.YARD) {
                value = value / 36;
            }
        }
        return value;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}