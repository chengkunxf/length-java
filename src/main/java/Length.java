public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final String unit;
    private Unit temp_unit;

    public Length(double value, String unit) {
        this(value, unit, convetStringToEnum(unit));
    }

    public Length(double value, String unit, Unit temp_unit) {
        this.value = value;
        this.unit = unit;
        this.temp_unit = temp_unit;
    }

    public Length as(String targetUnit) {
        Unit temp_unit = convetStringToEnum(targetUnit);
        return temp_as(targetUnit, temp_unit);
    }

    private static Unit convetStringToEnum(String targetUnit) {
        Unit temp_unit = null;
        if (targetUnit.equals(Length.FOOT)) {
            temp_unit = Unit.FOOT;
        }
        if (targetUnit.equals(Length.YARD)) {
            temp_unit = Unit.YARD;
        }
        if (targetUnit.equals(Length.INCH)) {
            temp_unit = Unit.INCH;
        }
        return temp_unit;
    }

    public Length temp_as(String targetUnit, Unit temp_unit) {
        Length result = this;
        if (this.unit.equals(FOOT)) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, targetUnit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, targetUnit);
            } else if (temp_unit == Unit.FOOT) {
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (temp_unit == Unit.FOOT) {
                result = new Length(this.value / 12, targetUnit);
            } else if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 36, targetUnit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
