package kkk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kkk.kurssikanta.kurssi.AikaVaraus;
import kkk.kurssikanta.kurssi.KaynnissaOlevaKurssi;
import kkk.kurssikanta.kurssi.ValmisKurssi;
import kkk.ui.UI;

/**
 * Luokka hallinnoi kurssien tallettamista tiedostoihin. 
 * @author mopo
 */
public class Kirjoittaja {

    private BufferedWriter valmiitWriter;
    private BufferedWriter keskenWriter;
    
    /**
     * Tyhjentää koko lukujärjestyksen. 
     */
    public void tyhjennaKalenteri() {
        try {
            luoKeskenWriter(false);
            
            keskenWriter.write("");
            keskenWriter.close();
        } catch (Exception e) {
            UI.virheDialog("Kirjoittajan luonti epÃƒÂ¤onnistunut!");
        }
    }
    
    /**
     * tallennetaan valmis kurssi tiedostoon
     *
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
            UI.virheDialog("Kirjoittajan luonti epÃƒÂ¤onnistunut!");
        }
    }

    private void luoValmiitWriter(boolean append) throws IOException {
        valmiitWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/valmiit.txt", append));
    }

    /**
     * kesken erÃƒÂ¤isen kurssin tallennus tiedostoon
     *
     * @param kurssi tallennettava kurssi
     */
    public void tallennaKeskenErainenKurssi(KaynnissaOlevaKurssi kurssi) {
        try {
            luoKeskenWriter(true);

            /**
             *
             */
            String ajatKirjoitusAsussa = teeAjatKirjoitusAsu(kurssi);

            keskenWriter.write(ajatKirjoitusAsussa);
            keskenWriter.newLine();
            keskenWriter.close();
        } catch (Exception e) {
            UI.virheDialog("Kirjoittajan luonti epÃƒÂ¤onnistunut");
        }
    }

    private void luoKeskenWriter(boolean append) throws IOException {
        keskenWriter = new BufferedWriter(new FileWriter("src/main/java/kkk/io/kaynnissaOlevat.txt", append));
    }

    /**
     * tehdÃƒÂ¤ÃƒÂ¤n keskenerÃƒÂ¤isen kurssin kirjoitusasu muotoon Kurssin
     * nimi/lyhennetty nimi/luokka huone/pva1/aika1/pva2/aika2/...../pvaN/aikaN
     *
     * @param kurssi tallennettava kurssi
     * @return tallennettava String
     */
    private String teeAjatKirjoitusAsu(KaynnissaOlevaKurssi kurssi) {
        StringBuilder kirjoitusAsu = new StringBuilder();
        AikaVaraus ajat = kurssi.getAikaVaraukset();
        HashMap<Integer, HashSet<String>> aikaMap = ajat.getKirjoitusAsuMap();

        kirjoitusAsu.append(kurssi.getNimi()).append("/");
        kirjoitusAsu.append(kurssi.getNickName());

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

    /**
     * 
     *
     * @param index
     */
    public void poistaKurssi(int index) {
        try {
            suoritaPoisto(index);
        } catch (IOException e) {
            UI.virheDialog("Kurssin poisto epÃ¤onnistui!\n" + e.getMessage());
        }
    }
    
    /**
     * poistetaan tiedostosta @param index:sÃƒÂ¤s rivi. Luodaan tmp file, johon 
     * kirjoitetaan hulutut tiedot, poistetaan vanha tiedosto ja uudelleen nimetÃƒÂ¤ÃƒÂ¤n
     * tmp file vanhan tiedoston nimiseksi.
     * @param index kertoo monesko rivi poistetaan
     * @throws IOException 
     */
    private void suoritaPoisto(int index) throws IOException {
        File tmp = new File("src/main/java/kkk/io/tmp.txt");
        
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/kkk/io/valmiit.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        
        for (int i = 0; i < index; i++) {
            bw.write(br.readLine());
            bw.newLine();
        }
        
        //skippaa poistettavan rivin
        br.readLine();
        
        String newLine;
        
        while (null != (newLine = br.readLine())) {
            bw.write(newLine);
            bw.newLine();
        }
        
        bw.close();
        br.close();
        
        File oldFile = new File("src/main/java/kkk/io/valmiit.txt");
        
        if (oldFile.delete()) {
            tmp.renameTo(oldFile);
        } 
    }
}
