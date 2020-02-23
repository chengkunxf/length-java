public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit tempUnit;

    public Length(double value, String unit) {
        this(value, convertStringToUnit(unit));
    }

    public Length(double value, Unit tempUnit) {
        this.value = value;
        this.tempUnit = tempUnit;
    }

    public Length as(String targetUnit) {
        return temp_as(convertStringToUnit(targetUnit));
    }

    public Length temp_as(Unit tempUnit) {
        Length len = this;
        if (this.tempUnit == Unit.FOOT) {
            if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 3, tempUnit);
            } else if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 12, tempUnit);
            }
        }

        if (this.tempUnit == Unit.YARD) {
            if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 36, tempUnit);
            } else if (tempUnit == Unit.FOOT) {
                len = new Length(this.value * 3, tempUnit);
            }
        }

        if (this.tempUnit == Unit.INCH) {
            if (tempUnit == Unit.FOOT) {
                len = new Length(this.value / 12, tempUnit);
            } else if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 36, tempUnit);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public Unit getTempUnit() {
        return tempUnit;
    }

    private static Unit convertStringToUnit(String unit) {
        Unit tempUnit = null;
        if (unit.equals(YARD)) {
            tempUnit = Unit.YARD;
        }
        if (unit.equals(FOOT)) {
            tempUnit = Unit.FOOT;
        }
        if (unit.equals(INCH)) {
            tempUnit = Unit.INCH;
        }
        return tempUnit;
    }
}
