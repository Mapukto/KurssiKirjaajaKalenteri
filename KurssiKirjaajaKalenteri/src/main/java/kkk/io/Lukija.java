
package kkk.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
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
            String[] paivat = {};
            String[] ajat = {};
            
            String oneLine = keskenOlevaSc.nextLine();
            String[] palat = oneLine.split("/");
            
            String nimi = palat[0];
            
            int paivaIndex = 0;
            int aikaIndex = 0;
            
            for (int i = 1; i < palat.length; i++) {
                if (i % 2 != 0) {
                    paivat[paivaIndex] = palat[i];
                    paivaIndex++;
                } else {
                    ajat[aikaIndex] = palat[i];
                    aikaIndex++;
                }
            }
            
            KaynnissaOlevaKurssi newKurssi = new KaynnissaOlevaKurssi(nimi, new AikaVaraus(paivat, ajat));
            Ohjain.teeKeskenErainenKurssi(newKurssi);
        }
    }
}
