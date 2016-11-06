package homework6.serveces;

import homework6.beans.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TravelingStatisticServiceTest {
    private TravelingStatisticService statisticService;

    @Before
    public void setUp() throws Exception {
        statisticService = new TravelingStatisticService();
    }

    @Test
    public void positiveAddMovement() throws Exception {
        statisticService.addMovement(new FootMovement())
                .addMovement(new BicycleMovement())
                .addMovement(new CarMovement())
                .addMovement(new BicycleMovement());
        assertEquals(4, statisticService.getMovements().size());
    }

    @Test
    public void positiveGetGeneralStatisticsRoute() throws Exception {
        statisticService.getGeneralStatisticsRoute(new Route(new ArrayList<Checkpoint>()));
    }
}