package com.example.examenultimo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumaVerificados {
    private int Verificados = 0;
    private int NoVerificados=0;


    public void sumarVerificacion(boolean verificado) {
        if (verificado) {
            Verificados++;
        } else {
            NoVerificados++;
        }
    }

    public int getVerificados(){
        return Verificados;
    }
    public int getNoVerificados(){
        return NoVerificados;
    }
}
