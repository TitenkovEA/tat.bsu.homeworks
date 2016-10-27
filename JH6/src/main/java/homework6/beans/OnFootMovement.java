package homework6.beans;

import java.math.BigDecimal;

/**
 * Created by Я on 26.10.2016.
 */
public class OnFootMovement extends MusculPowerMovement {
    private static final double DEFAULT_SPEED = 5;
    private static final String DEFAULT_NAME = "OnFood";

    public OnFootMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME);
    }

    public OnFootMovement(double speed, String name) {
        super(speed, name);
    }

    @Override
    public BigDecimal getPriceResult(Route route) {
        return BigDecimal.ZERO;
    }

}
