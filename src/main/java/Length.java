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

    public Length as(Unit temp_unit) {
        Length result = this;
        if (this.unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, temp_unit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, temp_unit);
            } else if (temp_unit == Unit.FOOT) {
                result = new Length(this.value * 3, temp_unit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (temp_unit == Unit.FOOT) {
                result = new Length(this.value / 12, temp_unit);
            } else if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 36, temp_unit);
            }
        }

        return result;
    }

    private static Unit convertStringToEnum(String unit) {
        Unit temp_unit = null;
        if (unit.equals(YARD)) {
            temp_unit = Unit.YARD;
        }
        if (unit.equals(INCH)) {
            temp_unit = Unit.INCH;
        }
        if (unit.equals(FOOT)) {
            temp_unit = Unit.FOOT;
        }
        return temp_unit;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
