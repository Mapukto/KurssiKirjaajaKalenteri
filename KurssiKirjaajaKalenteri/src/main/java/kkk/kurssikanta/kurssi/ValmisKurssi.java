
package kkk.kurssikanta.kurssi;


/**
 *
 * @author mopo
 */
public class ValmisKurssi extends Kurssi {
    private final int nopat;
    private final int arvosana;
    private final String suoritusAika;

    public ValmisKurssi(String nimi, int arvosana, int nopat, String suoritusAika) {
        super(nimi);
        this.nopat = nopat;
        this.arvosana = arvosana;
        this.suoritusAika = suoritusAika;
    }
    
    public int getArvosana() {
        return arvosana;
    }
    
    public int getNopat() {
        return nopat;
    }
    
    public String getSuoritusAika() {
        return this.suoritusAika;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getNimi() {
        return super.getNimi();
    }
    /**
     * TODO
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + " " + this.arvosana + " " + this.nopat + " " + this.suoritusAika;
    }

}
