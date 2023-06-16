package com.example.examenultimo.controller;

import com.example.examenultimo.persistence.entity.ResultadoLeucemia;
import com.example.examenultimo.persistence.entity.SumaNoVerificados;
import com.example.examenultimo.persistence.entity.SumaVerificados;
import com.example.examenultimo.persistence.entity.adn;
import com.example.examenultimo.persistence.entity.stats;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adn")
@RequiredArgsConstructor
public class adnController {
    private SumaNoVerificados sumaNoVerificados = new SumaNoVerificados();
    private SumaVerificados sumaVerificaciones = new SumaVerificados();
    @PostMapping
    public ResultadoLeucemia ComprobarAdn(@RequestBody adn muestra){

        int n = muestra.getMuestra().size();
        int m = muestra.getMuestra().get(0).length();

        for (int i = 0; i < n; i++) {
            String cadena = muestra.getMuestra().get(i);

            // horizontal
            for (int j = 0; j < m - 2; j++) {
                char letra = cadena.charAt(j);
                if (cadena.charAt(j + 1) == letra && cadena.charAt(j + 2) == letra) {
                    sumaVerificaciones.sumarVerificacion(true);
                    return new ResultadoLeucemia(HttpStatus.OK.value(), "Verificado");
                }
            }

            //vertical
            for (int j = 0; j < m; j++) {
                char letra = cadena.charAt(j);
                if (i + 2 < n && muestra.getMuestra().get(i + 1).charAt(j) == letra && muestra.getMuestra().get(i + 2).charAt(j) == letra) {
                    sumaVerificaciones.sumarVerificacion(true);
                    return new ResultadoLeucemia(HttpStatus.OK.value(), "Verificado");
                }
            }
        }
        sumaVerificaciones.sumarVerificacion(false);
        return new ResultadoLeucemia(HttpStatus.NOT_FOUND.value(), "No verificado");
    }

    private boolean verificarSecuenciaHorizontal(String cadena) {
        int n = cadena.length();
        for (int i = 0; i < n - 2; i++) {
            if (cadena.charAt(i) == cadena.charAt(i + 1) && cadena.charAt(i) == cadena.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarSecuenciaVertical(List<String> muestra, String cadena) {
        int n = muestra.size();
        for (int i = 0; i < n - 2; i++) {
            if (muestra.get(i).charAt(0) == cadena.charAt(0) &&
                    muestra.get(i + 1).charAt(0) == cadena.charAt(0) &&
                    muestra.get(i + 2).charAt(0) == cadena.charAt(0)) {
                return true;
            }
        }
        return false;
    }
    @GetMapping("/stats")
    public stats stats(){return new stats(sumaVerificaciones.getVerificados(), sumaVerificaciones.getNoVerificados());}
}
