package com.diplom.exception;

public class FeedbackNotFoundException extends RuntimeException {

    public FeedbackNotFoundException(Long id) {
        super("Feedback not found by id : " + id);
    }
}
