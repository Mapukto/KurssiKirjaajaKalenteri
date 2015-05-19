
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
        kk = new KurssiKanta();
        laskin = new Laskin();
        UI ui = new UI();
        ui.run();
    }

    public static void poistaKurssi(int index) {
        kk.poistaValmisKurssi(index);
    }
    
    public static List getKurssit() {
        return kk.getValmiitKurssit();
    }
}
