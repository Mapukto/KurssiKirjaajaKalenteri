package kkk.ui.kalenteriui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;
import kkk.ui.uusikurssiui.UusiValmisKurssiValidator;

//TÄMÄ LUOKKA ON PAHASTI KESKEN. TARKOITUS SIIS JAKSOA VAIHDETTAESSA, ETTÄ KURSSIT LÖYTYISI
//TÄÄLTÄ JA VOISI TALLENTAA KÄTEVÄSTI
/**
 * Luokka tekee näkymän jakson vaihtamiseen, eli aikataulutettujen kurssien
 * tallentamiseen kurssilistaan
 *
 * @author maot
 */
public class JaksonVaihtoUI extends JPanel {

    private final List<KaynnissaOlevaKurssi> kurssit;

    public JaksonVaihtoUI() {
        kurssit = Ohjain.getKEKurssit();

        this.setLayout(new BorderLayout());

        this.add(teeOtsikko(), BorderLayout.NORTH);
        this.add(teeInput(), BorderLayout.CENTER);
    }

    private JPanel teeOtsikko() {
        JPanel paneeli = new JPanel();

        JLabel otsikko = new JLabel("Aikataulutettujen kurssien tallennus");
        paneeli.add(otsikko);

        return paneeli;
    }

    private JPanel teeInput() {
        JPanel lomake = new JPanel();
        lomake.setLayout(new GridLayout(9, 1));

        JLabel nimiLabel = new JLabel("Kurssin nimi:");
        JTextField nimiTFiel = new JTextField(kurssit.get(0).getNimi());
        lomake.add(nimiLabel);
        lomake.add(nimiTFiel);

        JLabel arvosanaLabel = new JLabel("Kurssista saatu arvosana kokonaislukuna taikka \"hyväksyttynä\"");
        JTextField arvosanaTFiel = new JTextField();
        lomake.add(arvosanaLabel);
        lomake.add(arvosanaTFiel);

        JLabel noppaLabel = new JLabel("Kurssista saadut nopat:");
        JTextField noppaTFiel = new JTextField();
        lomake.add(noppaLabel);
        lomake.add(noppaTFiel);

        JLabel aikaLabel = new JLabel("Kurssin suoritusaika esim. \"Syksy 2015\" tai \"20.03.2015\"");
        JTextField aikaTFiel = new JTextField();
        lomake.add(aikaLabel);
        lomake.add(aikaTFiel);

        JPanel napit = new JPanel();

        JButton hylkaa = new JButton("Hylkää");
        JButton tallenna = new JButton("Tallenna");

        Kuuntelija kuuntelija = new Kuuntelija(nimiTFiel, arvosanaTFiel, noppaTFiel, aikaTFiel, hylkaa, tallenna, kurssit);

        hylkaa.addActionListener(kuuntelija);
        tallenna.addActionListener(kuuntelija);

        napit.add(hylkaa);
        napit.add(tallenna);

        lomake.add(napit);

        return lomake;
    }
}

class Kuuntelija implements ActionListener {

    private final JButton tallenna;
    private final JButton hylkaa;
    private JTextField nimiField;
    private JTextField arvosanaField;
    private JTextField noppaField;
    private JTextField aikaField;
    private int index;
    private final List<KaynnissaOlevaKurssi> kurssit;

    Kuuntelija(JTextField nimiTFiel, JTextField arvosanaTFiel, JTextField noppaTFiel, JTextField aikaTFiel, JButton hylkaa, JButton tallenna, List<KaynnissaOlevaKurssi> kurssit) {
        this.tallenna = tallenna;
        this.hylkaa = hylkaa;
        this.nimiField = nimiTFiel;
        this.arvosanaField = arvosanaTFiel;
        this.noppaField = noppaTFiel;
        this.aikaField = aikaTFiel;
        this.index = 0;
        this.kurssit = kurssit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hylkaa) {
            seuraava();
        }

        if (e.getSource() == tallenna) {
            try {
                luoUusiValmisKurssi();
                seuraava();
            } catch (Exception ex) {
                if (ex instanceof NumberFormatException) {
                    UI.virheDialog("Noppamäärä ei saa olla tekstiä!");
                    noppaField.setText("");
                } else {
                    UI.virheDialog("Kurssin tiedot virheellisiä. Kurssia ei tallennettu!\n" + ex.getMessage());
                }
            }
        }
    }

    private void luoUusiValmisKurssi() throws NumberFormatException, Exception {
        String arvosana = arvosanaField.getText();
        int nopat = Integer.parseInt(noppaField.getText());

        UusiValmisKurssiValidator uvkv = new UusiValmisKurssiValidator(nimiField.getText(), arvosana, nopat, aikaField.getText());
        uvkv.tarkastaInput();

        ValmisKurssi uusiKurssi = new ValmisKurssi(nimiField.getText(), arvosana, nopat, aikaField.getText());

        Ohjain.teeValmisKurssi(uusiKurssi);
    }

    private void seuraava() {
        if (kurssit.size() > index + 1) {
            nimiField.setText(kurssit.get(index + 1).getNimi());
            tyhjennaKentat();
            index++;
        } else {
            Ohjain.tyhjennaKalenteri();
            UI.luoKurssiNakyma();
        }
    }

    private void tyhjennaKentat() {
        this.aikaField.setText("");
        this.arvosanaField.setText("");
        this.noppaField.setText("");
    }

}
