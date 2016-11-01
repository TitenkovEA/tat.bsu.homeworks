package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents movement by bicycle.
 *
 * @author Eugeny Titenkov
 */
public class BicycleMovement extends Movement {
    private static final double DEFAULT_SPEED = 30;
    private static final String DEFAULT_NAME = "Bicycle";

    /**
     * Creates default object of BicycleMovement, with default parameters.
     */
    public BicycleMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME);
    }

    /**
     * Return price of travel, depending on route.
     * On bicycle movement it always will be zero.
     *
     * @param route - route.
     * @return price type of BidDecimal, on bicycle movement it always will be zero.
     */
    @Override
    public BigDecimal getPriceResult(Route route) {
        return BigDecimal.ZERO;
    }
}
