package com.example.examenultimo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class stats {
    private int Verificados;
    private int noVerificados;

    public stats(int verificados, int noVerificados) {
        this.Verificados = verificados;
        this.noVerificados = noVerificados;
    }
}
