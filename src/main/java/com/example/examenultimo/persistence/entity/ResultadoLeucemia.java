package com.example.examenultimo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoLeucemia {
    private int code;
    private String result;

    public ResultadoLeucemia(int code, String result) {
        this.code = code;
        this.result = result;
    }
}
