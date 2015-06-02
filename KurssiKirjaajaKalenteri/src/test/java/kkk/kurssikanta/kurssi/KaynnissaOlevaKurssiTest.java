
package kkk.kurssikanta.kurssi;

import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.Kurssi;
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
public class KaynnissaOlevaKurssiTest {
    KaynnissaOlevaKurssi k;

    @Before
    public void setUp() {
        String[] päivät = {"maanantai"};
        String[] ajat = {"10-12"};
        
        k = new KaynnissaOlevaKurssi("kurssi1", "k1", new AikaVaraus(päivät, ajat));
    }
    
    @Test
    public void nimiTulostuuOikein() {
        assertEquals("kurssi1", k.getNimi());
    }
    
    @Test
    public void palauttaaAikaVarauksen() {
        String[] x = {};
        String[] y = {};
        
        AikaVaraus verrokki = new AikaVaraus(x,y);
        
        assertEquals(verrokki.getClass(), k.getAikaVaraukset().getClass());
    }
    
    /**
     * tämä on jo testattu AikaVarausTestissä, joten hyvin lyhyt testi
     */
    @Test
    public void aikaVarausToimii() {
        assertEquals(true, k.onkoVarattu(1, 10));
    }
}
