package homework6.beans;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BusMovementTest {
    private BusMovement busMovement;
    private Route route;
    private List<Checkpoint> checkpoints;

    @Before
    public void setUp() throws Exception {
        checkpoints = new ArrayList<Checkpoint>();
        checkpoints.add(new Checkpoint(0, 0));
        checkpoints.add(new Checkpoint(100, 0));
        busMovement = new BusMovement();
        route = new Route(checkpoints);
    }

    @Test
    public void positiveGetPriceResult() throws Exception {
        BigDecimal validValue = busMovement.getFuelPricePerLiter().multiply(
                new BigDecimal(busMovement.getFuelConsumption())).divide(
                BigDecimal.valueOf((long) busMovement.getPassengerCount())).setScale(
                2, BigDecimal.ROUND_HALF_UP);
        assertEquals(validValue, busMovement.getPriceResult(route));
    }

    @Test
    public void positiveGetTimeResult() throws Exception {
        long time = (long) ((100.0 / busMovement.getSpeed()) * 3600000);
        assertEquals(time, busMovement.getTimeResult(route));
    }
}