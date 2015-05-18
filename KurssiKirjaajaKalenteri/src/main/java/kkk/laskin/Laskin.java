
package kkk.laskin;

import java.util.List;
import kkk.kurssikanta.ValmisKurssi;
import kkk.ohjain.Ohjain;

/**
 *
 * @author mopo
 */
public class Laskin {
    private final List<ValmisKurssi> kurssit;
    private int ka;
    private int nopatYht;
    private int kurssitYht;
    private int painotettuKa;
    
    public Laskin() {
        this.kurssit = Ohjain.getKurssit();
        this.kurssitYht = kurssit.size();
        laskeKa();
        laskeNopat();
        laskePKa();
    }
    
    public int getKa() {
        return ka;
    }
    
    public int getPainotettuKa() {
        return painotettuKa;
    }
    
    public int getNopat() {
        return nopatYht;
    }
    
    private void laskePKa() {
        int pKa = 0;
        
        for (ValmisKurssi k : kurssit) {
            int potti = k.getArvosana();
            potti *= k.getNopat();
            pKa += potti;
        }
        
        pKa /= nopatYht;
        this.nopatYht = pKa;
    }
    
    private void laskeNopat() {
        int nopat = 0;
        for (ValmisKurssi k : kurssit) {
            nopat += k.getNopat();
        }
        nopatYht = nopat;
    }
    
    private void laskeKa() {
        int arvosanatYht = 0;
        
        for (ValmisKurssi k : kurssit) {
            arvosanatYht += k.getArvosana();
        }
        
        arvosanatYht /= kurssitYht;
        this.ka = arvosanatYht;
    }
}
