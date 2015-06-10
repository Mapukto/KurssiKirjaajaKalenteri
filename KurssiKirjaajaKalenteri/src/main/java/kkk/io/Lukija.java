package kkk.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;
import kkk.ui.UI;

public class Lukija {

    private Scanner keskenOlevaSc;
    private Scanner valmiitSc;

    public void lueKeskenOlevatKurssit() {
        teeKeskenScanner();

        while (keskenOlevaSc.hasNextLine()) {
            String oneLine = keskenOlevaSc.nextLine();

            if (oneLine.equals("")) {
                continue;
            }

            String[] palat = oneLine.split("/");

            ArrayList<String> paivaLista = teeLista(palat, 0);
            ArrayList<String> aikaLista = teeLista(palat, 1);
            
            String nimi = palat[0];
            String nickName = palat[1];

            String[] paivat = muutaArrayListStringTauluksi(paivaLista);
            String[] ajat = muutaArrayListStringTauluksi(aikaLista);

            luoKaynnissaOlevaKurssi(nimi, nickName, paivat, ajat);
        }

        keskenOlevaSc.close();
    }

    /**
     * Luetaan tiedostosta kurssiin liittyvät aikavaraukset. Kurssi on
     * tallennettu muodossa nimi/lyhenne/pva 1/aika 1/pva 2/aika 2/.../pva
     * n/aika n
     * 
     * jos int aika on 0, täytetään lista päivillä. Jos aika on 1, täytetään
     * lista ajoilla.
     */
    private ArrayList<String> teeLista(String[] palat, int aika) {
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 2; i < palat.length; i++) {
            if (i % 2 == 0) {
                lista.add(palat[i + aika]);
            }
        }

        return lista;
    }

    private String[] muutaArrayListStringTauluksi(ArrayList<String> paivaLista) {
        String[] paivat = new String[paivaLista.size()];
        paivat = paivaLista.toArray(paivat);
        return paivat;
    }

    private void luoKaynnissaOlevaKurssi(String nimi, String nickName, String[] paivat, String[] ajat) {
        Ohjain.tallennaTiedostostaKeskenErainenKurssi(new KaynnissaOlevaKurssi(nimi, nickName, new AikaVaraus(paivat, ajat)));
    }

    public void lueValmiitKurssit() {
        teeValmisScanner();

        while (valmiitSc.hasNextLine()) {
            String oneLine = valmiitSc.nextLine();

            if (oneLine.equals("")) {
                continue;
            }

            String[] palat = oneLine.split("/");

            String nimi = palat[0];
            String arvosana = palat[1];

            int nopat = Integer.parseInt(palat[2]);

            String aika = palat[3];

            ValmisKurssi uusiKurssi = new ValmisKurssi(nimi, arvosana, nopat, aika);
            Ohjain.tallennaTiedostostaValmisKurssi(uusiKurssi);
        }

        valmiitSc.close();
    }

    private void teeValmisScanner() {
        try {
            valmiitSc = new Scanner(new File("files/valmiit.txt"));
        } catch (Exception e) {
            UI.virheDialog(e.getLocalizedMessage());
        }
    }

    private void teeKeskenScanner() {
        try {
            keskenOlevaSc = new Scanner(new File("files/kaynnissaOlevat.txt"));
        } catch (FileNotFoundException ex) {
            UI.virheDialog(ex.getLocalizedMessage());
        }
    }
}
