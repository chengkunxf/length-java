public class Length {
    private final double value;
    private Unit tempUnit;

    public Length(double value, Unit tempUnit) {
        this.value = value;
        this.tempUnit = tempUnit;
    }

    public Length temp_as(Unit tempUnit) {
        return new Length(calculateValue(tempUnit), tempUnit);
    }

    private double calculateValue(Unit tempUnit) {
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
                return this.value * 36;
            }
            if (tempUnit == Unit.FOOT) {
                return this.value * 3;
            }
        }

        if (this.tempUnit == Unit.INCH) {
            if (tempUnit == Unit.FOOT) {
                return this.value / 12;
            }
            if (tempUnit == Unit.YARD) {
                return this.value / 36;
            }
        }
        return this.value;
    }

    public double getVal() {
        return this.value;
    }

    public Unit getTempUnit() {
        return tempUnit;
    }
}
