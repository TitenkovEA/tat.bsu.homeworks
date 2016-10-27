package homework6.serveces;

import homework6.beans.MovementResult;
import homework6.beans.Route;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Я on 26.10.2016.
 */
public class StatisticService {
    private List<MovementResult> movementResults = new ArrayList<MovementResult>();

    public StatisticService addMovementResultses(MovementResult movementResult) {
        movementResults.add(movementResult);
        return this;
    }

    public void getGeneralStatisticsRoute(Route route) {
        String time;
        for (MovementResult moveStat : movementResults) {
            time = TimeConverter.convertLongToTime(moveStat.getTimeResult(route));
            System.out.printf("On %s, this route will take %s, \n" +
                    "and it will cost %s$. \n", moveStat.getName(), time,
                    moveStat.getPriceResult(route));
        }
    }
}
