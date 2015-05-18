
package kkk.ui.listaui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

/**
 *
 * @author mopo
 */
public class KurssilistaKuuntelija implements ActionListener {
    private final JButton kalenteriin;
    private final JButton poista;
    private final JButton uusi;
    private final JButton statistiikka;
    private JList lista; 
    private DefaultListModel listModel;
    
    public KurssilistaKuuntelija(JButton kalenteriin, JButton poista, JButton uusi, JButton statistiikka, JList lista, DefaultListModel listModel) {
        this.kalenteriin = kalenteriin;
        this.poista = poista;
        this.uusi = uusi;
        this.statistiikka = statistiikka;
        this.lista = lista;
        this.listModel = listModel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == kalenteriin) {
            UI.luoKalenteriNakyma();
        }
        
        if (ae.getSource() == poista) {
            int index = lista.getSelectedIndex();
            listModel.remove(index);

            Ohjain.poistaKurssi(index);
            
            int koko = listModel.getSize();
            if (koko == 0) poista.setEnabled(false);
        }
    }
    
}
