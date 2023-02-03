package com.course.pitest;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("The school has insufficient funds for this course. It needs more students.");
    }
}