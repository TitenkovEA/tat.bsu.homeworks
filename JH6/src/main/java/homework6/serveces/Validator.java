package homework6.serveces;

import homework6.beans.Checkpoint;
import homework6.beans.Route;

import java.util.List;

/**
 * Validate route.
 *
 * @author Eugeny Titenkov
 */
public class Validator {
    /**
     * Validate route on sense.
     *
     * @param routeForValidate - route
     * @return true if this route have sense, else false.
     */
    public static boolean validateRouteExist(Route routeForValidate) {
        List<Checkpoint> route = routeForValidate.getCheckpoints();
        for (Checkpoint point : route) {
            if (!validateDouble(point.getX()) || !validateDouble(point.getY())) {
                return false;
            }
        }
        return !(route.size() == 0 || route.get(0).equals(route.get(route.size() - 1)));
    }

    /**
     * Validate double on infinity and NaN.
     *
     * @param valueForValidate - param for validate.
     * @return - true if value not infinity or NaN, else false.
     */
    public static boolean validateDouble(double valueForValidate) {
        return (!Double.valueOf(valueForValidate).isInfinite() &&
                !Double.valueOf(valueForValidate).isNaN());
    }
}
