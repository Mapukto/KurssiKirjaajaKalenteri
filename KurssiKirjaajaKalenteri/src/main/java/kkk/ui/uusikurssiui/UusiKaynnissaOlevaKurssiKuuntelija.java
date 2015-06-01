
package kkk.ui.uusikurssiui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import kkk.ui.UI;

/**
 *
 * @author maot
 */
public class UusiKaynnissaOlevaKurssiKuuntelija implements ActionListener {
    private final JButton uusiAika, peruuta, valmis;
    private final JTextField nimi;

    UusiKaynnissaOlevaKurssiKuuntelija(JTextField nimiTFiel, JButton uusiAika, JButton peruuta, JButton valmis) {
        this.nimi = nimiTFiel;
        this.uusiAika = uusiAika;
        this.peruuta = peruuta;
        this.valmis = valmis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == peruuta) {
            UI.luoKalenteriNakyma();
        }
        if (ae.getSource() == uusiAika) {
            
        }
        if (ae.getSource() == valmis) {
            
        }
    }
    
}
