
package kkk.io;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.annotation.Resource;
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
            
            if (oneLine.equals("")) continue;
            
            String[] palat = oneLine.split("/");
            
            ArrayList<String> paivaLista = new ArrayList<>();
            ArrayList<String> aikaLista = new ArrayList<>();
            
            /**
             * Luetaan tiedostosta kurssiin liittyvät aikavaraukset.
             * Kurssi on tallennettu muodossa nimi/lyhenne/pva 1/aika 1/pva 2/aika 2/.../pva n/aika n
             */
            String nimi = palat[0];
            String nickName = palat[1];
            
            for (int i = 2; i < palat.length; i++) {
                if (i % 2 == 0) {
                    paivaLista.add(palat[i]);
                } else {
                    aikaLista.add(palat[i]);
                }
            }
            
            String[] paivat = muutaArrayListStringTauluksi(paivaLista);
            String[] ajat = muutaArrayListStringTauluksi(aikaLista);
            
            luoKaynnissaOlevaKurssi(nimi, nickName, paivat, ajat);
        }
        
        keskenOlevaSc.close();
    }

    private String[] muutaArrayListStringTauluksi(ArrayList<String> paivaLista) {
        String[] paivat = new String[paivaLista.size()];
        paivat = paivaLista.toArray(paivat);
        return paivat;
    }

    private void teeKeskenScanner() {
        try {
            keskenOlevaSc = new Scanner(new File("src/main/java/kkk/io/kaynnissaOlevat.txt"));
        } catch (FileNotFoundException ex) {
            UI.virheDialog(ex.getLocalizedMessage());
        }
    }

    private void luoKaynnissaOlevaKurssi(String nimi, String nickName, String[] paivat, String[] ajat) {
        Ohjain.tallennaTiedostostaKeskenErainenKurssi(new KaynnissaOlevaKurssi(nimi, nickName, new AikaVaraus(paivat, ajat)));
    }
    
    
    public void lueValmiitKurssit() {
        teeValmisScanner();
        
        while (valmiitSc.hasNextLine()) {
            String oneLine = valmiitSc.nextLine();
            
            if (oneLine.equals("")) continue;
            
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
            valmiitSc = new Scanner(new File("src/main/java/kkk/io/valmiit.txt"));
        } catch (Exception e) {
            UI.virheDialog(e.getLocalizedMessage());
        }
    }
}
