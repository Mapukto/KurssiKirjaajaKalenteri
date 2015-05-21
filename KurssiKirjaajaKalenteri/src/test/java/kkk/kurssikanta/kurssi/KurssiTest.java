/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkk.kurssikanta.kurssi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mopo
 */
public class KurssiTest {
    Kurssi k;
    
    @Before
    public void setUp() {
        k = new Kurssi("javaLabra");
    }
    
    @Test
    public void getNimiToimii() {
        assertEquals("javaLabra", k.getNimi());
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("javaLabra", k.toString());
    }
}
