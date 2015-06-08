/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkk.kurssikanta.kurssi;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author mopo
 */
public class ValmisKurssiTest {
    ValmisKurssi k;
    
    @Before
    public void setUp() {
        k = new ValmisKurssi("javaLabra", "3",5,"a");
    }
    
    @Test
    public void getteritToimii() {
        assertEquals("javaLabra", k.getNimi());
        assertEquals(5, k.getNopat());
        assertEquals("3", k.getArvosana());
    }
    
    @Test
    public void suoritusAikaToimii() {
        assertEquals("a", k.getSuoritusAika());
    }
    
    @Test
    public void toStringToimii() {
        String tulos = String.format("%-45s %-15s %-15s %-10s", "javaLabra", "3", "5", "a");
        assertEquals(k.toString(), tulos);
    }
}
