package com.diplom.exception;

public class MessageDoesNotSendException extends RuntimeException {

    public MessageDoesNotSendException() {
        super("File not send to patient");
    }
}
