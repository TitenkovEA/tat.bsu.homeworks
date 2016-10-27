package homework6.beans;

/**
 * Created by Я on 26.10.2016.
 */
public abstract class MusculPowerMovement implements MovementResult {
    private double speed;
    private String name;

    public MusculPowerMovement(double speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public long getTimeResult(Route route) {
        Route.Movement movement = route.createMovement();
        while (movement.moveToNextPoint()) {
        }
        long a = (long) ((movement.getDiststance() / this.getSpeed()) * 3600000);
        return a;
    }

    @Override
    public String getName() {
        return name;
    }
}
