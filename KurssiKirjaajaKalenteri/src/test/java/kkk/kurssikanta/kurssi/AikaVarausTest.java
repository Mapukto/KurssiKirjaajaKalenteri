
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
public class AikaVarausTest {
    AikaVaraus av;
    
    @Before
    public void setUp() {
        String[] pvat = {"maanantai", "tiistai", "keskiviikko", "perjantai"};
        String[] ajat = {"9-10", "12-14", "14-16", "17-18"};
        
        av = new AikaVaraus(pvat, ajat);
    }

    @Test
    public void aikaVarautuuOikein() {
        assertEquals(true, av.onkoVarattu(1, 9));
        
        assertEquals(true, av.onkoVarattu(2, 12));        
        assertEquals(true, av.onkoVarattu(2, 13));
        
        assertEquals(true, av.onkoVarattu(3, 14));
        assertEquals(true, av.onkoVarattu(3, 15));
        
        assertEquals(true, av.onkoVarattu(5, 17));
    }
    
    
}
