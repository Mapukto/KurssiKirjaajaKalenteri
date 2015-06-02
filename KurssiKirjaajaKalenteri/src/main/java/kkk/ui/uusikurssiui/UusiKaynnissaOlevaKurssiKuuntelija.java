
package kkk.ui.uusikurssiui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

/**
 *
 * @author maot
 */
public class UusiKaynnissaOlevaKurssiKuuntelija implements ActionListener {
    private final JButton uusiAika, peruuta, valmis;
    private final JTextField nimi;
    private final JTextField lyhenneTF;
    private final JTextField aikaTF;
    private final JComboBox paivaValikko;
    
    private final ArrayList<String> paivaTaulu;
    private final ArrayList<String> aikaTaulu;

    UusiKaynnissaOlevaKurssiKuuntelija(JTextField nimiTFiel, JTextField lyhenneTF, JTextField aikaTF, JComboBox paivaValikko, JButton peruuta, JButton valmis, JButton uusiAika) {
        this.lyhenneTF = lyhenneTF;
        this.nimi = nimiTFiel;
        this.uusiAika = uusiAika;
        this.peruuta = peruuta;
        this.valmis = valmis;
        this.aikaTF = aikaTF;
        this.paivaValikko = paivaValikko;
        this.paivaTaulu = new ArrayList<>();
        this.aikaTaulu = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == peruuta) {
            UI.luoKalenteriNakyma();
        }
        
        if (ae.getSource() == uusiAika) {
            tallennaAjatTauluihin();
            aikaTF.setText("");
            paivaValikko.setSelectedIndex(0);
        }
        
        if (ae.getSource() == valmis) {
            teeUusiKaynnissaOlevaKurssi();
            aikaTaulu.clear();
            paivaTaulu.clear();
            UI.luoKalenteriNakyma();
        }
    }

    private void tallennaAjatTauluihin() {
        String[] ajat = aikaTF.getText().split("-");
        
        if (tarkastaAjat(ajat)) {
            paivaTaulu.add((String) paivaValikko.getSelectedItem());
            aikaTaulu.add(aikaTF.getText());
        } else {
            System.out.println("UusiKaynnissaOlevaKurssiKuuntelija syöte väärin");
        }
    }
    
    private void teeUusiKaynnissaOlevaKurssi() {
        String[] paivat = new String[paivaTaulu.size()];
        String[] ajat = new String[paivaTaulu.size()];
        
        AikaVaraus varaukset = new AikaVaraus(paivaTaulu.toArray(paivat), aikaTaulu.toArray(ajat));
        KaynnissaOlevaKurssi uusiKurssi = new KaynnissaOlevaKurssi(this.nimi.getText(), this.lyhenneTF.getText(), varaukset);
        
        Ohjain.teeKeskenErainenKurssi(uusiKurssi);
    }
    
    private boolean tarkastaAjat(String[] ajat) {
        try {
            int alku = Integer.parseInt(ajat[0]);
            int loppu = Integer.parseInt(ajat[1]);
            
            return alku > 8 && alku < 18 && loppu < 19 && loppu > 9;
        } catch (Exception e) {
            return false;
        }
    }
}
