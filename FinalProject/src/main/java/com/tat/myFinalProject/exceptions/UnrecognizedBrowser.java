package com.tat.myFinalProject.exceptions;

/**
 * UnrecognizedBrowser exception, heir of runtime exception.
 * For throwing, when the browser is unrecognized.
 *
 * @author Evgeniy Titenkov.
 */
public class UnrecognizedBrowser extends RuntimeException {
    public UnrecognizedBrowser(String browserType) {
        super("Unrecognized browser type: " + browserType);
    }
}
