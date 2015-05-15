
package kkk.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Kuuntelija implements ActionListener {
    private JButton hallintaNappi;
    
    /**
     * 
     * @param kurssinHallintaan
     */
    public Kuuntelija(JButton kurssinHallintaan) {
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
