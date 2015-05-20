
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
    Kurssi k;

    @Before
    public void setUp() {
        String[] päivät = {"ma","ti","ke"};
        String[] ajat = {"10-12","14-16","12-14"};
        
        k = new KaynnissaOlevaKurssi("kurssi1", new AikaVaraus(päivät, ajat));
    }
    
    
}
