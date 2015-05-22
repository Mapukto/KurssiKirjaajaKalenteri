
package kkk.ui.kalenteriui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kkk.ui.UI;

public class KalenteriKuuntelija implements ActionListener {
    private final JButton hallintaNappi;
    
    /**
     * 
     * @param kurssinHallintaan
     */
    public KalenteriKuuntelija(JButton kurssinHallintaan) {
        this.hallintaNappi = kurssinHallintaan;
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
    }
    
}
