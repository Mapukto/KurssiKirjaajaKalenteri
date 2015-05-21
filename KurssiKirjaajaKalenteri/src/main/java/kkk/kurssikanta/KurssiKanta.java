package kkk.kurssikanta;

import java.util.ArrayList;
import java.util.List;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.Kurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;

/**
 *
 * @author mopo
 */
public class KurssiKanta {

    private final List<ValmisKurssi> valmiitKurssit;
    private final List<KaynnissaOlevaKurssi> keskenOlevatKurssit;
    
    
    /**
     * luonnin yhteydessä luetaan tallennetut kurssit tiedostosta ja täytetään
     * listat
     *
     */
    public KurssiKanta() {
        this.valmiitKurssit = new ArrayList<>();
        this.keskenOlevatKurssit = new ArrayList<>();
        lataaKurssit();
    }
    
    public List<ValmisKurssi> getValmiitKurssit() {
        return this.valmiitKurssit;
    }
    
    private void lataaKurssit() {
        this.valmiitKurssit.add(new ValmisKurssi("asd", 5, 5, "a"));
        this.valmiitKurssit.add(new ValmisKurssi("asd", 5, 5, "a"));
        this.valmiitKurssit.add(new ValmisKurssi("asd", 5, 5, "a"));
        this.valmiitKurssit.add(new ValmisKurssi("asd", 5, 5, "a"));
        this.valmiitKurssit.add(new ValmisKurssi("asd", 5, 5, "a"));
    }

    public void lisaaValmisKurssi(ValmisKurssi kurssi) {
        valmiitKurssit.add(kurssi);
    }
    
    public void lisaaKeskenOlevaKurssi(KaynnissaOlevaKurssi kurssi) {
        keskenOlevatKurssit.add(kurssi);
    }
    
    public void poistaValmisKurssi(int index) {
        valmiitKurssit.remove(index);
    }
    
    public void poistaKeskenOlevaKurssi(int index) {
        keskenOlevatKurssit.remove(index);
    }
    
    public void poistaKaikkiKeskenOlevatKurssit() {
        keskenOlevatKurssit.clear();
    }
    
    
    
    
    /**
     * testejä varten tehty konstruktori. teen järkevämmät testit heti kun opettelen
     * miten mockito toimii!
     */
    public KurssiKanta(List<KaynnissaOlevaKurssi> kesken, List<ValmisKurssi> valmiit) {
        this.keskenOlevatKurssit = kesken;
        this.valmiitKurssit = valmiit;
    }
}
