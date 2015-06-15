package kkk.ui.uusikurssiui;

/**
 * Luokka mahdollistaa uuden valmiin kurssin luomisen validoinnin helposti.
 *
 * @author maot
 */
public class UusiValmisKurssiValidator {

    private final String nimi;
    private final String arvosana;
    private final int nopat;
    private final String suoritusAika;

    public UusiValmisKurssiValidator(String nimi, String arvosana, int nopat, String suoritusAika) throws Exception {
        this.nimi = nimi;
        this.arvosana = arvosana;
        this.nopat = nopat;
        this.suoritusAika = suoritusAika;
    }

    public void tarkastaInput() throws Exception {
        if (onkoArvosanaString()) {
            if (Integer.parseInt(arvosana) < 0) {
                throw new Exception("Arvosana ei saa olla negatiivinen");
            }
        }

        if (nimi.equals("")) {
            throw new Exception("Kurssin nimeä ei ole syötetty");
        }
        
        if (suoritusAika.equals("")) {
            throw new Exception("Kurssin suoritusaikaa ei ole syötetty");
        }
        
        if (arvosana.equals("")) {
            throw new Exception("Arvosanaa ei ole syötetty");
        }
    }

    private boolean onkoArvosanaString() {
        try {
            int n = Integer.parseInt(arvosana);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
