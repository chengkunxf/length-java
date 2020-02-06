public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit temp_unit;

    public Length(double value, String unit) {
        this(value, convertStringToEnum(unit));
    }

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
    }

    public Length as(String targetUnit) {
        return temp_as(convertStringToEnum(targetUnit));
    }

    public Length temp_as( Unit temp_unit) {
        Length result = this;
        if (this.temp_unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, temp_unit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, temp_unit);
            } else if (temp_unit == Unit.FOOT) {
                result = new Length(this.value * 3, temp_unit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
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

    public Unit getTemp_unit() {
        return temp_unit;
    }
}
