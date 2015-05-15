
package kkk.ohjain;

import kkk.kurssikanta.KurssiKanta;
import kkk.ui.UI;


/**
 *
 * @author mopo
 */
public class Ohjain {
    KurssiKanta kk;
    
    public Ohjain() {
        this.kk = new KurssiKanta();
        UI ui = new UI();
        ui.run();
    }
    
}
