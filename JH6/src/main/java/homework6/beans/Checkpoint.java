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
}
