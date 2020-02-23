public class Length {
    public static final String FOOT = "f";
    public static final String YARD = "yard";
    public static final String INCH = "inch";
    private final double value;
    private final String unit;

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String tagetUnit) {
        Length len = this;
        if (this.unit.equals(FOOT)) {
            if (tagetUnit.equals(YARD)) {
                len = new Length(this.value / 3, tagetUnit);
            } else if (tagetUnit.equals(INCH)) {
                len = new Length(this.value * 12, tagetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (tagetUnit.equals(INCH)) {
                len = new Length(this.value * 36, tagetUnit);
            } else if (tagetUnit.equals(FOOT)){
                len = new Length(this.value * 3, tagetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (tagetUnit.equals(FOOT)) {
                len = new Length(this.value / 12, tagetUnit);
            } else if (tagetUnit.equals(YARD)) {
                len = new Length(this.value / 36, tagetUnit);
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
}
