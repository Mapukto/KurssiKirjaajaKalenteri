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
    List<ValmisKurssi> valmiit;
    List<KaynnissaOlevaKurssi> keskenEraiset;

    @Before
    public void setUp() {
        valmiit = new ArrayList<>();
        keskenEraiset = new ArrayList<>();

        String[] pvat = {"1", "2", "3", "4", "5"};
        String[] ajat = {"9-10", "12-14", "14-16", "17-18", "9-19"};

        keskenEraiset.add(new KaynnissaOlevaKurssi("javaLabra", "JL", new AikaVaraus(pvat, ajat)));
        valmiit.add(new ValmisKurssi("javaLabra", "5", 5, "a"));

        kk = new KurssiKanta(keskenEraiset, valmiit);
    }

    @Test
    public void getteriToimii() {
        assertEquals(kk.getValmiitKurssit().getClass(), valmiit.getClass());
        assertEquals(kk.getKaynnissaOlevatKurssit().getClass(), valmiit.getClass());
    }

    @Test
    public void onkoVarattuToimii() {
        assertEquals(kk.onkoVarattu(1, 9).getNickName(), "JL");

        assertEquals(kk.onkoVarattu(2, 12).getNickName(), "JL");
        assertEquals(kk.onkoVarattu(2, 13).getNickName(), "JL");

        assertEquals(kk.onkoVarattu(3, 14).getNickName(), "JL");
        assertEquals(kk.onkoVarattu(3, 15).getNickName(), "JL");

        assertEquals(kk.onkoVarattu(4, 17).getNickName(), "JL");

        assertEquals(kk.onkoVarattu(5, 9).getNickName(), "JL");
        assertEquals(kk.onkoVarattu(5, 16).getNickName(), "JL");
        assertEquals(kk.onkoVarattu(5, 18).getNickName(), "JL");
        
        assertEquals(kk.onkoVarattu(1, 15), null);
    }
    
    @Test
    public void kurssienLisaysToimii() {
        kk.lisaaValmisKurssi(new ValmisKurssi("ohtu", "ohtu", 5, "a"));
        
        String[] pvat = {"1"};
        String[] ajat = {"9-10"};
        kk.lisaaKeskenOlevaKurssi(new KaynnissaOlevaKurssi("ohtu", "ohtu", new AikaVaraus(pvat, ajat)));
        
        assertEquals(kk.getValmiitKurssit().size(), 2);
        assertEquals(kk.getKaynnissaOlevatKurssit().size(), 2);
    }
    
    @Test
    public void kurssienPoistoToimii() {
        kk.poistaKeskenOlevaKurssi(0);
        kk.poistaValmisKurssi(0);
        
        assertEquals(kk.getValmiitKurssit().size(), 0);
        assertEquals(kk.getKaynnissaOlevatKurssit().size(), 0);
    }
    
    @Test
    public void kaikkienPoistoToimii(){
        kk.poistaKaikkiKeskenOlevatKurssit();
        
        assertEquals(kk.getKaynnissaOlevatKurssit().size(), 0);
    }
    
    @Test
    public void oikeaKonstruktoriToimii() {
        KurssiKanta kk2 = new KurssiKanta();
    }
}
