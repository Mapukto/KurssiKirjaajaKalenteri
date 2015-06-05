
package kkk.ui;

import java.awt.*;
import javax.swing.*;
import kkk.ui.kalenteriui.KalenteriUI;
import kkk.ui.listaui.KurssitUI;
import kkk.ui.statistiikkaui.StatistiikkaUI;
import kkk.ui.uusikurssiui.UusiKaynnissaOlevaKurssiUI;
import kkk.ui.uusikurssiui.UusiValmisKurssiUI;

/**
 *
 * @author mopo
 */
public class UI implements Runnable {

    private static JFrame frame;
    private static Container c;

    public static JFrame getFrame() {
        return frame;
    }
    
    /**
     * luodaan frame ja etusivuksi kalenterinÃƒÂ¤kymÃƒÂ¤
     */
    @Override
    public void run() {
        frame = new JFrame("KurssiKirjaajaKalenteri KKK");
        frame.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        c.setLayout(new FlowLayout());
        
        KalenteriUI alkuruutu = new KalenteriUI();
        
        c.add(alkuruutu);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * luo kurssinÃ¤kymÃ¤n. nÃ¤kymÃ¤t luodaan omissa luokissaan, jotka sitten lisÃ¤tÃ¤Ã¤n JFramen pÃ¤Ã¤lle.
     * Koodi on toistuvaa kaikissa nÃ¤kymÃ¤nvaihdoissa, mutten keksinyt vielÃ¤ jÃ¤rkevÃ¤mpÃ¤Ã¤
     * tapaa hallita nÃ¤kymiÃ¤...+
     */
    public static void luoKurssiNakyma() {
        c.setLayout(new BorderLayout());
        KurssitUI kurssiUI = new KurssitUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(kurssiUI);
        
        c.validate();
        frame.pack();
    }
    
    /**
     * luo kalenterinÃ¤kymÃ¤n.
     */
    public static void luoKalenteriNakyma() {
        c.setLayout(new FlowLayout());
        KalenteriUI kalenteri = new KalenteriUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(kalenteri);
        
        c.validate();
        frame.pack();
    }
    public static void luoUusiValmisKurssiNakyma() {
//        c.setLayout(new BorderLayout());
        UusiValmisKurssiUI uusiKurssi = new UusiValmisKurssiUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(uusiKurssi);
        
        c.validate();
        frame.pack();
    }
    
    public static void luoStatistiikkaNakyma() {
        StatistiikkaUI uusiUI = new StatistiikkaUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(uusiUI);
        
        c.validate();
        frame.pack();
    }
    
    public static void luoUusiKaynnissaOlevaKurssiNakyma() {
        UusiKaynnissaOlevaKurssiUI uusiKurssi = new UusiKaynnissaOlevaKurssiUI();
        
        c.removeAll();
        c.repaint();
        
        c.add(uusiKurssi);
        
        c.validate();
        frame.pack();
    }
    
    public static void virheDialog(String virheTeksti) {
        JOptionPane.showMessageDialog(frame, virheTeksti, "Achtung! Virhe! Error! Apua!", JOptionPane.ERROR_MESSAGE);
    }
    
    private static void muutaNakyma(JPanel panel) {
        
    }
}
