package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents movement by car.
 *
 * @author Eugeny Titenkov
 */
public class CarMovement extends InternalCombustionEngineMovement {
    private static final double DEFAULT_SPEED = 80;
    private static final double DEFAULT_FUEL_CONSUMPTION = 6;
    private static final BigDecimal DEFAULT_FUEL_PRICE_PER_LITER = new BigDecimal(5.15);
    private static final String DEFAULT_NAME = "Car";

    /**
     * Creates default object of CarMovement, with default parameters.
     */
    public CarMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME, DEFAULT_FUEL_CONSUMPTION, DEFAULT_FUEL_PRICE_PER_LITER);
    }

    /**
     * Return price of travel, depending on route.
     *
     * @param route - route.
     * @return price type of BidDecimal.
     */
    @Override
    public BigDecimal getPriceResult(Route route) {
        Route.Traveling traveling = route.createMovement();
        double distance = 0.0;
        while (traveling.moveToNextPoint()) {
            distance += traveling.getDistance();
        }
        double hundredsKm = distance / 100.0;
        double litersSpent = hundredsKm * this.getFuelConsumption();
        BigDecimal price = this.getFuelPricePerLiter().multiply(BigDecimal.valueOf(litersSpent));
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
