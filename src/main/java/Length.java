public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        Length result = this;
        if (this.unit == Unit.FOOT) {
            if (targetUnit == Unit.YARD) {
                result = new Length(this.value / 3, targetUnit);
            } else if (targetUnit == Unit.INCH) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (targetUnit == Unit.INCH) {
                result = new Length(this.value * 36, targetUnit);
            } else if (targetUnit == Unit.FOOT) {
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit == Unit.INCH) {
            if (targetUnit == Unit.FOOT) {
                result = new Length(this.value / 12, targetUnit);
            } else if (targetUnit == Unit.YARD) {
                result = new Length(this.value / 36, targetUnit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return unit;
    }
}
