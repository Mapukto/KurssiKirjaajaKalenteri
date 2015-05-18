
package kkk.ui.listaui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import kkk.kurssikanta.Kurssi;
import kkk.ohjain.Ohjain;

/**
 *
 * @author mopo
 */
public class KurssitUI extends JPanel {
    private List<Kurssi> kurssitLista;
    private JList lista;
    private DefaultListModel<Kurssi> listanOsat;
    
    public KurssitUI() {
        teeKurssiLista();        
        
        this.add(teeYlaOsa(), BorderLayout.SOUTH);
        this.add(kurssiLista(), BorderLayout.CENTER);
        this.add(teeNappiOsio(), BorderLayout.SOUTH);
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
        JList kurssiLista = new JList(listanOsat);
        
        this.lista = kurssiLista;
        
        kurssiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        kurssiLista.setLayoutOrientation(JList.VERTICAL);
        kurssiLista.setVisibleRowCount(-1);
        
        JScrollPane listScroller = new JScrollPane(kurssiLista);
        listScroller.setPreferredSize(new Dimension(700, 500));
        
        return listScroller;
    }

    private void teeKurssiLista() {
        kurssitLista = new ArrayList<>(Ohjain.getKurssit());
        listanOsat = new DefaultListModel();
        
        for (Kurssi k : kurssitLista) {
            listanOsat.addElement(k);
        }
    }
    
    private JPanel teeNappiOsio() {
        JPanel nappiPanel = new JPanel();
        nappiPanel.setLayout(new FlowLayout());
        
        JButton kalenteriNakyma = new JButton("Kalenterinnäkymään");
        JButton poistaKurssi = new JButton("Poista kurssi");
        JButton uusiKurssi = new JButton("Uusi kurssi");
        JButton statistiikkaNakymaan = new JButton("Statistiikkaan");
        
        KurssilistaKuuntelija kuuntelija = new KurssilistaKuuntelija(kalenteriNakyma, poistaKurssi, uusiKurssi, statistiikkaNakymaan, lista, listanOsat);
        
        kalenteriNakyma.addActionListener(kuuntelija);
        poistaKurssi.addActionListener(kuuntelija);
        uusiKurssi.addActionListener(kuuntelija);
        statistiikkaNakymaan.addActionListener(kuuntelija);
        
        nappiPanel.add(kalenteriNakyma);
        nappiPanel.add(statistiikkaNakymaan);
        nappiPanel.add(uusiKurssi);
        nappiPanel.add(poistaKurssi);
        
        return nappiPanel;
    }
}
