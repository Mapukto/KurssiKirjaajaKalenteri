package kkk.ui.kalenteriui;

import java.awt.*;
import javax.swing.*;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.ohjain.Ohjain;

/**
 * Ei oikeasti edes ole kalenteri, vaan lukujärjestys aka lukkari! Luodaan
 * kalenteriUI. Kalenteri koostuu otsikosta, kalenteriosiosta, jossa "soluja",
 * jotka kuvaavat kutakin tuntia tiettynä päivänä ja napeista.
 *
 * @author maot
 */
public class KalenteriUI extends JPanel {

    public KalenteriUI() {
        this.add(teeKalenteri());
    }

    private JPanel teeKalenteri() {
        JPanel kalenteri = new JPanel();
        kalenteri.setLayout(new BorderLayout());
//        kalenteri.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        kalenteri.add(teeOtsikko(), BorderLayout.NORTH);
        kalenteri.add(lokerot(), BorderLayout.CENTER);
        kalenteri.add(teeNapit(), BorderLayout.SOUTH);

        return kalenteri;
    }

    /**
     * Luodaan kalenteriin taulukko. Ensimmäisessä sarakkeessa ajat[aikaIndex]
     * eli tunnit. Sarakkeissa 2-6 päivät ma - pe numeroituna 1 - 5 pvaIndexiin.
     * onkoVarattu -metodi saa parametrikseen aikaIndex + 8, eli sillä hetkellä
     * käsittelyssä olevan tunnin. Jos tunti on varattuna, lisätään soluun
     * lukemaan kyseisen kurssin nimi.
     */
    private JPanel lokerot() {
        JPanel paivaPanel = new JPanel();
        paivaPanel.setLayout(new GridLayout(0, 6));

        String[] viikonPvt = {"Aika", "maanantai", "tiistai", "keskiviikko", "torstai", "perjantai"};

        teePaneelit(viikonPvt, paivaPanel);

        String[] ajat = {"9 - 10", "10 - 11", "11 - 12", "12 - 13", "13 - 14", "14 - 15", "15 - 16", "16 - 17", "17 - 18", "18 - 19"};

        taytaPaneelit(ajat, paivaPanel);

        return paivaPanel;
    }

    private void taytaPaneelit(String[] ajat, JPanel paivaPanel) {
        int aikaIndex = 0;
        int pvaIndex = 1;

        for (int i = 0; i < 60; i++) {
            JPanel lokero = new JPanel();
            lokero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel onkoVarattu = new JLabel();

            if (i % 6 == 0) {
                onkoVarattu.setText(ajat[aikaIndex]);
                aikaIndex++;
            } else {
                lokero.setBackground(Color.WHITE);

                KaynnissaOlevaKurssi varattuKurssi = onkoVarattu(pvaIndex, (aikaIndex + 8));

                if (varattuKurssi != null) {
                    lokero.setBackground(Color.RED);
                    onkoVarattu.setText(varattuKurssi.getNickName());
                    onkoVarattu.setToolTipText(varattuKurssi.getNimi());
                }

                pvaIndex = paivitaPvaIndex(pvaIndex);
            }

            lokero.add(onkoVarattu);
            paivaPanel.add(lokero);
        }
    }

    private void teePaneelit(String[] viikonPvt, JPanel paivaPanel) {
        for (int i = 0; i < 6; i++) {
            JPanel pva = new JPanel();
            pva.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel pvaNimi = new JLabel(viikonPvt[i]);
            pva.add(pvaNimi);
            paivaPanel.add(pva);
        }
    }

    /**
     * pidetään kirjaa missä päivässä ollaan menossa
     */
    private int paivitaPvaIndex(int pvaIndex) {
        int uusiPva = pvaIndex;

        if (uusiPva < 5) {
            uusiPva++;
        } else {
            uusiPva = 1;
        }

        return uusiPva;
    }

    private KaynnissaOlevaKurssi onkoVarattu(int pva, int tunti) {
        return Ohjain.onkoVarattu(pva, tunti);
    }

    private JPanel teeOtsikko() {
        JPanel otsikkoLokero = new JPanel();
        otsikkoLokero.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel otsikko = new JLabel("Kalenterinäkymä");
        otsikko.setForeground(Color.BLACK);

        otsikkoLokero.add(otsikko, BorderLayout.CENTER);

        return otsikkoLokero;
    }

    private JPanel teeNapit() {
        JPanel nappiLokero = new JPanel();

        JButton kurssinHallintaan = new JButton("Kurssienhallintaan");
        nappiLokero.add(kurssinHallintaan);

        JButton uusiKurssi = new JButton("Uusi kurssi");
        nappiLokero.add(uusiKurssi);

        JButton tyhjenna = new JButton("Jakson vaihto");
        nappiLokero.add(tyhjenna);

        KalenteriKuuntelija kuuntelija = new KalenteriKuuntelija(kurssinHallintaan, uusiKurssi, tyhjenna);
        kurssinHallintaan.addActionListener(kuuntelija);
        uusiKurssi.addActionListener(kuuntelija);
        tyhjenna.addActionListener(kuuntelija);
        
        if (Ohjain.getKEKurssit().isEmpty()) {
            tyhjenna.setEnabled(false);
        }

        return nappiLokero;
    }

}

//    private JPanel kalenteriUI() {
//        JPanel kalenteri = new JPanel(true);
//        
//    }
