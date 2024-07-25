package com.igo.apiDelivery.exception;

public class BagClosedException extends RuntimeException{
    public BagClosedException() {
        super("Sacola está fechada.");
    }
}
