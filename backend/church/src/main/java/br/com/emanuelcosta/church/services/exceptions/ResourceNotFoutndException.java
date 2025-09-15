package br.com.emanuelcosta.church.services.exceptions;

import java.io.Serial;

public class ResourceNotFoutndException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2287810468059381574L;

    public ResourceNotFoutndException(Object id) { super("Resource not found. Id " + id);}
}
