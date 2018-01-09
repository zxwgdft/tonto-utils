package com.tonto2.database;

public class DataObjectException extends Exception{

	private static final long serialVersionUID = 7875899003520001358L;

    public DataObjectException(String message) {
        super(message);
    }

    public DataObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
