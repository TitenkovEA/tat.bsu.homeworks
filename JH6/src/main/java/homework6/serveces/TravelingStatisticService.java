package homework6.serveces;

import homework6.beans.Movement;
import homework6.beans.Route;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents statistic service of traveling.
 *
 * @author Eugeny Titenkov
 */
public class TravelingStatisticService {
    private List<Movement> movements = new ArrayList<Movement>();

    /**
     * Add object of Movement to list for the further statistic.
     *
     * @param movement - object type of Movement.
     * @return this.
     */
    public TravelingStatisticService addMovement(Movement movement) {
        movements.add(movement);
        return this;
    }

    /**
     * Display movement statistic depending on route.
     *
     * @param route - route.
     */
    public void getGeneralStatisticsRoute(Route route) {
        String time;
        for (Movement moveStat : movements) {
            time = TimeConverter.convertLongToTime(moveStat.getTimeResult(route));
            System.out.printf("On %s, this route will take %s, \n" +
                    "and it will cost %s$. \n", moveStat.getName(), time,
                    moveStat.getPriceResult(route));
        }
    }
}
