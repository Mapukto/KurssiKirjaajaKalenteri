
package kkk.ohjain;

import java.util.List;
import kkk.kurssikanta.KurssiKanta;
import kkk.laskin.Laskin;
import kkk.ui.UI;


/**
 *
 * @author mopo
 */
public class Ohjain {
    static KurssiKanta kk;
    static Laskin laskin;
    
    /**
     * 
     */
    public Ohjain() {
        laskin = new Laskin();
        kk = new KurssiKanta();
        UI ui = new UI();
        ui.run();
    }

    public static void poistaKurssi(int index) {
        kk.poistaKurssi(index);
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
}
