package homework6.serveces;

/**
 * Represents time converter.
 *
 * @author Eugeny Titenkov
 */
public class TimeConverter {
    /**
     * Convert time from long to String.
     *
     * @param timeInMs - time in ms type of long
     * @return time in String format
     */
    public static String convertLongToTime(long timeInMs) {
        int msInDay = 86400000;
        int msInHour = 3600000;
        int msInMinute = 60000;
        int msInSecond = 1000;

        long days = timeInMs / msInDay;
        timeInMs -= days * msInDay;
        long hours = timeInMs / msInHour;
        timeInMs -= hours * msInHour;
        long minutes = timeInMs / msInMinute;
        timeInMs -= minutes * msInMinute;
        long seconds = timeInMs / msInSecond;

        StringBuilder time = new StringBuilder();
        time.append("Days: ");
        time.append(days);
        time.append(", Hours: ");
        time.append(hours);
        time.append(", Minutes: ");
        time.append(minutes);
        time.append(", Seconds: ");
        time.append(seconds);
        return time.toString();
    }
}
