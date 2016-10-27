package homework6.beans;

import java.util.List;

/**
 * Created by Я on 26.10.2016.
 */
public class Route {
    private List<Checkpoint> route;

    public Route(List<Checkpoint> route) {
        this.route = route;
    }

    public List<Checkpoint> getRoute() {
        return route;
    }

    public class Movement {
        private int currentPointIndex = 0;
        private int nextPointIndex = currentPointIndex + 1;
        private int finishPointIndex = route.size() - 1;
        private double distance = 0.0;

        public double getDiststance() {
            return distance;
        }

        public boolean moveToNextPoint() {
            double sideA;
            double sideB;
            if (currentPointIndex < finishPointIndex) {
                sideA = Math.abs(
                        route.get(currentPointIndex).getX()-route.get(nextPointIndex).getX());
                sideB = Math.abs(
                        route.get(currentPointIndex).getY()-route.get(nextPointIndex).getY());
                this.distance = Math.sqrt(sideA*sideA + sideB*sideB);
                currentPointIndex++;
                nextPointIndex++;
            } else {
                return false;
            }

            return true;
        }
    }

    public Movement createMovement() {
        return new Movement();
    }
}
