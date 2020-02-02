public class Length {
    private final double value;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private Unit temp_unit;

    public Length(double value, String unit) {
        this(value, unit, determineUnit(unit));
    }

    public Length(double value, String unit, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
    }

    public Length as(String targetUnit) {
        Unit temp_unit = determineUnit(targetUnit);
        return temp_as(targetUnit, temp_unit);
    }

    private static Unit determineUnit(String targetUnit) {
        Unit temp_unit = null;
        if (targetUnit.equals(Length.FOOT)) {
            temp_unit = Unit.FOOT;
        }
        if (targetUnit.equals(Length.INCH)) {
            temp_unit = Unit.INCH;
        }
        if (targetUnit.equals(Length.YARD)) {
            temp_unit = Unit.YARD;
        }
        return temp_unit;
    }

    private Length temp_as(String targetUnit, Unit temp_unit) {
        Length result = this;

        if (this.temp_unit == Unit.FOOT) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, targetUnit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.temp_unit == Unit.YARD) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, targetUnit);
            } else if (temp_unit == Unit.FOOT){
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.temp_unit == Unit.INCH) {
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

    public Unit temp_getUnit() {
        return this.temp_unit;
    }
}
