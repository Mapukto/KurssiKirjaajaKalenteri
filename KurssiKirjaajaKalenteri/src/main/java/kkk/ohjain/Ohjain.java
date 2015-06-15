
package kkk.ohjain;

import java.util.List;
import javax.swing.SwingUtilities;
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
public final class Ohjain {
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

        lueKurssit();
    }
    
    public void run() {
        UI ui = new UI();
        SwingUtilities.invokeLater(ui);
    }
    
    public static void tyhjennaKalenteri() {
        kk.poistaKaikkiKeskenOlevatKurssit();
        kirjoittaja.tyhjennaKalenteri();
        UI.luoKalenteriNakyma();
    }
    
    public static void lueKurssit() {
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
    
    public static List getKEKurssit() {
        return kk.getKaynnissaOlevatKurssit();
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
