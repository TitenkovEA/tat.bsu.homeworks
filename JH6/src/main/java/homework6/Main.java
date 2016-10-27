package homework6;

import homework6.beans.*;
import homework6.serveces.RouteReader;
import homework6.serveces.TravelingStatisticService;
import homework6.serveces.Validator;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static final String INPUT_FILE = "Checkpoints.txt";
    private static final int GENERIC_ERROR = 1;

    /**
     * Read route from Checkpoints.txt, and print result of traveling to console.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            Route route = new Route(new RouteReader().readRouteFromFile(INPUT_FILE));
            if (Validator.validateRouteExist(route)) {
                TravelingStatisticService service = new TravelingStatisticService();
                service.addMovement(new FootMovement()).
                        addMovement(new BicycleMovement()).
                        addMovement(new CarMovement()).
                        addMovement(new BusMovement());
                service.getGeneralStatisticsRoute(route);
            }
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
