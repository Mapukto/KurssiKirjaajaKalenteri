
package kkk.ui.statistiikkaui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kkk.ui.UI;

/**
 * Vie käyttäjän takaisin kurssinäkymään, mikäli tapahtuma havaitaan, eli käyttäjä
 * haluaa statistiikkanäkymästä pois.
 * @author maot
 */
class StatistiikkaKuuntelija implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UI.luoKurssiNakyma();
    }
    
}
