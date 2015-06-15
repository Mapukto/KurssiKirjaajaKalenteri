
package kkk.kurssikanta;

import java.util.List;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.ohjain.Ohjain;

/**
 * Luokka auttaa hallitsemaan kursseja jakson vaihdon aikana.
 * @author maot
 */
public class JaksonVaihtoController {
    private final List<KaynnissaOlevaKurssi> kaynnissaOlevatKurssit;
    
    public JaksonVaihtoController() {
        kaynnissaOlevatKurssit = Ohjain.getKEKurssit();
    }
    
    public KaynnissaOlevaKurssi getKurssi(int index) {
        return kaynnissaOlevatKurssit.get(index);
    }
    
    public int getListanKoko() {
        return kaynnissaOlevatKurssit.size();
    }
}
