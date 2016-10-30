package homework6.beans;

import java.math.BigDecimal;

/**
 * Represents internal combustion engine movement object.
 *
 * @author Eugeny Titenkov
 */
public abstract class InternalCombustionEngineMovement extends Movement {
    private double fuelConsumption;
    private BigDecimal fuelPricePerLiter;

    /**
     * Creates object of InternalCombustionEngineMovement, gets input parameters of
     * InternalCombustionEngineMovement and adds this information.
     *
     * @param speed - speed of movement.
     * @param name - name of movement.
     * @param fuelConsumption - fuel consumption.
     * @param fuelPricePerLiter - fuel price per liter.
     */
    public InternalCombustionEngineMovement(double speed, String name, double fuelConsumption,
                                            BigDecimal fuelPricePerLiter) {
        super(speed, name);
        this.fuelConsumption = fuelConsumption;
        this.fuelPricePerLiter = fuelPricePerLiter;
    }

    /**
     * Return fuel consumption.
     *
     * @return fuel consumption.
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Return fuel price per liter.
     *
     * @return fuel price per liter.
     */
    public BigDecimal getFuelPricePerLiter() {
        return fuelPricePerLiter;
    }
}
