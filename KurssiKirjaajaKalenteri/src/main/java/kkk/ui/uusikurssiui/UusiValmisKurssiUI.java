
package kkk.ui.uusikurssiui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mopo
 */
public class UusiValmisKurssiUI extends JPanel {

    public UusiValmisKurssiUI() {
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
        JPanel lomake = new JPanel();
        lomake.setLayout(new GridLayout(9, 1));
        
        JLabel nimiLabel = new JLabel("Kurssin nimi:");
        JTextField nimiTFiel = new JTextField();
        lomake.add(nimiLabel);
        lomake.add(nimiTFiel);
        
        JLabel arvosanaLabel = new JLabel("Kurssista saatu arvosana:");
        JTextField arvosanaTFiel = new JTextField();
        lomake.add(arvosanaLabel);
        lomake.add(arvosanaTFiel);
        
        JLabel noppaLabel = new JLabel("Kurssista saadut nopat:");
        JTextField noppaTFiel = new JTextField();
        lomake.add(noppaLabel);
        lomake.add(noppaTFiel);
        
        JLabel aikaLabel = new JLabel("Kurssin suoritusaika esim. \"Syksy 2015\" tai \"20.03.2015\"");
        JTextField aikaTFiel = new JTextField();
        lomake.add(aikaLabel);
        lomake.add(aikaTFiel);
        
        JPanel napit = teeNapit(nimiTFiel, arvosanaTFiel, noppaTFiel, aikaTFiel);
        lomake.add(napit);
        
        return lomake;
    }
    
    private JPanel teeNapit(JTextField nimiTFiel, JTextField arvosanaTFiel, JTextField noppaTFiel, JTextField aikaTFiel) {
        JPanel napit = new JPanel(new GridLayout(1, 2));
        
        JButton submit = new JButton("Valmis");
        JButton back = new JButton("Takaisin");
        
        UusiValmisKurssiKuuntelija kuuntelija = new UusiValmisKurssiKuuntelija(nimiTFiel, arvosanaTFiel, noppaTFiel, aikaTFiel, submit, back);
        
        back.addActionListener(kuuntelija);
        submit.addActionListener(kuuntelija);
        
        napit.add(back);
        napit.add(submit);
        
        return napit;
    }
}
