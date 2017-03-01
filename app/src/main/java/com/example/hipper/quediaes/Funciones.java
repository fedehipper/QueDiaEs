package com.example.hipper.quediaes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.javatuples.Pair;
import org.javatuples.Triplet;

public class Funciones {
    private List<Triplet<String,Integer,String>> meses = new ArrayList<>();
    private List<Pair<String, Integer>> dias = new ArrayList<>();

    public Funciones() {
        meses = Arrays.asList(new Triplet<>("ENERO", 6, "1"), new Triplet<>("FEBRERO", 2, "2"),
                new Triplet<>("MARZO", 2, "3"), new Triplet<>("ABRIL", 5, "4"), new Triplet<>("MAYO", 0, "5"),
                new Triplet<>("JUNIO", 3, "6"), new Triplet<>("JULIO", 5, "7"), new Triplet<>("AGOSTO", 1, "8"),
                new Triplet<>("SEPTIEMBRE", 4, "8"), new Triplet<>("OCTUBRE", 6, "9"), new Triplet<>("NOVIEMBRE", 4, "10"),
                new Triplet<>("DICIEMBRE", 4, "12"));

        dias = Arrays.asList(new Pair<>("Domingo", 0), new Pair<>("Lunes", 1), new Pair<>("Martes", 2),
                new Pair<>("Miercoles", 3), new Pair<>("Jueves", 4), new Pair<>("Viernes", 5), new Pair<>("Sabado", 6));
    }

    private List<Integer> llenarDeAnios(int rangoInicial, int rangoFinal, List<Integer> lista) {
        for(int i = rangoInicial ; i <= rangoFinal ; i++) lista.add(i); return lista;
    }

    private Pair<List<Integer>, Integer> tuplaSiglo(Integer unAnio) {
        Integer siglo = (unAnio / 100) + 1;
        Integer valorSiglo;
        if(siglo >= 21) {
            valorSiglo = (siglo - 21) * -2;
        } else {
            List<Integer> listaImpares = new ArrayList<>();
            for(Integer i = 0 ; i < 50 ; i++) {
                if(i % 2 == 0) {
                    listaImpares.add(i);
                }
            }
            valorSiglo = listaImpares.get(21 - siglo);
        }
        List<Integer> rangoSiglo = new ArrayList<>();
        llenarDeAnios((siglo - 1) * 100, ((siglo - 1) * 100) + 99, rangoSiglo);
        return new Pair<>(rangoSiglo, valorSiglo);
    }

    private Integer coeficienteA(Integer unAnio) {
        return (Integer)tuplaSiglo(unAnio).getValue(1);
    }

    private Integer dosUltimosDigitos(Integer unAnio) {
        return unAnio % 100;
    }

    private Integer unCuarto(Integer unValor) {
        return unValor / 4;
    }

    private Integer coeficienteB(Integer unAnio) {
        return dosUltimosDigitos(unAnio) + unCuarto(dosUltimosDigitos(unAnio));
    }

    private boolean multiplo(Integer unValor, Integer otroValor) {
        return unValor % otroValor == 0 || otroValor % unValor == 0;
    }

    private boolean anioBisiesto(Integer unAnio) {
        return (dosUltimosDigitos(unAnio) != 0) ? multiplo(dosUltimosDigitos(unAnio), 4): multiplo(dosUltimosDigitos(unAnio), 400);
    }

    private Integer coeficienteC(Integer unAnio, String unMes) {
        return (anioBisiesto(unAnio) && Arrays.asList("Enero", "Febrero", "1", "2").contains(unMes)) ? - 1 : 0;
    }

    private Integer obtenerValorString(Triplet<String,Integer,String> triplet) {
        return (Integer)triplet.getValue(1);
    }

    private Integer coeficienteD(String unMes) {
        List<Triplet<String,Integer,String>> mesesAux = new ArrayList<>();
        for(int i = 0 ; i < this.meses.size() ; i++) {
            if(Arrays.asList(this.meses.get(i).getValue(0), this.meses.get(i).getValue(2)).contains(unMes)) {
                mesesAux.add(this.meses.get(i));
            }
        }
        return obtenerValorString(mesesAux.get(0));
    }

    private Integer aplicarAlgoritmo(Integer unAnio, String unMes, Integer unDia) {
        return (coeficienteA(unAnio) + coeficienteB(unAnio) + coeficienteC(unAnio, unMes.toUpperCase()) +
                coeficienteD(unMes.toUpperCase()) + unDia) % 7;
    }

    private String obtenerCadena(Pair<String, Integer> tupla) {
        return (String)tupla.getValue(0);
    }

    public String calculoDeDia(Integer unAnio, String unMes, Integer unDia) {

        List<Pair<String, Integer>> diasAux = new ArrayList<>();

        for(int i = 0 ; i < this.dias.size() ; i++) {
            if(this.dias.get(i).getValue(1) == aplicarAlgoritmo(unAnio, unMes, unDia)) {
                diasAux.add(this.dias.get(i));
            }
        }
        return obtenerCadena(diasAux.get(0));
    }

}