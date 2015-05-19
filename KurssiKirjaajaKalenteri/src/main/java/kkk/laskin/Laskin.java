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
    private int nopatYht;
    private int kurssitYht;
    private double painotettuKa;

    public Laskin() {
        this.kurssit = Ohjain.getKurssit();
        this.kurssitYht = kurssit.size();
        this.nopatYht = laskeNopat();
        this.ka = laskeKa();
        this.painotettuKa = laskePainotettuKa();
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

    private double laskePainotettuKa() {
        double pKa = 0;

        for (ValmisKurssi k : kurssit) {
            int potti = k.getArvosana();
            potti *= k.getNopat();
            pKa += potti;
        }

        if (nopatYht != 0) {
            pKa /= nopatYht;
            return (double) Math.round(pKa * 10)/10;
        } else {
            return 0;
        }
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
            keskiarvo += k.getArvosana();   
        }

        if (kurssitYht != 0) {
            keskiarvo /= kurssitYht;
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
        this.ka = laskeKa();
        this.nopatYht = laskeNopat();
        this.painotettuKa = laskePainotettuKa();
    }
}
