package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents movement by bus.
 *
 * @author Eugeny Titenkov
 */
public class BusMovement extends InternalCombustionEngineMovement {
    private static final double DEFAULT_SPEED = 50;
    private static final double DEFAULT_FUEL_CONSUMPTION = 20;
    private static final BigDecimal DEFAULT_FUEL_PRICE_PER_LITER = new BigDecimal(4.15);
    private static final int DEFAULT_PASSENGER_COUNT = 40;
    private static final String DEFAULT_NAME = "Bus";

    private int passengerCount;

    /**
     * Creates default object of BusMovement, with default parameters.
     */
    public BusMovement() {
        super(DEFAULT_SPEED, DEFAULT_NAME, DEFAULT_FUEL_CONSUMPTION, DEFAULT_FUEL_PRICE_PER_LITER);
        this.passengerCount = DEFAULT_PASSENGER_COUNT;
    }

    /**
     * Creates object of BusMovement, gets input parameters of
     * BusMovement and adds this information.
     *
     * @param speed - speed of movement.
     * @param name - name of movement.
     * @param fuelConsumption - fuel consumption.
     * @param fuelPricePerLiter - fuel price per liter.
     * @param passengerCount - count of passenger.
     */
    public BusMovement(double speed, String name, double fuelConsumption,
                       BigDecimal fuelPricePerLiter, int passengerCount) {
        super(speed, name, fuelConsumption, fuelPricePerLiter);
        this.passengerCount = passengerCount;
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
        BigDecimal generalPrice = this.getFuelPricePerLiter().multiply(BigDecimal.valueOf(litersSpent));
        BigDecimal personPrice = generalPrice.divide(BigDecimal.valueOf((long) passengerCount));
        return personPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
