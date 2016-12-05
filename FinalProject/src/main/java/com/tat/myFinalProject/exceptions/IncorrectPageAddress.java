package com.tat.myFinalProject.exceptions;

/**
 * Created by Я on 05.12.2016.
 */
public class IncorrectPageAddress extends RuntimeException {
    public IncorrectPageAddress() {
        super("Incorrect page address");
    }
}
