package homework6.beans;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BicycleMovementTest {
    private BicycleMovement bicycleMovement;
    private Route route;
    private List<Checkpoint> checkpoints;

    @Before
    public void setUp() throws Exception {
        checkpoints = new ArrayList<Checkpoint>();
        checkpoints.add(new Checkpoint(0, 0));
        checkpoints.add(new Checkpoint(1, 0));
        bicycleMovement = new BicycleMovement();
        route = new Route(checkpoints);
    }

    @Test
    public void positiveGetPriceResult() throws Exception {
        BigDecimal validValue = new BigDecimal(0);
        assertEquals(validValue, bicycleMovement.getPriceResult(route));
    }

    @Test
    public void positiveGetTimeResult() throws Exception {
        long time = (long) ((1.0 / bicycleMovement.getSpeed()) * 3600000);
        assertEquals(time, bicycleMovement.getTimeResult(route));
    }
}