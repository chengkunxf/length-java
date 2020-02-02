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

    public Length temp_as(Unit temp_unit) {
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
            } else if (temp_unit == Unit.FOOT){
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

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
