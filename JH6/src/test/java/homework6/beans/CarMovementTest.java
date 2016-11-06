package homework6.beans;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarMovementTest {
    private CarMovement carMovement;
    private Route route;
    private List<Checkpoint> checkpoints;

    @Before
    public void setUp() throws Exception {
        checkpoints = new ArrayList<Checkpoint>();
        checkpoints.add(new Checkpoint(0, 0));
        checkpoints.add(new Checkpoint(100, 0));
        carMovement = new CarMovement();
        route = new Route(checkpoints);
    }

    @Test
    public void positiveGetPriceResult() throws Exception {
        BigDecimal validValue = carMovement.getFuelPricePerLiter().multiply(
                new BigDecimal(carMovement.getFuelConsumption())).setScale(
                2, BigDecimal.ROUND_HALF_UP);
        assertEquals(validValue, carMovement.getPriceResult(route));
    }

    @Test
    public void positiveGetTimeResult() throws Exception {
        long time = (long) ((100.0 / carMovement.getSpeed()) * 3600000);
        assertEquals(time, carMovement.getTimeResult(route));
    }
}