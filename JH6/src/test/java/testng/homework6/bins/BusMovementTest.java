package testng.homework6.bins;

import homework6.beans.BusMovement;
import homework6.beans.Checkpoint;
import homework6.beans.Route;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class BusMovementTest {
    @DataProvider(name = "validCheckpointsWithTime")
    private Object[][] createValidPointsWithTime() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 2))), (long) ((1.0 / 50) * 3600000)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23.0),
                        new Checkpoint(1.0, 23.56))), (long) ((0.56 / 50) * 3600000)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(5, 4))), (long) ((5.0 / 50) * 3600000)}
        };
    }

    @DataProvider(name = "validCheckpointsWithPrice")
    private Object[][] createValidPointsWithPrice() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 2))),
                        new BigDecimal(0.02).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23.0),
                        new Checkpoint(1.0, 23.56))),
                        new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(5, 4))),
                        new BigDecimal(0.10).setScale(2, BigDecimal.ROUND_HALF_UP)}
        };
    }

    @Test(dataProvider = "validCheckpointsWithTime")
    public void positiveGetTimeResult(ArrayList<Checkpoint> checkpoints,
                                      long time) throws Exception {
        BusMovement busMovement = new BusMovement();
        long resultTime = busMovement.getTimeResult(new Route(checkpoints));
        assertEquals(resultTime, time);
    }

    @Test(dataProvider = "validCheckpointsWithPrice")
    public void positiveGetPriceResult(ArrayList<Checkpoint> checkpoints,
                                       BigDecimal prise) throws Exception {
        BusMovement busMovement = new BusMovement();
        BigDecimal resultPrice = busMovement.getPriceResult(new Route(checkpoints));
        assertEquals(resultPrice, prise);
    }
}