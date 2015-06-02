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
    private List<ValmisKurssi> kurssit;
    private int kurssitYht;
    private double ka;
    private int nopatYht;
    private double painotettuKa;

    @Before
    public void setUp() {
        
        List<ValmisKurssi> kurssiLista = new ArrayList<>();

        kurssiLista.add(new ValmisKurssi("testiKurssi", "1", 5, "a"));
        kurssiLista.add(new ValmisKurssi("testiKurssi2", "2", 5, "a"));
        kurssiLista.add(new ValmisKurssi("testiKurssi3", "3", 5, "a"));
        kurssiLista.add(new ValmisKurssi("testiKurssi4", "3", 1, "a"));
        kurssiLista.add(new ValmisKurssi("testiKurssi5", "hyv", 1, "a"));

        laskin = new Laskin(kurssiLista);
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
        assertEquals(17, laskin.getNopat());
    }
    
    @Test
    public void kurssienKokonaisMaaraLasketaanOikein() {
        assertEquals(5, laskin.getKurssitYht());
    }
    
    @Test
    public void kaPalauttaaNollanJosListaOnTyhja() {
        List<ValmisKurssi> kurssiLista = new ArrayList<>();
        
        Laskin  tyhjaLaskin = new Laskin(kurssiLista);
        
        assertEquals(0, tyhjaLaskin.getKa(), 0.1);
    }
    
    @Test
    public void painotettuKaPalauttaaNollanJosListaOnTyhja() {
        List<ValmisKurssi> kurssiLista = new ArrayList<>();
        
        Laskin  tyhjaLaskin = new Laskin(kurssiLista);
        
        assertEquals(0, tyhjaLaskin.getPainotettuKa(), 0.1);
    }
}


