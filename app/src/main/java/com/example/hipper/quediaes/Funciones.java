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

    public String calculoDeDia(Integer anio, String mes, Integer dia) {

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

        DateTime date = new DateTime(anio, conversionDeMes, dia, 0, 0, 0);
        Integer diaSemana = date.dayOfWeek().get();

        List<Pair<String, Integer>> diasAux = new ArrayList<>();
        for(int i = 0 ; i < 7 ; i++) {
            if(dias.get(i).getValue(1) == diaSemana) {
                diasAux.add(dias.get(i));
            }
        }
        return obtenerCadena(diasAux.get(0));
    }


    public boolean anioCorrecto(String unAnio) {
        List<String> cadenas = new ArrayList<>();
        char[] array = unAnio.toCharArray();

        for(int i = 0 ; i < unAnio.length() ; i++) {
            cadenas.add(String.valueOf(array[i]));
        }
        List <String> decimal = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        int count = 0;

        for(int j = 0 ; j < cadenas.size() ; j++) {
            if(decimal.contains(cadenas.get(j))) count++;
            else break;
        }
        return count == cadenas.size();
    }

    public boolean mesCorrecto(String unMes) {
        String conversionMes = unMes.toUpperCase();
        List<String> decimales = Arrays.asList("1","2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<String> meses = Arrays.asList("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO",
                "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE");
        return decimales.contains(conversionMes) || meses.contains(conversionMes);
    }

    public boolean diaCorrecto(Integer anio, String mes, Integer dia) {
        // si febrero no admite 29 hay que controlarlo
        // ver el tema de 30 y 31 de los meses

        // dado un mes de un año debo saber hasta que dia contiene




        return true;
    }

}