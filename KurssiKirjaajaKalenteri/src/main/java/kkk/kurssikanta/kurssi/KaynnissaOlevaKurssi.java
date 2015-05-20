package kkk.kurssikanta.kurssi;

import java.util.HashMap;


/**
 *
 * @author mopo
 */
public class KaynnissaOlevaKurssi extends Kurssi {
    private final AikaVaraus ajat;
    
    /**
     * 
     * @param nimi
     * @param ajat
     */
    public KaynnissaOlevaKurssi(String nimi, AikaVaraus ajat) {
        super(nimi);
        this.ajat = ajat;
    }
    
    public boolean onkoVarattu(int pva, int tunti) {
        return ajat.onkoVarattu(pva, tunti);
    }
    
    public AikaVaraus getAikaVaraukset() {
        return ajat;
    }
    /**
     *
     * @return palauttaa nimen
     */
    @Override
    public String getNimi() {
        return super.getNimi();
    }
}
