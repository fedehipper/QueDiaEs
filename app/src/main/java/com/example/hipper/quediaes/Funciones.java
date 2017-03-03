package com.example.hipper.quediaes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.javatuples.Pair;
import org.joda.time.DateTime;

public class Funciones {
    private List<Pair<String, Integer>> dias = new ArrayList<>();
    private List<Pair<String,Integer>> meses = new ArrayList<>();

    public Funciones() {
        meses = Arrays.asList(new Pair<>("ENERO", 1), new Pair<>("FEBRERO", 2),
                new Pair<>("MARZO", 3), new Pair<>("ABRIL", 4), new Pair<>("MAYO", 5),
                new Pair<>("JUNIO", 6), new Pair<>("JULIO", 7), new Pair<>("AGOSTO", 8),
                new Pair<>("SEPTIEMBRE", 10), new Pair<>("OCTUBRE", 9),
                new Pair<>("NOVIEMBRE", 11), new Pair<>("DICIEMBRE", 12));

        dias = Arrays.asList(new Pair<>("Domingo", 7), new Pair<>("Lunes", 1), new Pair<>("Martes", 2),
                new Pair<>("Miercoles", 3), new Pair<>("Jueves", 4), new Pair<>("Viernes", 5),
                new Pair<>("Sabado", 6));
    }

    private String obtenerCadena(Pair<String, Integer> tupla) {
        return (String)tupla.getValue(0);
    }

    private Integer convertirMes(String mes) {
        Integer conversionDeMes = 0;
        if(Arrays.asList("1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12").contains(mes)) {
            conversionDeMes = Integer.valueOf(mes);
        } else {
            for(int i = 0 ; i < 12 ; i++) {
                String mesMayuscula = mes.toUpperCase();
                if((meses.get(i).getValue(0)).equals(mesMayuscula)) {
                    conversionDeMes = (Integer)meses.get(i).getValue(1);
                }
            }
        }
        return conversionDeMes;
    }

    public String calculoDeDia(Integer anio, String mes, Integer dia) {
        DateTime date = new DateTime(anio, convertirMes(mes), dia, 0, 0, 0);
        Integer diaSemana = date.dayOfWeek().get();

        List<Pair<String, Integer>> diasAux = new ArrayList<>();
        for(int i = 0 ; i < 7 ; i++) {
            if(dias.get(i).getValue(1) == diaSemana) {
                diasAux.add(dias.get(i));
            }
        }
        return obtenerCadena(diasAux.get(0));
    }

    private boolean esUnNumeroDecimal(String unValor) {
        List<String> cadenas = new ArrayList<>();
        char[] array = unValor.toCharArray();

        for(int i = 0 ; i < unValor.length() ; i++) {
            cadenas.add(String.valueOf(array[i]));
        }
        List<String> decimal = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        int count = 0;

        for(int j = 0 ; j < cadenas.size() ; j++) {
            if(decimal.contains(cadenas.get(j))) count++; else break;
        }
        return count == cadenas.size();
     }

    public boolean anioCorrecto(String unAnio) {
        return esUnNumeroDecimal(unAnio);
    }

    public boolean mesCorrecto(String unMes) {
        String conversionMes = unMes.toUpperCase();
        List<String> decimales = Arrays.asList("1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<String> meses = Arrays.asList("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO",
                "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE");
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