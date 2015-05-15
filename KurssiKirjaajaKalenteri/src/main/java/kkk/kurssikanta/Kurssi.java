
package kkk.kurssikanta;

public class Kurssi {
    private final String nimi;
    private final int nopat;
    
    public Kurssi(String nimi, int nopat) {
        this.nimi = nimi;
        this.nopat = nopat;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getNopat() {
        return this.nopat;
    }
}
