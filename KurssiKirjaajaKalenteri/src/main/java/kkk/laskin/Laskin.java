package kkk.laskin;

import java.util.List;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;

/**
 *
 * @author mopo
 */
public class Laskin {

    private List<ValmisKurssi> kurssit;

    public Laskin() {
        this.kurssit = Ohjain.getKurssit();
    }
    
    public int getKurssitYht() {
        return kurssit.size();
    }

    public double getKa() {
        return laskeKa();
    }

    public double getPainotettuKa() {
        return laskePainotettuKa();
    }

    public int getNopat() {
        return laskeNopat();
    }
    
    private boolean arvosanaOnString(String arvosana) {
        try {
            Integer.parseInt(arvosana);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    
    private int laskeKeskiarvossaKaytettavatKurssit() {
        int kurssiMaara = 0;
        
        for (ValmisKurssi k : kurssit) {
            if (!arvosanaOnString(k.getArvosana())) kurssiMaara++;
        }
        
        return kurssiMaara;
    }
    
    private double laskePainotettuKa() {
        double pKa = 0;

        for (ValmisKurssi k : kurssit) {
            if (arvosanaOnString(k.getArvosana())) continue;
            int potti = Integer.parseInt(k.getArvosana());
            potti *= k.getNopat();
            pKa += potti;
        }
        
        int kaLaskettavatNopat = laskeKaKaytettavatNopat();

        if (kaLaskettavatNopat != 0) {
            pKa /= kaLaskettavatNopat;
            return (double) Math.round(pKa * 10) / 10;
        } else {
            return 0;
        }
    }

    private int laskeKaKaytettavatNopat() {
        int nopat = 0;
        for (ValmisKurssi k : kurssit) {
            if (arvosanaOnString(k.getArvosana())) continue;
            nopat += k.getNopat();
        }
        return nopat;
    }
    
    private int laskeNopat() {
        int nopat = 0;
        for (ValmisKurssi k : kurssit) {
            nopat += k.getNopat();
        }
        return nopat;
    }

    private double laskeKa() {
        double keskiarvo = 0.0;

        for (ValmisKurssi k : kurssit) {
            if (arvosanaOnString(k.getArvosana())) continue;
            keskiarvo += Integer.parseInt(k.getArvosana());
        }
        
        int kaKurssitYht = laskeKeskiarvossaKaytettavatKurssit();
        
        if (kaKurssitYht != 0) {
            keskiarvo /= kaKurssitYht;
            return (double) Math.round(keskiarvo * 10) / 10;
        } else {
            return 0;
        }
    }
    
    
    
    
    /**
     * konstruktori testejÃ¤ varten
     * @param paramKurssit 
     */
    public Laskin(List<ValmisKurssi> paramKurssit) {
        this.kurssit = paramKurssit;
    }
}
