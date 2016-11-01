package testng.homework6.bins;

import homework6.beans.BicycleMovement;
import homework6.beans.Checkpoint;
import homework6.beans.Route;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class BicycleMovementTest {
    @DataProvider(name = "validCheckpointsWithTime")
    private Object[][] createValidPointsWithTime() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 2))), (long) ((1.0 / 30) * 3600000)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23.0),
                        new Checkpoint(1.0, 23.56))), (long) ((0.56 / 30) * 3600000)},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(5, 4))), (long) ((5.0 / 30) * 3600000)}
        };
    }

    @Test(dataProvider = "validCheckpointsWithTime")
    public void positiveGetTimeResult(ArrayList<Checkpoint> checkpoints,
                                      long time) throws Exception {
        BicycleMovement bicycleMovement = new BicycleMovement();
        long resultTime = bicycleMovement.getTimeResult(new Route(checkpoints));
        assertEquals(resultTime, time);
    }
}