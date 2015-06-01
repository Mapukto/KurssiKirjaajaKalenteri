
package kkk.ui.uusikurssiui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maot
 */
public class UusiKaynnissaOlevaKurssiUI extends JPanel {
    
    public UusiKaynnissaOlevaKurssiUI() {
        this.add(teeLomake());
    }
    
    private JPanel teeLomake() {
        JPanel lomake = new JPanel();
        lomake.setLayout(new BorderLayout());
        
        lomake.add(teeOtsikko(), BorderLayout.NORTH);
        lomake.add(teeInput(), BorderLayout.CENTER);
        
        return lomake;
    }
    
    private JPanel teeOtsikko() {
        JPanel otsikko = new JPanel();
        otsikko.add(new JLabel("Uuden kurssin luontilomake"));
        return otsikko;
    }
    
    private JPanel teeInput() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15,1));
        
        JLabel nimiLabel = new JLabel("Kurssin nimi:");
        JTextField nimiTFiel = new JTextField();
        panel.add(nimiLabel);
        panel.add(nimiTFiel);
        
        panel.add(teeNapit(nimiTFiel));
        
        return panel;
    }

    private JPanel teeNapit(JTextField nimiTFiel) {
        JButton uusiAika = new JButton("Lisää aikavaraus");
        JButton peruuta = new JButton("Takaisin");
        JButton valmis = new JButton("Valmis");
        
        UusiKaynnissaOlevaKurssiKuuntelija kuuntelija = new UusiKaynnissaOlevaKurssiKuuntelija(nimiTFiel, uusiAika, peruuta, valmis);
        
        JPanel napit = new JPanel(new GridLayout(1,3));
        
        napit.add(uusiAika);
        napit.add(peruuta);
        napit.add(valmis);        
        
        return napit;
    }
}
