
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
import kkk.kurssikanta.kurssi.ValmisKurssi;
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
     * Ohjelman alustus käynnistyksessä. Luodaan Kirjoittaja, Lukija, KurssiKanta ja Laskin.
     * Kun kaikki on luotu, luetaan tiedostoon tallennetut kurssit ja käynnistetään UI.
     */
    public Ohjain() {
        kirjoittaja = new Kirjoittaja();
        lukija = new Lukija();
        kk = new KurssiKanta();
        laskin = new Laskin();
        
        lueKurssit();
    }
    
    public void run() {
        UI ui = new UI();
        ui.run();
    }
    
    private static void lueKurssit() {
        lukija.lueKeskenOlevatKurssit();
        lukija.lueValmiitKurssit();
    }

    public static void poistaValmisKurssi(int index) {
        kk.poistaValmisKurssi(index);
        kirjoittaja.poistaKurssi(index);
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
    
    public static void teeKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        kk.lisaaKeskenOlevaKurssi(null);
    }
    
    public static void tallennaTiedostostaValmisKurssi(ValmisKurssi kurssi) {
        kk.lisaaValmisKurssi(kurssi);
    }
    
    public static void teeValmisKurssi(ValmisKurssi kurssi) {
        kk.lisaaValmisKurssi(kurssi);
        kirjoittaja.tallennaValmisKurssi(kurssi);
    }
    
    
}
