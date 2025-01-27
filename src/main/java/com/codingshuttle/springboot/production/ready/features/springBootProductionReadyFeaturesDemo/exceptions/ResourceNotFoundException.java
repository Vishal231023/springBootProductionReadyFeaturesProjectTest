package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
