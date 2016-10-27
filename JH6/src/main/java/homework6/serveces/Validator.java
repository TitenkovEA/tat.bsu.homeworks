package homework6.serveces;

import homework6.beans.Checkpoint;
import homework6.beans.Route;

import java.util.List;

/**
 * Created by Я on 27.10.2016.
 */
public class Validator {
    public static boolean validateRouteExist(Route routeForValidate) {
        List<Checkpoint> route = routeForValidate.getRoute();
        if (route.size() == 0 ||
                route.get(0).equals(route.get(route.size() - 1))) {
            return false;
        } else {
            return true;
        }
    }
}
