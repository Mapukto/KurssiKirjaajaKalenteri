package kkk.kurssikanta;

import java.util.ArrayList;
import java.util.List;
import kkk.kurssikanta.kurssi.Kurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;

/**
 *
 * @author mopo
 */
public class KurssiKanta {

    private final List<Kurssi> kurssiLista;
    private final List<Kurssi> keskenOlevat;
    
    
    /**
     * luonnin yhteydessä luetaan tallennetut kurssit tiedostosta ja täytetään
     * listat
     *
     */
    public KurssiKanta() {
        this.kurssiLista = new ArrayList<>();
        this.keskenOlevat = new ArrayList<>();
        lataaKurssit();
    }
    
    public List<Kurssi> getValmiitKurssit() {
        return this.kurssiLista;
    }
    
    private void lataaKurssit() {
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
        this.kurssiLista.add(new ValmisKurssi("asd", 5, 5, 05122015));
    }

    public void lisaaValmisKurssi(Kurssi kurssi) {
        kurssiLista.add(kurssi);
    }
    
    public void lisaaKeskenOlevaKurssi(Kurssi kurssi) {
        keskenOlevat.add(kurssi);
    }
    
    public void poistaValmisKurssi(int index) {
        kurssiLista.remove(index);
    }
    
    public void poistaKeskenOlevaKurssi(int index) {
        keskenOlevat.remove(index);
    }
    
    public void poistaKaikkiKeskenOlevatKurssit() {
        keskenOlevat.clear();
    }
}
