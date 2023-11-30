package com.example.capstone.exceptions;

public class InvalidShipIDException extends Exception {
    public InvalidShipIDException(String errorMessage) {
        super(errorMessage);
    }
}
