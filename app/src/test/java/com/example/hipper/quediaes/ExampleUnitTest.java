package com.example.hipper.quediaes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testEsDecimal() {
        Funciones funciones = new Funciones();
        assertTrue(funciones.esUnNumeroDecimal("9"));
        assertFalse(funciones.esUnNumeroDecimal("1f1hc"));
    }
}