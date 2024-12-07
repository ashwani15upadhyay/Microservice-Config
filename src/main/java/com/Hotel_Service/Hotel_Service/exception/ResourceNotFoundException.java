package com.Hotel_Service.Hotel_Service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource not found !!");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
