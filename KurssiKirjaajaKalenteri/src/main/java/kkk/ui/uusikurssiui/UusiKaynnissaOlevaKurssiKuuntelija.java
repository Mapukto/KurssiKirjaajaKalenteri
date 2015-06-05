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
            try {
                tallennaAjatTauluihin();
                aikaTF.setText("");
                paivaValikko.setSelectedIndex(0);
            } catch (Exception e) {
                UI.virheDialog(e.getMessage());
            }

        }

        if (ae.getSource() == valmis) {
            try {
                teeUusiKaynnissaOlevaKurssi();
                aikaTaulu.clear();
                paivaTaulu.clear();
                UI.luoKalenteriNakyma();
            } catch (Exception e) {
                UI.virheDialog(e.getMessage());
            }

        }
    }

    private void tallennaAjatTauluihin() throws Exception {
        String[] ajat = aikaTF.getText().split("-");

        if (!tarkastaAjat(ajat)) {
            throw new Exception("Syötetyt ajat ovat virheellisiä.\nAikaa ei tallennettu\nAikojen tulee olla tuntien 9 ja 18 välillä.");
        }

        paivaTaulu.add((String) paivaValikko.getSelectedItem());
        aikaTaulu.add(aikaTF.getText());

    }

    private void teeUusiKaynnissaOlevaKurssi() throws Exception {
        String[] paivat = new String[paivaTaulu.size()];
        String[] ajat = new String[paivaTaulu.size()];
        
        tarkastaInput(nimi.getText(), lyhenneTF.getText(), paivat);

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

    private void tarkastaInput(String nimi, String lyhenne, String[] taulu) throws Exception {
        if (nimi.equals("")) throw new Exception("Nimeä ei ole syötetty");
        if (lyhenne.equals("")) throw new Exception("Lyhennettä ei ole syötetty");
        if (lyhenne.length() > 10) throw new Exception("Lyhenne on liian pitkä. Keksi lyhyempi!");
        if (taulu.length == 0) throw new Exception("Aikavarauksia ei ole tehty!");
    }
}
