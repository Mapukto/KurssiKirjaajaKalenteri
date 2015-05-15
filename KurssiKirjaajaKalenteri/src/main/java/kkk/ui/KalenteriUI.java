
package kkk.ui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mopo
 */
public class KalenteriUI extends JPanel {

    
    public KalenteriUI() {
        this.add(teeKalenteri());
    }

    private JPanel teeKalenteri() {
        JPanel kalenteri = new JPanel();
        kalenteri.setLayout(new BorderLayout());
//        kalenteri.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        kalenteri.add(teeOtsikko(), BorderLayout.NORTH);
        kalenteri.add(lokerot(), BorderLayout.CENTER);
        kalenteri.add(teeNapit(), BorderLayout.SOUTH);
        
        return kalenteri;
    }
    
    private JPanel lokerot() {
         JPanel paivaPanel = new JPanel();
         paivaPanel.setLayout(new GridLayout(0,6));
         
         String[] viikonPvt = {"alkaen","maanantai", "tiistai", "keskiviikko", "torstai", "perjantai"};
         
         for (int i = 0; i < 6; i++) {
            JPanel pva = new JPanel();
            pva.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel pvaNimi = new JLabel(viikonPvt[i]); 
            pva.add(pvaNimi);
            paivaPanel.add(pva);
        }
         
        String[] ajat = {"9", "10" ,"11", "12", "13", "14", "15", "16", "17", "18"};
        int aikaIndex = 0;
        
        for (int i = 0; i < 60; i++) {
            JPanel lokero = new JPanel();
            lokero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel onkoVarattu = new JLabel();
            
            
            if (i % 6 == 0) {
                onkoVarattu.setText(ajat[aikaIndex]);
                aikaIndex++;
            } else {
                lokero.setBackground(Color.WHITE);
                if (onkoVarattu()) {
                    lokero.setBackground(Color.RED);
                }
            }
            
            lokero.add(onkoVarattu);
            paivaPanel.add(lokero);
            
        }
        
        return paivaPanel;
    }

    private boolean onkoVarattu() {
        // tarkastaa kesken olevista kursseista onko aikaa tässä
        return false;
    }

    private JPanel teeOtsikko() {
        JPanel otsikkoLokero = new JPanel();
        otsikkoLokero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel otsikko = new JLabel("Kalenterinäkymä");
        otsikko.setForeground(Color.BLACK);
        
        otsikkoLokero.add(otsikko, BorderLayout.CENTER);
        
        return otsikkoLokero;
    }

    private JPanel teeNapit() {
        JPanel nappiLokero = new JPanel();
        
        JButton kurssinHallintaan = new JButton("Kurssienhallintaan");
        nappiLokero.add(kurssinHallintaan, BorderLayout.CENTER);
        return nappiLokero;
    }
}

//    private JPanel kalenteriUI() {
//        JPanel kalenteri = new JPanel(true);
//        
//    }