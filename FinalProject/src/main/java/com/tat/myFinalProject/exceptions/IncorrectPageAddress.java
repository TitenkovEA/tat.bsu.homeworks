package com.tat.myFinalProject.exceptions;

/**
 * IncorrectPageAddress exception, heir of runtime exception.
 * For throwing, when the page have incorrect address.
 *
 * @author Evgeniy Titenkov.
 */
public class IncorrectPageAddress extends RuntimeException {
    public IncorrectPageAddress() {
        super("Incorrect page address");
    }
}
