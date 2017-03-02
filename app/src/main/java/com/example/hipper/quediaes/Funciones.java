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

        dias = Arrays.asList(new Pair<>("Domingo", 0), new Pair<>("Lunes", 1), new Pair<>("Martes", 2),
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
                if(meses.get(i).getValue(0).equals(mes.toUpperCase())) {
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

}