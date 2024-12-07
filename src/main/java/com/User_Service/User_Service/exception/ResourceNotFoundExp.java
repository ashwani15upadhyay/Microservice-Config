package com.User_Service.User_Service.exception;

public class ResourceNotFoundExp extends RuntimeException{

    public ResourceNotFoundExp(){
        super("Resource not found on server !!");
    }

    public ResourceNotFoundExp(String message){
        super(message);
    }
}
