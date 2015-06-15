package kkk.ui.uusikurssiui;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

/**
 * Luokka kuuntelee UusiKaynnissaOlevaKurssiUI:ta. Luokka tarkastaa käyttäjän
 * syöttämän tiedon oikeellisuuden ja estää uuden kurtssin luonnin, mikäli
 * tiedot ovat vajaavaisia
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
    private final TextArea textArea;

    UusiKaynnissaOlevaKurssiKuuntelija(TextArea textArea, JTextField nimiTFiel, JTextField lyhenneTF, JTextField aikaTF, JComboBox paivaValikko, JButton peruuta, JButton valmis, JButton uusiAika) {
        this.lyhenneTF = lyhenneTF;
        this.nimi = nimiTFiel;
        this.uusiAika = uusiAika;
        this.peruuta = peruuta;
        this.valmis = valmis;
        this.aikaTF = aikaTF;
        this.paivaValikko = paivaValikko;
        this.paivaTaulu = new ArrayList<>();
        this.aikaTaulu = new ArrayList<>();
        this.textArea = textArea;
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
            } catch (Exception e) {
                UI.virheDialog(e.getMessage());
                aikaTF.setText("");
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
        String[] ajat = aikaTF.getText().trim().split("-");

        String paiva = (String) paivaValikko.getSelectedItem();

        if (!tarkastaAjat(ajat)) {
            throw new Exception("Syötetyt ajat ovat virheellisiä.\nAikaa ei tallennettu\nAikojen tulee olla tuntien 9 ja 18 välillä.");
        }
        
        KaynnissaOlevaKurssi kok;
        if ((kok = tarkastaVaraus(paivaValikko.getSelectedIndex() + 1, ajat)) != null) {
            UI.virheDialog("Kyseinen aika on jo varattu!\nJo varattu kurssi: " + kok.getNimi());
            return;
        }

        paivaTaulu.add(paiva);
        aikaTaulu.add(ajat[0].trim() + "-" + ajat[1].trim());

        lisaaAjatNakyville(paiva, ajat);
    }

    private void teeUusiKaynnissaOlevaKurssi() throws Exception {
        String[] paivat = new String[paivaTaulu.size()];
        String[] ajat = new String[paivaTaulu.size()];

        tarkastaInput(nimi.getText(), lyhenneTF.getText(), paivat);

        AikaVaraus varaukset = new AikaVaraus(paivaTaulu.toArray(paivat), aikaTaulu.toArray(ajat));
        KaynnissaOlevaKurssi uusiKurssi = new KaynnissaOlevaKurssi(this.nimi.getText().trim(), this.lyhenneTF.getText().trim(), varaukset);

        Ohjain.teeKeskenErainenKurssi(uusiKurssi);
    }

    private boolean tarkastaAjat(String[] ajat) {
        try {
            int alku = Integer.parseInt(ajat[0].trim());
            int loppu = Integer.parseInt(ajat[1].trim());

            if (alku == loppu) {
                return false;
            }

            return alku > 8 && alku < 19 && loppu < 20 && loppu > 9;
        } catch (Exception e) {
            return false;
        }
    }

    private void tarkastaInput(String nimi, String lyhenne, String[] taulu) throws Exception {
        if (nimi.equals("")) {
            throw new Exception("Nimeä ei ole syötetty");
        }
        if (lyhenne.equals("")) {
            throw new Exception("Lyhennettä ei ole syötetty");
        }
        if (lyhenne.length() > 10) {
            throw new Exception("Lyhenne on liian pitkä. Keksi lyhyempi!");
        }
        if (taulu.length == 0) {
            throw new Exception("Aikavarauksia ei ole tehty!");
        }
    }

    private void lisaaAjatNakyville(String paiva, String[] ajat) {
        String eka = ajat[0].trim();
        String toka = ajat[1].trim();

        String append = String.format("%-15s %-2s - %-2s", paiva, eka, toka);

        appendTextArea(append);
    }

    public void appendTextArea(String append) {
        StringBuilder text = new StringBuilder(textArea.getText());
        text.append(append).append("\n");

        textArea.setText(text.toString());
    }

    private KaynnissaOlevaKurssi tarkastaVaraus(int p, String[] ajat) {
        int alku = Integer.parseInt(ajat[0].trim());
        int loppu = Integer.parseInt(ajat[1].trim());
        int erotus = loppu - alku;
        
        for (int i = alku; i < loppu; i++) {
            KaynnissaOlevaKurssi kok;
            if ((kok = Ohjain.onkoVarattu(p, i)) != null) return kok;
        }
        
        return null;
    }
}
