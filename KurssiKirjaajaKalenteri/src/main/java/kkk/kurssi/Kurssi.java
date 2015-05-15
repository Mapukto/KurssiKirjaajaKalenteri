
package kkk.kurssi;

/**
 *
 * @author mopo
 */
public class Kurssi {
    private final int arvosana, suoritusPvm, nopat;
    private final String nimi;
    private final boolean onko;
    
    private Kurssi(int pvm, int arvosana, String nimi, int nopat, boolean onkoKaynnissa) {
        this.arvosana = arvosana;
        this.nopat = nopat;
        this.nimi = nimi;
        this.suoritusPvm = pvm;
        this.onko = onkoKaynnissa;
    }

    public int getArvosana() {
        return arvosana;
    }

    public int getSuoritusPvm() {
        return suoritusPvm;
    }

    public int getNopat() {
        return nopat;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public boolean onkoVarattu() {
        return onko;
    }
}
