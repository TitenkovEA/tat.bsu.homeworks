package homework6.beans;

import java.util.List;

/**
 * Represents checkpoints.
 *
 * @author Eugeny Titenkov
 */
public class Route {
    private List<Checkpoint> checkpoints;

    /**
     * Creates object of route, gets input parameters of route
     * and adds information about route.
     *
     * @param checkpoints - list of checkpoints.
     */
    public Route(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    /**
     * Return list of checkpoints.
     *
     * @return list of checkpoints.
     */
    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    /**
     * Allows to move on route.
     */
    public class Traveling {
        private int currentPointIndex = 0;
        private int nextPointIndex = currentPointIndex + 1;
        private int finishPointIndex = checkpoints.size() - 1;
        private double distance = 0.0;

        /**
         * Return traveled distance.
         *
         * @return traveled distance.
         */
        public double getDistance() {
            return distance;
        }

        /**
         * Allows move from current point to next.
         *
         * @return true if you can move, else false.
         */
        public boolean moveToNextPoint() {
            double sideA;
            double sideB;
            if (currentPointIndex < finishPointIndex) {
                sideA = Math.abs(
                        checkpoints.get(currentPointIndex).getX()- checkpoints.get(nextPointIndex).getX());
                sideB = Math.abs(
                        checkpoints.get(currentPointIndex).getY()- checkpoints.get(nextPointIndex).getY());
                this.distance = Math.sqrt(sideA*sideA + sideB*sideB);
                currentPointIndex++;
                nextPointIndex++;
            } else {
                return false;
            }
            return true;
        }
    }

    /**
     * Creates object of traveling, and return this object.
     *
     * @return object of traveling.
     */
    public Traveling createMovement() {
        return new Traveling();
    }
}
