package br.com.emanuelcosta.church.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7167164406530218061L;

    public DatabaseException(String msg) {super(msg);}
}
