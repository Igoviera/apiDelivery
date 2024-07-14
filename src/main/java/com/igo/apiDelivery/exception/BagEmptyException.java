package com.igo.apiDelivery.exception;

public class BagEmptyException extends RuntimeException{
    public BagEmptyException() {
        super("Inclua itens na sacola!");
    }
}
