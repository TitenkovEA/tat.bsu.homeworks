package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents movement object.
 *
 * @author Eugeny Titenkov
 */
public abstract class Movement {
    private double speed;
    private String name;

    /**
     * Creates object of movement, gets input parameters of movement
     * and adds information about movement.
     *
     * @param speed - speed of movement.
     * @param name - name of movement.
     */
    public Movement(double speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    /**
     * Return time of travel, depending on route.
     *
     * @param route - route.
     * @return time in ms type of long.
     */
    public long getTimeResult(Route route) {
        Route.Traveling traveling = route.createMovement();
        double distance = 0.0;
        while (traveling.moveToNextPoint()) {
            distance += traveling.getDistance();
        }
        long a = (long) (distance / speed * 3600000);
        return a;
    }

    /**
     * Return price of travel, depending on route.
     *
     * @param route - route.
     * @return price type of BidDecimal.
     */
    public abstract BigDecimal getPriceResult(Route route);

    /**
     * Return name of movement.
     *
     * @return name of movement.
     */
    public String getName() {
        return name;
    }
}
