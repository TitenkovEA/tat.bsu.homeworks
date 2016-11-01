package testng.homework6.bins;

import homework6.beans.Checkpoint;
import homework6.beans.Route;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class TravelingTest {

    @DataProvider(name = "validCheckpointsWithDistance")
    private Object[][] createValidPointsWithDistance() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 2))), 1.0},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23),
                        new Checkpoint(1.0, 23.56))), 0.56},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(5, 4))), 5.0}
        };
    }

    @DataProvider(name = "notValidCheckpoints")
    private Object[][] createNotValidPoints() {
        return new Object[][]{
                {new ArrayList<Checkpoint>()},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23)))}
        };
    }

    @Test(dataProvider = "validCheckpointsWithDistance")
    public void positiveMoveToNextPoint(ArrayList<Checkpoint> checkpoints,
                                        double result) throws Exception {
        Route route = new Route(checkpoints);
        Route.Traveling traveling = route.createTraveling();
        traveling.moveToNextPoint();
        assertEquals(traveling.getDistance(), result);
    }

    @Test(dataProvider = "notValidCheckpoints")
    public void negativeMoveToNextPoint(ArrayList<Checkpoint> checkpoints) throws Exception {
        Route route = new Route(checkpoints);
        Route.Traveling traveling = route.createTraveling();
        assertFalse(traveling.moveToNextPoint());
    }
}