package homework6.serveces;

import java.util.Date;

/**
 * Created by Я on 27.10.2016.
 */
public class TimeConverter {
    public static String convertLongToTime(long timeInMs) {
        StringBuilder time = new StringBuilder();
        Date date = new Date(timeInMs);
        time.append("Years: ");
        time.append(date.getYear() - 70);
        time.append(", Month: ");
        time.append(date.getMonth());
        time.append(", Days: ");
        time.append(date.getDate());
        time.append(", Hours: ");
        time.append(date.getHours());
        time.append(", Minutes: ");
        time.append(date.getMinutes());
        time.append(", Seconds: ");
        time.append(date.getSeconds());
        time.append(".");
        return time.toString();
    }
}
