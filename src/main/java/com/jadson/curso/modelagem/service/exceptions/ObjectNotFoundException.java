package com.jadson.curso.modelagem.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 7142161250766958607L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
