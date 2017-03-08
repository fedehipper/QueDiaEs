package com.example.hipper.quediaes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.joda.time.DateTime;

public class Funciones {

    private Integer convertirMes(String mes) {
        Integer conversionDeMes = 0;
        if(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12").contains(mes)) {
            conversionDeMes = Integer.valueOf(mes);
        } else {
            switch (mes.toUpperCase()) {
                case "ENERO": conversionDeMes = 1; break;
                case "FEBRERO": conversionDeMes = 2; break;
                case "MARZO": conversionDeMes = 3; break;
                case "ABRIL": conversionDeMes = 4; break;
                case "MAYO": conversionDeMes = 5; break;
                case "JUNIO": conversionDeMes = 6; break;
                case "JULIO": conversionDeMes = 7; break;
                case "AGOSTO": conversionDeMes = 8; break;
                case "SEPTIEMBRE":
                    case "SETIEMBRE": conversionDeMes = 9; break;
                case "OCTUBRE": conversionDeMes = 10; break;
                case "NOVIEMBRE": conversionDeMes = 11; break;
                case "DICIEMBRE": conversionDeMes = 12; break;
            }
        }
        return conversionDeMes;
    }

    public String calculoDeDia(Integer anio, String mes, Integer dia) {
        DateTime date = new DateTime(anio, convertirMes(mes), dia, 0, 0, 0);
        Integer diaSemana = date.dayOfWeek().get();

        String cadenaDia = "";
        switch (diaSemana) {
            case 1: cadenaDia = "Lunes"; break;
            case 2: cadenaDia = "Martes"; break;
            case 3: cadenaDia = "Miercoles"; break;
            case 4: cadenaDia =  "Jueves"; break;
            case 5: cadenaDia = "Viernes"; break;
            case 6: cadenaDia = "Sabado"; break;
            case 7: cadenaDia = "Domingo"; break;
        }
        return cadenaDia;
    }

    public boolean esUnNumeroDecimal(String unValor) {
        List<String> cadenas = new ArrayList<>();
        char[] array = unValor.toCharArray();

        for(int i = 0 ; i < unValor.length() ; i++) {
            cadenas.add(String.valueOf(array[i]));
        }
        List<String> decimal = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        int j;
        for(j = 0 ; j < cadenas.size() ; j++) {
            if(!decimal.contains(cadenas.get(j))) break;
        }
        return j == cadenas.size();
     }

    public boolean anioCorrecto(String unAnio) {
        return esUnNumeroDecimal(unAnio);
    }

    public boolean mesCorrecto(String unMes) {
        String conversionMes = unMes.toUpperCase();
        List<String> decimales = Arrays.asList("1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<String> meses = Arrays.asList("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO",
                "SEPTIEMBRE", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE");
        return decimales.contains(conversionMes) || meses.contains(conversionMes);
    }

    public boolean diaCorrecto(Integer anio, String mes, String dia) {
        boolean esCorrecto = true;
        try {
            new DateTime(anio, convertirMes(mes), Integer.valueOf(dia), 0, 0, 0);
        } catch(Exception e) {
            esCorrecto = false;
        }
        return esUnNumeroDecimal(dia) && esCorrecto;
    }

}