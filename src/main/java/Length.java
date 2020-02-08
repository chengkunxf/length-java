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
        Length result = this;
        double value = this.value;
        if (this.unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                value = value / 3;
                result = new Length(value, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                value = value * 12;
                result = new Length(value, temp_unit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                value = value * 36;
                result = new Length(value, temp_unit);
            } else if (temp_unit == Unit.FOOT) {
                value = value * 3;
                result = new Length(value, temp_unit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (temp_unit == Unit.FOOT) {
                value = value / 12;
                result = new Length(value, temp_unit);
            } else if (temp_unit == Unit.YARD) {
                value = value / 36;
            }
        }

        result = new Length(value, temp_unit);
        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
