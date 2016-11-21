package com.tat.at1.utils;

/**
 * Allows collect statistics of application.
 *
 * @author Eugeny Titenkov.
 */
public class Statistic {
    private static int failedCount = 0;
    private static int passedCount = 0;
    private static int totalCount = 0;
    private static double fullTime = 0;

    /**
     * Increases failedCount by 1.
     * increases totalCount by 1.
     * Add time.
     *
     * @param time - add time to fullTime.
     */
    public static void addFailedTestInfo(double time) {
        failedCount++;
        totalCount++;
        fullTime += time;
    }

    /**
     * Increases failedCount by 1.
     * increases totalCount by 1.
     * Add time.
     *
     * @param time - add time to fullTime.
     */
    public static void addPassedTestInfo(double time) {
        passedCount++;
        totalCount++;
        fullTime += time;
    }

    /**
     * Returns information about total test count.
     *
     * @return information about total test count.
     */
    public static String getTotalCountInfo() {
        return "Total tests: " + totalCount;
    }

    /**
     * Returns information about total test time.
     *
     * @return information about total test time.
     */
    public static String getTotalTimeInfo() {
        return "Total time: " + String.format("%.3f", fullTime);
    }

    /**
     * Returns information about passed and failed tests.
     *
     * @return information about passed and failed tests.
     */
    public static String getTestsInfo() {
        String testsInfo = passedCount + "/" + failedCount;
        return "Passed/Failed: " + testsInfo;
    }

    /**
     * Returns information about average test time.
     *
     * @return information about average test time.
     */
    public static String getAverageTimeInfo() {
        return "Average time: " + String.format("%.3f", fullTime / totalCount);
    }
}
