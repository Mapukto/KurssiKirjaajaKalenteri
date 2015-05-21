
package kkk.ui.uusikurssiui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
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
            
        }
        
        if (ae.getSource() == back) {
            UI.luoKurssiNakyma();
        }
    }
    
}
