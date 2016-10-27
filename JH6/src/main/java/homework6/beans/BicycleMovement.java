package homework6.beans;

import java.math.BigDecimal;

/**
 * Created by Я on 26.10.2016.
 */
public class BicycleMovement extends MusculPowerMovement {
    private static final double DEFAULT_SPEED = 30;
    private static final String DEFAULT_NAME = "Bicycle";

    public BicycleMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME);
    }

    @Override
    public BigDecimal getPriceResult(Route route) {
        return BigDecimal.ZERO;
    }
}
