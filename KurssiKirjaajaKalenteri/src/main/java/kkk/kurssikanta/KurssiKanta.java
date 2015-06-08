package kkk.kurssikanta;

import java.util.ArrayList;
import java.util.List;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.Kurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;

/**
 *
 * @author mopo
 */
public final class KurssiKanta {
    private final List<ValmisKurssi> valmiitKurssit;
    private final List<KaynnissaOlevaKurssi> kaynnissaOlevatKurssit;
    
    
    /**
     * luonnin yhteydessä luetaan tallennetut kurssit tiedostosta ja täytetään
     * listat
     *
     */
    public KurssiKanta() {
        this.valmiitKurssit = new ArrayList<>();
        this.kaynnissaOlevatKurssit = new ArrayList<>();
    }
    
    public List<ValmisKurssi> getValmiitKurssit() {
        return this.valmiitKurssit;
    }
    
    public List<KaynnissaOlevaKurssi> getKaynnissaOlevatKurssit() {
        return kaynnissaOlevatKurssit;
    }
    
    public KaynnissaOlevaKurssi onkoVarattu(int pva, int tunti) {
        for (KaynnissaOlevaKurssi k : kaynnissaOlevatKurssit) {
            if (k.onkoVarattu(pva, tunti)) return k;
        }
        return null;
    }
    
    
    
    
    
    
    
    /**
     * "tietokantaa" muokkaavat metodit
     * @param kurssi 
     */
    public void lisaaValmisKurssi(ValmisKurssi kurssi) {
        valmiitKurssit.add(kurssi);
    }
    
    public void lisaaKeskenOlevaKurssi(KaynnissaOlevaKurssi kurssi) {
        kaynnissaOlevatKurssit.add(kurssi);
    }
    
    public void poistaValmisKurssi(int index) {
        valmiitKurssit.remove(index);
    }
    
    public void poistaKeskenOlevaKurssi(int index) {
        kaynnissaOlevatKurssit.remove(index);
    }
    
    public void poistaKaikkiKeskenOlevatKurssit() {
        kaynnissaOlevatKurssit.clear();
    }
    
    
    
    
    /**
     * testejä varten tehty konstruktori. teen järkevämmät testit heti kun opettelen
     * miten mockito toimii!
     */
    public KurssiKanta(List<KaynnissaOlevaKurssi> kesken, List<ValmisKurssi> valmiit) {
        this.kaynnissaOlevatKurssit = kesken;
        this.valmiitKurssit = valmiit;
    }
}
