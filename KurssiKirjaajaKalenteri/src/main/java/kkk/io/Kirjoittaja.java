package kkk.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;

public class Kirjoittaja {

    private BufferedWriter valmiitWriter;
    private BufferedWriter keskenWriter;

    public Kirjoittaja() {
    }

    private void luoValmiitKirjoittaja() throws IOException {
        valmiitWriter = new BufferedWriter(new FileWriter(new File("valmiit.txt"), true));
    }

    private void luoKeskenKirjoittaja() throws IOException {
        keskenWriter = new BufferedWriter(new FileWriter(new File("keskenEraiset"), true));
    }

    public void tallennaValmisKurssi(ValmisKurssi kurssi) {
        try {
            luoValmiitKirjoittaja();
            
            String kurssiTiedot = kurssi.getNimi() + ":" + kurssi.getArvosana() + ":" + kurssi.getNopat();
            valmiitWriter.write(kurssiTiedot + "\n");
            valmiitWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void tallennaKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {

        try {
            luoKeskenKirjoittaja();
            
            String aikaMap = teeAjatKirjoitusAsu(kurssi);

            keskenWriter.write(aikaMap);
            keskenWriter.close();
            System.out.println("on suljettu");
        } catch (Exception e) {
            System.out.println("kesken eräisen kurrsin kirjoitus kusee");
        }

    }

    private String teeAjatKirjoitusAsu(KaynnissaOlevaKurssi kurssi) {
        StringBuilder kirjoitusAsu = new StringBuilder(kurssi.getNimi());
        AikaVaraus ajat = kurssi.getAikaVaraukset();
        HashMap<Integer, HashSet<Integer>> aikaMap = ajat.getAikaMap();

        for (int i = 1; i < 6; i++) {
            if (!aikaMap.containsKey(i)) {
                continue;
            }
            Set tunnit = aikaMap.get(i);
            for (Object t : tunnit) {
                kirjoitusAsu.append("/").append(i).append("/").append(t);
            }
        }

        kirjoitusAsu.append("\n");
        System.out.println(kirjoitusAsu.toString());
        return kirjoitusAsu.toString();
    }
}
