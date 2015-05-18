
package kkk.kurssikanta.kurssi;

public class Kurssi {
    private final String nimi;
    
    public Kurssi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    @Override
    public String toString() {
        return this.nimi;
    }
}
