
package kkk.kurssikanta.kurssi;


/**
 * ValmisKurssi on suoritettu ja arvosteltu, valmis.
 * @author mopo
 */
public class ValmisKurssi extends Kurssi {
    private final int nopat;
    private final String arvosana;
    private final String suoritusAika;

    public ValmisKurssi(String nimi, String arvosana, int nopat, String suoritusAika) {
        super(nimi);
        this.nopat = nopat;
        this.arvosana = arvosana;
        this.suoritusAika = suoritusAika;
    }
    
    public String getArvosana() {
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
    
    StringBuilder ret;
    
    /**
     * Metodi luo kurssista vakiomuotoisen String esityksen.
     * kurssilistan pituus 145 char. Oikean laidan marginaali 20char. arvosanan ja noppien välissä 40 char.
     * nimeen varattu 65char. nimen ja arvosanan väliin varattu 20char.
     * @return 
     */
    @Override
    public String toString() {
        String tulos = String.format("%-45s %-15s %-15s %-10s", super.getNimi(), this.arvosana, Integer.toString(this.nopat), this.suoritusAika);
        return tulos;
    }
}
