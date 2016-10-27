package homework6;

import homework6.beans.*;
import homework6.serveces.RouteReader;
import homework6.serveces.StatisticService;
import homework6.serveces.Validator;

/**
 * Created by Я on 27.10.2016.
 */
public class Main {
    private static final String INPUT_FILE = "Checkpoints.txt";
    private static final int GENERIC_ERROR = 1;

    public static void main(String[] args) {
        try {
            Route route = new Route(new RouteReader().readRouteFromFile(INPUT_FILE));
            if (Validator.validateRouteExist(route)) {
                StatisticService service = new StatisticService();
                service.addMovementResultses(new OnFootMovement()).
                        addMovementResultses(new BicycleMovement()).
                        addMovementResultses(new CarMovement()).
                        addMovementResultses(new BusMovement());
                service.getGeneralStatisticsRoute(route);
            }
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
