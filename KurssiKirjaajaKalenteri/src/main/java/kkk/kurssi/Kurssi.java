
package kkk.kurssi;

public class Kurssi {
    private int arvosana, suoritusPvm, nopat;
    private String nimi;
    private boolean onko;
    
    private void Kurssi(int pvm, int arvosana, String nimi, int nopat, boolean onkoKaynnissa) {
        this.arvosana = arvosana;
        this.nopat = nopat;
        this.nimi = nimi;
        this.suoritusPvm = pvm;
        this.onko = onkoKaynnissa;
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
