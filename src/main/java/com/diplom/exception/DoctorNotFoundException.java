package com.diplom.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(Long id) {
        super("Doctor not found by id : " + id);
    }
}
