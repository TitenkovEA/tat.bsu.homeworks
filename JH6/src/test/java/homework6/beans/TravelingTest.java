package homework6.beans;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TravelingTest {
    private Route route;
    private List<Checkpoint> checkpoints;
    private Route.Traveling traveling;

    @Before
    public void setUp() throws Exception {
        checkpoints = new ArrayList<Checkpoint>();
        checkpoints.add(new Checkpoint(0, 0));
        checkpoints.add(new Checkpoint(100, 0));
        route = new Route(checkpoints);
        traveling = route.createTraveling();
    }

    @Test
    public void positiveGetDistance() throws Exception {
        traveling.moveToNextPoint();
        assertEquals(100.0, traveling.getDistance(), 0.01);
    }

    @Test
    public void positiveMoveToNextPoint() throws Exception {
        assertTrue(traveling.moveToNextPoint());
    }

    @Test
    public void negativeMoveToNextPoint() throws Exception {
        assertTrue(traveling.moveToNextPoint());
        assertFalse(traveling.moveToNextPoint());
    }
}