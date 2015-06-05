
package kkk.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ohjain.Ohjain;

public class Lukija {
    private Scanner keskenOlevaSc;
    private Scanner valmiitSc;
    
    public void lueKeskenOlevatKurssit() {
        try {
            keskenOlevaSc = new Scanner(new File("src/main/java/kkk/io/kaynnissaOlevat.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("kesken olevien luku kusee");
        }
        
        while (keskenOlevaSc.hasNextLine()) {
            String oneLine = keskenOlevaSc.nextLine();
            
            if (oneLine.equals("")) continue;
            
            String[] palat = oneLine.split("/");
            
            ArrayList<String> paivaLista = new ArrayList<>();
            ArrayList<String> aikaLista = new ArrayList<>();
            
            String nimi = palat[0];
            
            String nickName = palat[1];
            
            for (int i = 2; i < palat.length; i++) {
                if (i % 2 == 0) {
                    paivaLista.add(palat[i]);
                } else {
                    aikaLista.add(palat[i]);
                }
            }
            
            String[] paivat = new String[paivaLista.size()];
            paivat = paivaLista.toArray(paivat);
            
            String[] ajat = new String[aikaLista.size()];
            ajat = aikaLista.toArray(ajat);
            
            KaynnissaOlevaKurssi newKurssi = new KaynnissaOlevaKurssi(nimi, nickName, new AikaVaraus(paivat, ajat));
            Ohjain.tallennaTiedostostaKeskenErainenKurssi(newKurssi);
        }
    }
    
    public void lueValmiitKurssit() {
        try {
            valmiitSc = new Scanner(new File("src/main/java/kkk/io/valmiit.txt"));
        } catch (Exception e) {
            System.out.println("valmiiden luku kusee");
        }
        
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
    }
}
