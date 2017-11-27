// Mostly copied from IPJ online resources.
import edu.princeton.cs.introcs.StdOut;

public class Interval {
    private final double min;
    private final double max;

    public Interval(double min, double max) {
        if (Double.isInfinite(min) || Double.isInfinite(max))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(min) || Double.isNaN(max))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        // convert -0.0 to +0.0
        if (min == 0.0) min = 0.0;
        if (max == 0.0) max = 0.0;

        if (min <= max) {
            this.min = min;
            this.max = max;
        }
        else throw new IllegalArgumentException("Illegal interval");
    }


    public double min() {
        return min;
    }


    public double max() {
        return max;
    }


    public boolean intersects(Interval that) {
        if (this.max < that.min) return false;
        if (that.max < this.min) return false;
        return true;
    }


    public boolean contains(double x) {
        return (min <= x) && (x <= max);
    }

    public double length() {
        return max - min;
    }

    public String toString() {
        return "[" + min + ", " + max + "]";
    }


    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Interval that = (Interval) other;
        return this.min == that.min && this.max == that.max;
    }


    public int hashCode() {
        int hash1 = ((Double) min).hashCode();
        int hash2 = ((Double) max).hashCode();
        return 31*hash1 + hash2;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(15.0, 33.0);
        intervals[1] = new Interval(45.0, 60.0);
        intervals[2] = new Interval(20.0, 70.0);
        intervals[3] = new Interval(46.0, 55.0);

        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();
    }
}