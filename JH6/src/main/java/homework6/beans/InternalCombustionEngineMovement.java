package homework6.beans;

import java.math.BigDecimal;

/**
 * Created by Я on 26.10.2016.
 */
public abstract class InternalCombustionEngineMovement extends MusculPowerMovement {
    private double fuelConsumption;
    private BigDecimal fuelPricePerLiter;

    public InternalCombustionEngineMovement(double speed, String name, double fuelConsumption,
                                            BigDecimal fuelPricePerLiter) {
        super(speed, name);
        this.fuelConsumption = fuelConsumption;
        this.fuelPricePerLiter = fuelPricePerLiter;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public BigDecimal getFuelPricePerLiter() {
        return fuelPricePerLiter;
    }
}
