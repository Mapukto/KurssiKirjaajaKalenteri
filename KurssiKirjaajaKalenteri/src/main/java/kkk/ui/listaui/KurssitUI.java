
package kkk.ui.listaui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import kkk.kurssikanta.Kurssi;
import kkk.ohjain.Ohjain;

/**
 *
 * @author mopo
 */
public class KurssitUI extends JPanel {
    List<Kurssi> kurssitLista;
    Kurssi[] kurssit;
    
    public KurssitUI() {
        teeKurssiLista();        
        
        this.add(teeYlaOsa(), BorderLayout.SOUTH);
        this.add(kurssiLista(), BorderLayout.CENTER);
    }
    
    /**
     * 
     * @return 
     */
    private JLabel teeYlaOsa() {
        JLabel otsikko = new JLabel();
        return otsikko;
    }
    
    private JScrollPane kurssiLista() {
        JList kurssiLista = new JList(kurssit);
        kurssiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        kurssiLista.setLayoutOrientation(JList.VERTICAL);
        kurssiLista.setVisibleRowCount(-1);
        
        JScrollPane listScroller = new JScrollPane(kurssiLista);
        listScroller.setPreferredSize(new Dimension(700, 500));
        
        return listScroller;
    }

    private void teeKurssiLista() {
        kurssitLista = new ArrayList<>(Ohjain.getKurssit());
        int kurssitSize = kurssitLista.size();
        
        kurssit = new Kurssi[kurssitSize];
        
        for (int i = 0; i < kurssitSize; i++) {
            kurssit[i] = kurssitLista.get(i);
        }
    }
    
    private JPanel teeNappiOsio() {
        JPanel nappiPanel = new JPanel();
        return null;
    }
}
