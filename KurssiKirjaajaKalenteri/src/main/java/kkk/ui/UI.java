
package kkk.ui;

import java.awt.*;
import javax.swing.*;
import kkk.ui.kalenteriui.KalenteriUI;
import kkk.ui.listaui.KurssitUI;

/**
 *
 * @author mopo
 */

public class UI implements Runnable {

    private static JFrame frame;
//    private JPanel panel;
    private static Container c;

    
    /**
     * luodaan frame ja etusivuksi kalenterinÃ¤kymÃ¤
     */
    @Override
    public void run() {
        frame = new JFrame("KurssiKirjaajaKalenteri KKK");
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        luoAlkunäkymä();
//        luoKurssiNakyma();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * luo kalenterinÃ¤kymÃ¤n
     */
    private static void luoAlkunäkymä() {
        c.setLayout(new FlowLayout());
        
        KalenteriUI alkuruutu = new KalenteriUI();
        
        c.add(alkuruutu);
    }
    
    /**
     * luo kurssinÃ¤kymÃ¤n
     */
    public static void luoKurssiNakyma() {
        KurssitUI kurssiUI = new KurssitUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(kurssiUI);
        
        c.validate();
    }
}
