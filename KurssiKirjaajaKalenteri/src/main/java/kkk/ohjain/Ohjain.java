
package kkk.ohjain;

import java.util.List;
import kkk.kurssikanta.Kurssi;
import kkk.kurssikanta.KurssiKanta;
import kkk.ui.UI;


/**
 *
 * @author mopo
 */
public class Ohjain {
    static KurssiKanta kk;

    public static void poistaKurssi(int index) {
        kk.poistaKurssi(index);
    }
    
    public Ohjain() {
        kk = new KurssiKanta();
        UI ui = new UI();
        ui.run();
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
}
