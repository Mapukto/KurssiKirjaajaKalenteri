
package kkk.ui.uusikurssiui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

/**
 * Luokka kuuntelee UusiValmisKurssiUI:ta. Luokka tukee kahta nappia. Takaisin
 * ja submit. Takaisin -nappi vie takaisin kalenterinäkymään. Submit luo uuden kurssin
 * käyttäjän antamilla inputeilla.
 * @author mopo
 */
class UusiValmisKurssiKuuntelija implements ActionListener {
    private final JTextField nimiField;
    private final JTextField arvosanaField;
    private final JTextField noppaField;
    private final JTextField aikaField;
    
    private final JButton submit;
    private final JButton back;
    
    public UusiValmisKurssiKuuntelija(JTextField nimiTFiel, JTextField arvosanaTFiel, JTextField noppaTFiel, JTextField aikaTFiel, JButton submit, JButton back) {
        this.nimiField = nimiTFiel;
        this.arvosanaField = arvosanaTFiel;
        this.noppaField = noppaTFiel;
        this.aikaField = aikaTFiel;
        this.submit = submit;
        this.back = back;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                luoUusiValmisKurssi();
                UI.luoKurssiNakyma();
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    UI.virheDialog("Noppamäärä ei saa olla tekstiä!");
                } else {
                    UI.virheDialog("Kurssin tiedot virheellisiä. Kurssia ei tallennettu!");
                }
            }
            tyhjennaSyote();
        }
        
        if (ae.getSource() == back) {
            UI.luoKurssiNakyma();
        }
    }

    private void luoUusiValmisKurssi() throws NumberFormatException, Exception {
        tarkastaInput();
        
        String arvosana = arvosanaField.getText();
        
        int nopat = Integer.parseInt(noppaField.getText());
        
        ValmisKurssi uusiKurssi = new ValmisKurssi(nimiField.getText(), arvosana, nopat, aikaField.getText());
        
        Ohjain.teeValmisKurssi(uusiKurssi);
    }

    private void tyhjennaSyote() {
        noppaField.setText("");
    }

    private void tarkastaInput() throws Exception {
        if (nimiField.getText().equals("")) throw new Exception("Kurssin nimeä ei ole syötetty");
        if (aikaField.getText().equals("")) throw new Exception("Kurssin suoritusaikaa ei ole syötetty");
        if (arvosanaField.getText().equals("")) throw new Exception("Arvosanaa ei ole syötetty");
    }
}
