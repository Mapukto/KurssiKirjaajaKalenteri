
package kkk.ui.kalenteriui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kkk.ui.UI;

public class KalenteriKuuntelija implements ActionListener {
    private final JButton hallintaNappi;
    private final JButton luoUusi;
    
    /**
     * 
     * @param kurssinHallintaan
     * @param luoUusi
     */
    public KalenteriKuuntelija(JButton kurssinHallintaan, JButton luoUusi) {
        this.hallintaNappi = kurssinHallintaan;
        this.luoUusi = luoUusi;
    }

    /**
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == hallintaNappi) {
            UI.luoKurssiNakyma();
        }
        if (ae.getSource() == luoUusi) {
            UI.luoUusiKaynnissaOlevaKurssiNakyma();
        }
    }
    
}
