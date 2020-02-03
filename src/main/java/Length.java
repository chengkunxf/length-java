public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit temp_unit;

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
    }

    public Length as(Unit unit) {
        Length result = this;
        if (this.temp_unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                result = new Length(this.value / 3, unit);
            } else if (unit == Unit.INCH) {
                result = new Length(this.value * 12, unit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                result = new Length(this.value * 36, unit);
            } else if (unit == Unit.FOOT) {
                result = new Length(this.value * 3, unit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
            if (unit == Unit.FOOT) {
                result = new Length(this.value / 12, unit);
            } else if (unit == Unit.YARD) {
                result = new Length(this.value / 36, unit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getTemp_unit() {
        return temp_unit;
    }
}
