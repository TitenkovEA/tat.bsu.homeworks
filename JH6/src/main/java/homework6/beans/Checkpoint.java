package homework6.beans;

/**
 * Represents checkpoint object.
 *
 * @author Eugeny Titenkov
 */
public class Checkpoint {
    double x;
    double y;

    /**
     * Creates object of checkpoint, gets input parameters of checkpoint
     * and adds information about checkpoint.
     *
     * @param x - x coordinate.
     * @param y - y coordinate.
     */
    public Checkpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return x coordinate.
     *
     * @return x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Return y coordinate.
     *
     * @return y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Compares the objects.
     *
     * @param object - object of comparison.
     * @return true object the same, else false.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Checkpoint that = (Checkpoint) object;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;

        return true;
    }
}
