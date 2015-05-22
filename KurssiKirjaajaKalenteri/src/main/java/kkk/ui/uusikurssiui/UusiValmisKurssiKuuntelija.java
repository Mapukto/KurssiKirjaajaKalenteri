
package kkk.ui.uusikurssiui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

/**
 *
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
            luoUusiValmisKurssi();
            UI.luoKurssiNakyma();
        }
        
        if (ae.getSource() == back) {
            UI.luoKurssiNakyma();
        }
    }

    private void luoUusiValmisKurssi() throws NumberFormatException {
        int arvosana = Integer.parseInt(arvosanaField.getText());
        int nopat = Integer.parseInt(noppaField.getText());
        
        ValmisKurssi uusiKurssi = new ValmisKurssi(nimiField.getText(), arvosana, nopat, aikaField.getText());
        
        Ohjain.teeValmisKurssi(uusiKurssi);
    }
    
}
