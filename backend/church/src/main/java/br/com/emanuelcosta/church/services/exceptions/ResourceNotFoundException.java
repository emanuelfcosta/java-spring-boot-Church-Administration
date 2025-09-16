package br.com.emanuelcosta.church.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2287810468059381574L;

    public ResourceNotFoundException(Object id) { super("Resource not found. Id " + id);}
}
