
package kkk.ohjain;

import java.util.List;
import kkk.io.Kirjoittaja;
import kkk.kurssikanta.KurssiKanta;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.laskin.Laskin;
import kkk.ui.UI;


/**
 *
 * @author mopo
 */
public class Ohjain {
    static KurssiKanta kk;
    static Laskin laskin;
    static Kirjoittaja kirjoittaja;
    
    /**
     * 
     */
    public Ohjain() {
        kirjoittaja = new Kirjoittaja();
        kk = new KurssiKanta();
        laskin = new Laskin();
        UI ui = new UI();
        ui.run();
        
        String[] k = {"ma", "ti"};
        String[] p = {"10-12", "9-10"};
        KaynnissaOlevaKurssi kok = new KaynnissaOlevaKurssi("kakka", new AikaVaraus(k,p));
        kirjoittaja.tallennaKeskenErainenKurssi(kok);
    }

    public static void poistaKurssi(int index) {
        kk.poistaValmisKurssi(index);
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
}
