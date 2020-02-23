public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private Unit tempUnit;

    public Length(double value, Unit tempUnit) {
        this.value = value;
        this.tempUnit = tempUnit;
    }

    public Length temp_as(Unit tempUnit) {
        double value = calculateValue(tempUnit);

        return new Length(value, tempUnit);
    }

    private double calculateValue(Unit tempUnit) {
        double value = this.value;
        if (this.tempUnit == Unit.FOOT) {
            if (tempUnit == Unit.YARD) {
                return this.value / 3;
            }
            if (tempUnit == Unit.INCH) {
                return this.value * 12;
            }
        }

        if (this.tempUnit == Unit.YARD) {
            if (tempUnit == Unit.INCH) {
                value = this.value * 36;
                return value;
            }
            if (tempUnit == Unit.FOOT) {
                value = this.value * 3;
            }
        }

        if (this.tempUnit == Unit.INCH) {
            if (tempUnit == Unit.FOOT) {
                value = this.value / 12;
            }
            if (tempUnit == Unit.YARD) {
                value = this.value / 36;
            }
        }
        return value;
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
