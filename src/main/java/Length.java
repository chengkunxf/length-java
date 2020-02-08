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
        Length result = this;
        double value = this.value;
        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                value = value / 3;
                result = new Length(value, unit);
            } else if (unit == Unit.INCH) {
                value = value * 12;
                result = new Length(value, unit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                value = value * 36;
                result = new Length(value, unit);
            } else if (unit == Unit.FOOT) {
                value = value * 3;
                result = new Length(value, unit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                value = value / 12;
                result = new Length(value, unit);
            } else if (unit == Unit.YARD) {
                value = value / 36;
                result = new Length(value, unit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}