package homework6.serveces;

import homework6.beans.Checkpoint;
import homework6.beans.Route;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidatorTest {
    private Route route;
    private List<Checkpoint> checkpoints;

    @Before
    public void setUp() throws Exception {
        checkpoints = new ArrayList<Checkpoint>();
    }

    @Test
    public void positiveValidateRouteExist() throws Exception {
        checkpoints.add(new Checkpoint(0, 0));
        checkpoints.add(new Checkpoint(1, 0));
        route = new Route(checkpoints);
        assertTrue(Validator.validateRouteExist(route));
    }

    @Test
    public void negativeValidateRouteExist1() throws Exception {
        checkpoints.add(new Checkpoint(1, 2));
        checkpoints.add(new Checkpoint(1, 0));
        checkpoints.add(new Checkpoint(1, 2));
        route = new Route(checkpoints);
        assertFalse(Validator.validateRouteExist(route));
    }

    @Test
    public void negativeValidateRouteExist2() throws Exception {
        route = new Route(checkpoints);
        assertFalse(Validator.validateRouteExist(route));
    }

    @Test
    public void negativeValidateRouteExist3() throws Exception {
        route = new Route(checkpoints);
        checkpoints.add(new Checkpoint(1, 2));
        assertFalse(Validator.validateRouteExist(route));
    }
}