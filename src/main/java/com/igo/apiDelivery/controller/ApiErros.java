package com.igo.apiDelivery.controller;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiErros {
    private List<String> erros;

    public ApiErros(String messageError ){
        this.erros = Arrays.asList(messageError) ;
    }

}
