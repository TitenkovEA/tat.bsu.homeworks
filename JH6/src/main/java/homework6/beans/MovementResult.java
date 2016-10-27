package homework6.beans;

import java.math.BigDecimal;

/**
 * Created by Я on 26.10.2016.
 */
public interface MovementResult {
    public long getTimeResult(Route route);
    public BigDecimal getPriceResult(Route route);
    public String getName();
}
