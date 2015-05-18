
package kkk.kurssikanta;


/**
 *
 * @author mopo
 */
public class ValmisKurssi extends Kurssi {
    private final int nopat;

    public ValmisKurssi(String nimi, int nopat) {
        super(nimi);
        this.nopat = nopat;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + this.nopat;
    }

}
