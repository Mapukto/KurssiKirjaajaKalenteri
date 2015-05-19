/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkk.laskin;

import java.util.ArrayList;
import java.util.List;
import kkk.kurssikanta.kurssi.Kurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
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
public class LaskinTest {

    Laskin laskin;

    @Before
    public void setUp() {
        List<ValmisKurssi> kurssit = new ArrayList<>();

        kurssit.add(new ValmisKurssi("testiKurssi", 1, 5, 1));
        kurssit.add(new ValmisKurssi("testiKurssi2", 2, 5, 1));
        kurssit.add(new ValmisKurssi("testiKurssi3", 3, 5, 1));
        kurssit.add(new ValmisKurssi("testiKurssi3", 3, 1, 1));

        laskin = new Laskin(kurssit);
    }

    @Test
    public void kaLasketaanOikein() {
        assertEquals(2.25, laskin.getKa(), 0.1);
    }
    
    @Test
    public void pKaLasketaanOikein() {
        assertEquals(2.1, laskin.getPainotettuKa(), 0.1);
    }
    
    @Test
    public void nopatLasketaanOikein() {
        assertEquals(16, laskin.getNopat());
    }
    
    @Test
    public void kurssienKokonaisMaaraLasketaanOikein() {
        assertEquals(4, laskin.getKurssitYht());
    }
}
