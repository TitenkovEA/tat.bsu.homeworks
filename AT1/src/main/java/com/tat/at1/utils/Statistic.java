package com.tat.at1.utils;

/**
 *
 *
 */
public class Statistic {
    private static int failedCount = 0;
    private static int passedCount = 0;
    private static int totalCount = 0;
    private static double fullTime = 0;


    public static void addFailedTestInfo(double time) {
        failedCount++;
        totalCount++;
        fullTime += time;
    }

    public static void addPassedTestInfo(double time) {
        passedCount++;
        totalCount++;
        fullTime += time;
    }

    public static String getTotalCountInfo() {
        return "Total tests: " + totalCount;
    }

    public static String getTotalTimeInfo() {
        return "Total time: " + String.format("%.3f", fullTime);
    }

    public static String getTestsInfo() {
        String testsInfo = passedCount + "/" + failedCount;
        return "Passed/Failed: " + testsInfo;
    }

    public static String getAverageTimeInfo() {
        return "Average time: " + String.format("%.3f", fullTime / totalCount);
    }
}
