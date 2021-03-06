
package kkk.ui.statistiikkaui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import kkk.laskin.Laskin;

/**
 * Luo näkymän statistiikan tarkasteluun.
 * @author maot
 */
public class StatistiikkaUI extends JPanel {
    Laskin laskin;
    
    public StatistiikkaUI() {
        laskin = new Laskin();
        
        this.add(teeYdin());
    }
    
    private JPanel teeYdin() {
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new GridLayout(10, 1));
        
        paneeli.add(teeJLabel("Kursseja yhteensä: " + laskin.getKurssitYht()));
        paneeli.add(teeJLabel("Noppia yhteensä: " + laskin.getNopat()));
        paneeli.add(teeJLabel("Kurssien keskiarvo: " + laskin.getKa()));
        paneeli.add(teeJLabel("Kurssien painotettu keskiarvo: " + laskin.getPainotettuKa()));
        
        double ka = laskin.getKa();
        
        if (ka < 2.5) {
            paneeli.add(teeJLabel("Vielä on parantamisen varaa!"));
        } else if (ka >= 2.5 && ka < 4) {
            paneeli.add(teeJLabel("Hyvin menee!!"));
        } else paneeli.add(teeJLabel("Olet jumala!!!!!!!"));
        
        JButton takaisin = new JButton("Takaisin");
        StatistiikkaKuuntelija kuuntelija = new StatistiikkaKuuntelija();
        takaisin.addActionListener(kuuntelija);

        paneeli.add(takaisin);
        
        return paneeli;
    }
    
    private JLabel teeJLabel(String teksti) {
        JLabel newLabel = new JLabel(teksti);
        return newLabel;
    }
}
