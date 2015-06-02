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
    private double ka;
    private int kaLaskettavatNopat;
    private int kurssitYht;
    private double painotettuKa;
    private int nopatYht;
    private int kaKurssitYht;

    public Laskin() {
        this.kurssit = Ohjain.getKurssit();
        this.kurssitYht = kurssit.size();
        this.kaLaskettavatNopat = laskeKaKaytettavatNopat();
        this.ka = laskeKa();
        this.painotettuKa = laskePainotettuKa();
        this.nopatYht = laskeNopat();
        this.kaKurssitYht = laskeKaKurssit();
    }
    
    public int getKurssitYht() {
        return kurssitYht;
    }

    public double getKa() {
        return ka;
    }

    public double getPainotettuKa() {
        return painotettuKa;
    }

    public int getNopat() {
        return nopatYht;
    }
    
    private int laskeKaKurssit() {
        int kurssiMaara = 0;
        
        for (ValmisKurssi k : kurssit) {
            if (!k.getArvosana().toLowerCase().equals("hyv")) kurssiMaara++;
        }
        
        return kurssiMaara;
    }
    
    private double laskePainotettuKa() {
        double pKa = 0;

        for (ValmisKurssi k : kurssit) {
            if (k.getArvosana().toLowerCase().equals("hyv")) continue;
            int potti = Integer.parseInt(k.getArvosana());
            potti *= k.getNopat();
            pKa += potti;
        }

        if (kaLaskettavatNopat != 0) {
            pKa /= kaLaskettavatNopat;
            return (double) Math.round(pKa * 10)/10;
        } else {
            return 0;
        }
    }

    private int laskeKaKaytettavatNopat() {
        int nopat = 0;
        for (ValmisKurssi k : kurssit) {
            if (k.getArvosana().toLowerCase().equals("hyv")) continue;
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
            if (k.getArvosana().toLowerCase().equals("hyv")) continue;
            keskiarvo += Integer.parseInt(k.getArvosana());
        }

        if (kaKurssitYht != 0) {
            keskiarvo /= kaKurssitYht;
            return (double) Math.round(keskiarvo*10)/10;
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
        this.kurssitYht = kurssit.size();
        this.kaLaskettavatNopat = laskeKaKaytettavatNopat();
        this.ka = laskeKa();
        this.painotettuKa = laskePainotettuKa();
        this.nopatYht = laskeNopat();
        this.kaKurssitYht = laskeKaKurssit();
        System.out.println(kaKurssitYht);
    }
}
