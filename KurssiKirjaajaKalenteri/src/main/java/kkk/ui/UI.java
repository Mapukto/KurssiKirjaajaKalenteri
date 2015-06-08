
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
     */
    public static void luoKurssiNakyma() {
        c.setLayout(new BorderLayout());
        KurssitUI kurssiUI = new KurssitUI();
        
        muutaNakyma(kurssiUI);
    }
    
    /**
     * luo kalenterinÃ¤kymÃ¤n.
     */
    public static void luoKalenteriNakyma() {
        c.setLayout(new FlowLayout());
        KalenteriUI kalenteri = new KalenteriUI();
        
        muutaNakyma(kalenteri);
    }
    
    public static void luoUusiValmisKurssiNakyma() {
//        c.setLayout(new BorderLayout());
        UusiValmisKurssiUI uusiKurssi = new UusiValmisKurssiUI();
        
        muutaNakyma(uusiKurssi);
    }
    
    public static void luoStatistiikkaNakyma() {
        StatistiikkaUI uusiUI = new StatistiikkaUI();
        
        muutaNakyma(uusiUI);
    }
    
    public static void luoUusiKaynnissaOlevaKurssiNakyma() {
        UusiKaynnissaOlevaKurssiUI uusiKurssi = new UusiKaynnissaOlevaKurssiUI();
        
        muutaNakyma(uusiKurssi);
    }
    
    public static void virheDialog(String virheTeksti) {
        JOptionPane.showMessageDialog(frame, virheTeksti, "Achtung! Virhe! Error! Apua!", JOptionPane.ERROR_MESSAGE);
    }
    
    private static void muutaNakyma(JPanel panel) {
        c.removeAll();
        c.repaint();
        
        c.add(panel);
        
        c.validate();
        frame.pack();
    }
}
