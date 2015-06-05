
package kkk.ui.kalenteriui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

public class KalenteriKuuntelija implements ActionListener {
    private final JButton hallintaNappi;
    private final JButton luoUusi;
    private final JButton tyhjenna;
    
    /**
     * 
     * @param kurssinHallintaan
     * @param luoUusi
     */
    public KalenteriKuuntelija(JButton kurssinHallintaan, JButton luoUusi, JButton tyhjenna) {
        this.hallintaNappi = kurssinHallintaan;
        this.luoUusi = luoUusi;
        this.tyhjenna = tyhjenna;
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
        if (ae.getSource() == tyhjenna) {
            Ohjain.tyhjennaKalenteri();
        }
    }
    
}
