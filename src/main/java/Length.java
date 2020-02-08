public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit unit;

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.unit = temp_unit;
    }

    public Length as(Unit temp_unit) {
        return new Length(calculateValue(temp_unit), temp_unit);
    }

    private double calculateValue(Unit temp_unit) {
        double value = this.value;
        if (this.unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                return value / 3;
            }
            if (temp_unit == Unit.INCH) {
                return value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                return value * 36;
            }
            if (temp_unit == Unit.FOOT) {
                return value * 3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (temp_unit == Unit.FOOT) {
                return value / 12;
            }
            if (temp_unit == Unit.YARD) {
                return value / 36;
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
