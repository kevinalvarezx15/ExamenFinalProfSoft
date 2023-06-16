package com.example.examenultimo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumaNoVerificados {
    private int suma = 0;

    public void sumarNoVerificacion(boolean verificado) {
        if (verificado) {
            suma++;
        } else {
            suma--;
        }
    }

    public int getSuma() {
        return suma;
    }
}
