
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
        
        lomake.add(teeOtsikko());
        
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
        
        JButton uusiAika = new JButton("Lisää aikavaraus");
        
        JButton peruuta = new JButton("Takaisin");
        JButton valmis = new JButton("Valmis");
        
        UusiKaynnissaOlevaKurssiKuuntelija kuuntelija = new UusiKaynnissaOlevaKurssiKuuntelija(nimiTFiel, uusiAika, peruuta, valmis);
        
        return panel;
    }
}
