package testng.homework6.serveces;

import homework6.serveces.TimeConverter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeConverterTest {
    private final static int MS_IN_DAY = 86400000;
    private final static int MS_IN_HOUR = 3600000;
    private final static int MS_IN_MINUTE = 60000;
    private final static int MS_IN_SECOND = 1000;

    @Test
    public void convertLongDayToString() throws Exception {
        assertEquals(TimeConverter.convertLongToTime(MS_IN_DAY),
                "Days: 1, Hours: 0, Minutes: 0, Seconds: 0");
    }

    @Test
    public void convertLongHourToString() throws Exception {
        assertEquals(TimeConverter.convertLongToTime(MS_IN_HOUR),
                "Days: 0, Hours: 1, Minutes: 0, Seconds: 0");
    }

    @Test
    public void convertLongMinuteToString() throws Exception {
        assertEquals(TimeConverter.convertLongToTime(MS_IN_MINUTE),
                "Days: 0, Hours: 0, Minutes: 1, Seconds: 0");
    }

    @Test
    public void convertLongSecondToString() throws Exception {
        assertEquals(TimeConverter.convertLongToTime(MS_IN_SECOND),
                "Days: 0, Hours: 0, Minutes: 0, Seconds: 1");
    }

    @Test
    public void convertLongDateToString() throws Exception {
        assertEquals(TimeConverter.convertLongToTime(MS_IN_SECOND + MS_IN_MINUTE +
                MS_IN_HOUR + MS_IN_DAY), "Days: 1, Hours: 1, Minutes: 1, Seconds: 1");
    }
}