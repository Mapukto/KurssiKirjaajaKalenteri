
package kkk.ohjain;

import java.util.List;
import kkk.io.Kirjoittaja;
import kkk.io.Lukija;
import kkk.kurssikanta.KurssiKanta;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ui.UI;


/**
 *
 * @author mopo
 */
public class Ohjain {
    static KurssiKanta kk;
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
        
//        String[] pva = {"maanantai", "tiistai", "keskiviikko", "perjantai"};
//        String[] ajat = {"9-10", "12-14", "14-16", "17-18"};
//        
//        kk.lisaaKeskenOlevaKurssi(new KaynnissaOlevaKurssi("Ohjelmistotekniikan menetelmät", "OTM", new AikaVaraus(pva, ajat)));
        
        lueKurssit();
    }
    
    public void run() {
        UI ui = new UI();
        ui.run();
    }
    
    public static void tyhjennaKalenteri() {
        kk.poistaKaikkiKeskenOlevatKurssit();
        kirjoittaja.tyhjennaKalenteri();
        UI.luoKalenteriNakyma();
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
        kk.lisaaKeskenOlevaKurssi(kurssi);
        kirjoittaja.tallennaKeskenErainenKurssi(kurssi);
    }
    
    public static void tallennaTiedostostaKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        kk.lisaaKeskenOlevaKurssi(kurssi);
    }
    
    public static void tallennaTiedostostaValmisKurssi(ValmisKurssi kurssi) {
        kk.lisaaValmisKurssi(kurssi);
    }
    
    public static void teeValmisKurssi(ValmisKurssi kurssi) {
        kk.lisaaValmisKurssi(kurssi);
        kirjoittaja.tallennaValmisKurssi(kurssi);
    }
    
    public static KaynnissaOlevaKurssi onkoVarattu(int pva, int tunti) {
        return kk.onkoVarattu(pva, tunti);
    }
}
