
package kkk.kurssikanta.kurssi;


/**
 *
 * @author mopo
 */
public class ValmisKurssi extends Kurssi {
    private final int nopat;
    private final int arvosana;
//    private final int suoritusPvm;

    public ValmisKurssi(String nimi, int arvosana, int nopat) {
        super(nimi);
        this.nopat = nopat;
        this.arvosana = arvosana;
//        this.suoritusPvm = suoritusPvm;
    }
    
    public int getArvosana() {
        return arvosana;
    }
    
    public int getNopat() {
        return nopat;
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
        return super.toString() + "    " + this.nopat + "    " + this.arvosana;
    }

}
