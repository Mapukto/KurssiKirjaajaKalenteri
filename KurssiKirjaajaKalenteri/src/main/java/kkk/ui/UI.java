
package kkk.ui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mopo
 */

public class UI implements Runnable {
    JFrame frame;
    JPanel panel;

    @Override
    public void run() {
        frame = new JFrame("KurssiKirjaajaKalenteri KKK");
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new FlowLayout());
        
        KalenteriUI alkuruutu = new KalenteriUI();
        
        container.add(alkuruutu);
    }



//    private Component napitUI() {
//        
//    }
    
    
}
