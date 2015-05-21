
package kkk.kurssikanta;

import java.util.ArrayList;
import java.util.List;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssiTest;
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
public class KurssiKantaTest {
    KurssiKanta kk;

    @Before
    public void setUp() {
        List<ValmisKurssi> valmiit = new ArrayList<>();
        List<KaynnissaOlevaKurssi> keskenEraiset = new ArrayList<>();
        
        String[] pvat = {"ma", "ti", "ke", "pe"};
        String[] ajat = {"9-10", "12-14", "14-16", "17-18"};
        
        keskenEraiset.add(new KaynnissaOlevaKurssi("javaLabra", new AikaVaraus(pvat, ajat)));
        valmiit.add(new ValmisKurssi("javaLabra", 5, 5, "a"));
        
        kk = new KurssiKanta(keskenEraiset, valmiit);
    }

    //TODO
    
}
