public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final String unit;
    private Unit tempUnit;

    public Length(double value, String unit) {
        this(value, unit, convertStringToUnit(unit));
    }

    public Length(double value, String unit, Unit tempUnit) {
        this.value = value;
        this.unit = unit;
        this.tempUnit = tempUnit;
    }

    public Length as(String targetUnit) {
        return temp_as(targetUnit, convertStringToUnit(targetUnit));
    }

    public Length temp_as(String targetUnit, Unit tempUnit) {
        Length len = this;
        if (this.tempUnit == Unit.FOOT) {
            if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 3, targetUnit);
            } else if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.tempUnit == Unit.YARD) {
            if (tempUnit == Unit.INCH) {
                len = new Length(this.value * 36, targetUnit);
            } else if (tempUnit == Unit.FOOT) {
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.tempUnit == Unit.INCH) {
            if (tempUnit == Unit.FOOT) {
                len = new Length(this.value / 12, targetUnit);
            } else if (tempUnit == Unit.YARD) {
                len = new Length(this.value / 36, targetUnit);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public String getUinnt() {
        return this.unit;
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
