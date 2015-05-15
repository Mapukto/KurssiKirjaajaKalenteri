
package kkk.ui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mopo
 */

public class UI implements Runnable {

    JFrame frame;
//    private JPanel panel;
    private static Container c;

    
    /**
     * luodaan frame ja etusivuksi kalenterinäkymä
     */
    @Override
    public void run() {
        frame = new JFrame("KurssiKirjaajaKalenteri KKK");
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        luoKalenteriNakyma();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * luo kalenterinäkymän
     */
    private void luoKalenteriNakyma() {
        c.setLayout(new FlowLayout());
        
        KalenteriUI alkuruutu = new KalenteriUI();
        
        c.add(alkuruutu);
    }
    
    /**
     * luo kurssinäkymän
     */
    public static void luoKurssiNakyma() {
        c.removeAll();
        c.repaint();
    }


//    private Component napitUI() {
//        
//    }
    
    
}
