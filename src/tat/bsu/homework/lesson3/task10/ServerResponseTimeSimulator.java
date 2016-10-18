package tat.bsu.homework.lesson3.task10;

import java.util.Random;

/**
 * Simulate response time of server.
 *
 * @author Eugeny Titenkov
 */
public class ServerResponseTimeSimulator {
    /**
     * Generate random number from 10 to 500.
     *
     * @return random response time in ms.
     */
    public static int generateResponseTime() {
        Random random = new Random();
        int minMs = 9;
        return minMs + random.nextInt(492);
    }
}
