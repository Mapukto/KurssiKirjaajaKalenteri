package kkk.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;

public class Kirjoittaja {

    private BufferedWriter valmiitWriter;
    private BufferedWriter keskenWriter;
    private Scanner sc;

    /**
     * tallennetaan valmis kurssi tiedostoon
     * @param kurssi tallennettava kurssi
     */
    public void tallennaValmisKurssi(ValmisKurssi kurssi) {
        try {
            luoValmiitWriter(true);
            
            String kurssiTiedot = kurssi.getNimi() + "/" + kurssi.getArvosana() + "/" + kurssi.getNopat() + "/" + kurssi.getSuoritusAika();
            
            valmiitWriter.write(kurssiTiedot);
            valmiitWriter.newLine();
            valmiitWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void luoValmiitWriter(boolean append) throws IOException {
        valmiitWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/valmiit.txt", append));
    }

    /**
     * tallennetaan keskeneräinen kurssi
     * @param kurssi tallennettava kurssi
     */
    public void tallennaKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        try {
            luoKeskenWriter(true);
            
            /**
             * kirjoitusasu: Kurssin nimi/pva1/aika1/pva2/aika2/...../pvaN/aikaN
             */
            String ajatKirjoitusAsussa = teeAjatKirjoitusAsu(kurssi);

            keskenWriter.write(ajatKirjoitusAsussa);
            keskenWriter.newLine();
            keskenWriter.close();
        } catch (Exception e) {
            System.out.println("kesken eräisen kurrsin kirjoitus kusee");
        }
    }

    private void luoKeskenWriter(boolean append) throws IOException {
        keskenWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/kaynnissaOlevat.txt", append));
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

        return kirjoitusAsu.toString();
    }

    public void poistaKurssi(int index) {
        try {
            luoValmiitWriter(false);
            luoScanner("src/main/java/kkk/io/valmiit.txt");
            
            for (int i = 0; i < index; i++) {
                String oneLine = sc.nextLine();
                valmiitWriter.write(oneLine);
                valmiitWriter.newLine();
            }
            
            valmiitWriter.write("");
            valmiitWriter.close();
        } catch (Exception e) {
            System.out.println("kurssin poisto ei toimi");
        }
    }

    private void luoScanner(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
    }
}

    /*
penis/5/5/penis
kissa/5/5/kissa
pilu/5/5/pilu
    */