
package kurssi;

public class Kurssi {
    private int arvosana, suoritusPvm, nopat;
    private String nimi;
    
    private void Kurssi(int pvm, int arvosana, String nimi, int nopat) {
        this.arvosana = arvosana;
        this.nopat = nopat;
        this.nimi = nimi;
        this.suoritusPvm = pvm;
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
