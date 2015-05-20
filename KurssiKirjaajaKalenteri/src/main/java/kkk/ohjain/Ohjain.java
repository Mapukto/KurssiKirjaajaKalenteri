
package kkk.ohjain;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkk.io.Kirjoittaja;
import kkk.io.Lukija;
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
    static Lukija lukija;
    
    /**
     * 
     */
    public Ohjain() {
        kirjoittaja = new Kirjoittaja();
        lukija = new Lukija();
        kk = new KurssiKanta();
        laskin = new Laskin();
        
        lukija.lueKeskenOlevatKurssit();
        
        UI ui = new UI();
        ui.run();
    }

    public static void poistaKurssi(int index) {
        kk.poistaValmisKurssi(index);
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
    
    public static void teeKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        kk.lisaaKeskenOlevaKurssi(null);
    }
}
