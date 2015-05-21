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

    /**
     * tallennetaan valmis kurssi tiedostoon
     * @param kurssi tallennettava kurssi
     */
    public void tallennaValmisKurssi(ValmisKurssi kurssi) {
        try {
            valmiitWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/valmiit.txt", true));
            
            String kurssiTiedot = kurssi.getNimi() + ":" + kurssi.getArvosana() + ":" + kurssi.getNopat();
            
            valmiitWriter.write(kurssiTiedot + "\n");
            valmiitWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * tallennetaan keskeneräinen kurssi
     * @param kurssi tallennettava kurssi
     */
    public void tallennaKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        try {
            keskenWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/kaynnissaOlevat.txt", true));
            
            /**
             * kirjoitusasu: Kurssin nimi/pva1/aika1/pva2/aika2/...../pvaN/aikaN
             */
            String ajatKirjoitusAsussa = teeAjatKirjoitusAsu(kurssi);

            keskenWriter.write(ajatKirjoitusAsussa);
            keskenWriter.close();
        } catch (Exception e) {
            System.out.println("kesken eräisen kurrsin kirjoitus kusee");
        }
    }

    /**
     * tehdään keskeneräisen kurssin kirjoitusasu muotoon Kurssin nimi/pva1/aika1/pva2/aika2/...../pvaN/aikaN
     * @param kurssi tallennettava kurssi
     * @return tallennettava String
     */
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
        return kirjoitusAsu.toString();
    }
}
