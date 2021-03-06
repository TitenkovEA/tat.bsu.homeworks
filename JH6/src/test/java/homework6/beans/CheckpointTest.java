package homework6.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckpointTest {
    private Object pointOne;
    private Object pointTwo;

    @Test
    public void positiveEquals() throws Exception {
        pointOne = new Checkpoint(1, 1);
        pointTwo = new Checkpoint(1, 1);
        assertTrue(pointOne.equals(pointTwo));
    }

    @Test
    public void negativeEquals() throws Exception {
        pointOne = new Checkpoint(1, 1);
        pointTwo = new Checkpoint(0, 1);
        assertFalse(pointOne.equals(pointTwo));
    }
}