
package kkk.ui.statistiikkaui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kkk.ui.UI;

/**
 *
 * @author maot
 */
class StatistiikkaKuutelija implements ActionListener {
    private final JButton takaisin;

    public StatistiikkaKuutelija(JButton takaisin) {
        this.takaisin = takaisin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) UI.luoKurssiNakyma();
    }
    
}
