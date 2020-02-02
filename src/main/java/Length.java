public class Length {
    private final double value;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        Length result = this;

        if (this.unit == Unit.FOOT) {
            if (unit == Unit.YARD) {
                result = new Length(this.value / 3, unit);
            } else if (unit == Unit.INCH) {
                result = new Length(this.value * 12, unit);
            }
        }

        if (this.unit == Unit.YARD) {
            if (unit == Unit.INCH) {
                result = new Length(this.value * 36, unit);
            } else if (unit == Unit.FOOT){
                result = new Length(this.value * 3, unit);
            }
        }

        if (this.unit == Unit.INCH) {
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

    public Unit getUnit() {
        return this.unit;
    }
}
