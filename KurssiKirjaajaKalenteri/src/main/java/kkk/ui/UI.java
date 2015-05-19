
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
    private static Container c;

    
    /**
     * luodaan frame ja etusivuksi kalenterinÃ¤kymÃ¤
     */
    @Override
    public void run() {
        frame = new JFrame("KurssiKirjaajaKalenteri KKK");
        frame.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        luoAlkunäkymä();
//        luoKurssiNakyma();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * luo kalenterinäkymän
     */
    private static void luoAlkunäkymä() {
        c.setLayout(new FlowLayout());
        
        KalenteriUI alkuruutu = new KalenteriUI();
        
        c.add(alkuruutu);
    }
    
    /**
     * 
     */
    public static void luoKurssiNakyma() {
        c.setLayout(new BorderLayout());
        KurssitUI kurssiUI = new KurssitUI();
        
        tyhjennaRuutu();
        
        c.add(kurssiUI);
        
        c.validate();
        frame.pack();
    }
    
    public static void luoKalenteriNakyma() {
        c.setLayout(new FlowLayout());
        KalenteriUI kalenteri = new KalenteriUI();
        
        tyhjennaRuutu();
        
        c.add(kalenteri);
        
        c.validate();
        frame.pack();
    }
    
    public static void tyhjennaRuutu() {
        c.removeAll();
        c.repaint();
    }
}
