package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents movement by food.
 *
 * @author Eugeny Titenkov
 */
public class FootMovement extends Movement {
    private static final double DEFAULT_SPEED = 5;
    private static final String DEFAULT_NAME = "OnFood";

    /**
     * Creates default object of FootMovement, with default parameters.
     */
    public FootMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME);
    }

    /**
     * Creates object of FootMovement, gets input parameters of FootMovement
     * and adds information about FootMovement.
     *
     * @param speed - speed of movement.
     * @param name - name of movement.
     */
    public FootMovement(double speed, String name) {
        super(speed, name);
    }

    /**
     * Return price of travel, depending on route.
     * On foot movement it always will be zero.
     *
     * @param route - route.
     * @return price type of BidDecimal, on foot movement it always will be zero.
     */
    @Override
    public BigDecimal getPriceResult(Route route) {
        return BigDecimal.ZERO;
    }

}
