package homework6.beans;

import java.math.BigDecimal;

/**
 * Created by Я on 26.10.2016.
 */
public class CarMovement extends InternalCombustionEngineMovement {
    private static final double DEFAULT_SPEED = 80;
    private static final double DEFAULT_FUEL_CONSUMPTION = 6;
    private static final BigDecimal DEFAULT_FUEL_PRICE_PER_LITER = new BigDecimal(5.15);
    private static final String DEFAULT_NAME = "Car";

    public CarMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME, DEFAULT_FUEL_CONSUMPTION, DEFAULT_FUEL_PRICE_PER_LITER);
    }

    @Override
    public BigDecimal getPriceResult(Route route) {
        Route.Movement movement = route.createMovement();
        while (movement.moveToNextPoint()) {
        }
        double hundredsKm = movement.getDiststance() / 100;
        double litersSpent = hundredsKm * this.getFuelConsumption();
        BigDecimal price = this.getFuelPricePerLiter().multiply(BigDecimal.valueOf(litersSpent));
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
