
package kkk.ui.uusikurssiui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Luokka luo näkymän uuden käynnissäolevan kurssin luomiseen.
 * @author maot
 */
public class UusiKaynnissaOlevaKurssiUI extends JPanel {
    UusiKaynnissaOlevaKurssiKuuntelija kuuntelija;
    
    public UusiKaynnissaOlevaKurssiUI() {
        this.add(teeLomake());
        liitaKuuntelija();
    }
    
    private void liitaKuuntelija() {
        this.kuuntelija = new UusiKaynnissaOlevaKurssiKuuntelija(this.textArea, this.nimiTFiel, this.lyhenneTF, this.aikaTF, this.paivaValikko, this.peruuta, this.valmis, this.uusiAika);
        this.nimiTFiel.addActionListener(kuuntelija);
        this.lyhenneTF.addActionListener(kuuntelija);
        this.aikaTF.addActionListener(kuuntelija);
        this.paivaValikko.addActionListener(kuuntelija);
        this.peruuta.addActionListener(kuuntelija);
        this.valmis.addActionListener(kuuntelija);
        this.uusiAika.addActionListener(kuuntelija);
    }
    
    private JPanel teeLomake() {
        JPanel lomake = new JPanel();
        lomake.setLayout(new BorderLayout());
        
        lomake.add(teeOtsikko(), BorderLayout.NORTH);
        lomake.add(teeInput(), BorderLayout.CENTER);
        lomake.add(teeAikaVarausLista(), BorderLayout.SOUTH);
        
        return lomake;
    }
    
    private JPanel teeOtsikko() {
        JPanel otsikko = new JPanel();
        otsikko.add(new JLabel("Uuden kurssin luontilomake"));
        return otsikko;
    }
    
    private JTextField nimiTFiel;
    private JTextField lyhenneTF;
    
    private JPanel teeInput() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        
        JLabel nimiLabel = new JLabel("Kurssin nimi:");
        this.nimiTFiel = new JTextField();
        panel.add(nimiLabel);
        panel.add(nimiTFiel);
        
        JLabel luokkaLabel = new JLabel("Kurssin lyhenne: (Max. 10 kirjainta.)");
        this.lyhenneTF = new JTextField();
        panel.add(luokkaLabel);
        panel.add(lyhenneTF);
        
        panel.add(teeAikaVarausInput());
        
        panel.add(teeNapit());
        
        return panel;
    }
    
    /**
     * luokkamuuttujia, jotta kuuntelijan tekeminen olisi helpompaa
     */
    private JComboBox paivaValikko;
    private JTextField aikaTF;
    
    private JPanel teeAikaVarausInput() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        JLabel paiva = new JLabel("Valitse päivä");
        panel.add(paiva);
        
        JLabel aika = new JLabel("Kirjoita aika esim. 10-12");
        panel.add(aika);
        
        String[] paivat = {"maanantai", "tiistai", "keskiviikko", "torstai", "perjantai"};
        
        this.paivaValikko = new JComboBox(paivat);
        panel.add(paivaValikko);
        
        this.aikaTF = new JTextField();
        panel.add(aikaTF);
        
        return panel;
    }

    private JButton uusiAika;
    private JButton peruuta;
    private JButton valmis;
    
    private JPanel teeNapit() {
        this.uusiAika = new JButton("Lisää aikavaraus");
        this.peruuta = new JButton("Takaisin");
        this.valmis = new JButton("Valmis");
        
        uusiAika.addActionListener(kuuntelija);
        peruuta.addActionListener(kuuntelija);
        valmis.addActionListener(kuuntelija);
        
        JPanel napit = new JPanel(new GridBagLayout());
        
        napit.add(uusiAika);
        napit.add(peruuta);
        napit.add(valmis);        
        
        return napit;
    }
    
    TextArea textArea;
    
    private JPanel teeAikaVarausLista() {
        JPanel paneeli = new JPanel();
        paneeli.setBackground(Color.WHITE);
        
        textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(400, 175));
        textArea.setFont(new Font("monospaced", Font.PLAIN, 16));
        textArea.setEditable(false);
        
        paneeli.add(textArea);
        
        return paneeli;
    }
}
