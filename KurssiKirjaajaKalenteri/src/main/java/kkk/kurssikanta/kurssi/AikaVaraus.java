package kkk.kurssikanta.kurssi;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Tämä luokka rakentaa aikavarauksen, jossa hashmappiin laitetaan avaimeksi
 * päivä, jolla on arvonaan joukko varattuja tunteja. Kirjoitusasumap on
 * samanlainen, mutta arvona on ajat String muodossa helpottamaan aikavarauksen
 * tallennusta tiedostoon.
 *
 * @author maot
 */
public class AikaVaraus {

    private final String[] rawPvat;
    private final String[] rawAjat;

    private final HashMap<Integer, HashSet<Integer>> aikaMap;
    private HashMap<Integer, HashSet<String>> kirjoitusAsuMap;

    /**
     * AikaVaraus saa parametriksi listan päiviä ja aikoja. pva[n] on aika[n]
     * kuuluva päivä.
     *
     * @param pva lista päivistä
     * @param ajat lista ajoista
     */
    public AikaVaraus(String[] pva, String[] ajat) {
        this.rawAjat = ajat;
        this.rawPvat = pva;
        aikaMap = new HashMap<>();
        kirjoitusAsuMap = new HashMap<>();
        teePva();
        teeKirjoitusAsu();
    }

    public HashMap<Integer, HashSet<String>> getKirjoitusAsuMap() {
        return kirjoitusAsuMap;
    }

    /**
     * luo hashmap -palasen, jossa avaimena päivä ja arvona vastaavan päivän
     * varattuna olevat tunnit
     */
    private void teePva() {
        for (int i = 0; i < rawPvat.length; i++) {
            if (rawPvat[i].equals("maanantai") || rawPvat[i].equals("1")) {
                if (!aikaMap.containsKey(1)) {
                    luoPva(1, i);
                }
            } else if (rawPvat[i].equals("tiistai") || rawPvat[i].equals("2")) {
                if (!aikaMap.containsKey(2)) {
                    luoPva(2, i);
                }
            } else if (rawPvat[i].equals("keskiviikko") || rawPvat[i].equals("3")) {
                if (!aikaMap.containsKey(3)) {
                    luoPva(3, i);
                }
            } else if (rawPvat[i].equals("torstai") || rawPvat[i].equals("4")) {
                if (!aikaMap.containsKey(4)) {
                    luoPva(4, i);
                }
            } else if (rawPvat[i].equals("perjantai") || rawPvat[i].equals("5")) {
                if (!aikaMap.containsKey(5)) {
                    luoPva(5, i);
                }
            }
        }
    }

    private void luoPva(int nro, int i) {
        aikaMap.put(nro, new HashSet<Integer>());
        laitaTunnit(nro, rawAjat[i]);

        kirjoitusAsuMap.put(nro, new HashSet<String>());
        kirjoitusAsuMap.get(nro).add(rawAjat[i]);
    }

    public HashMap<Integer, HashSet<Integer>> getAikaMap() {
        return aikaMap;
    }

    private void laitaTunnit(int i, String paramAjat) {
        String[] ajat = paramAjat.split("-");

        int alku = Integer.parseInt(ajat[0]);
        int loppu = Integer.parseInt(ajat[1]);
        int erotus = loppu - alku;

        for (int j = 0; j < erotus; j++) {
            aikaMap.get(i).add(alku + j);
        }
    }
    
    /**
     * Luokka tarkastaa onko tietty päivä tiettynä aikana varattuna.
     * 
     * @param pva etsittää päivä
     * @param tunti etsittävä aika
     * @return true jos on varattu, false jos ei ole.
     */
    public boolean onkoVarattu(int pva, int tunti) {
        if (!aikaMap.containsKey(pva)) {
            return false;
        }
        return aikaMap.get(pva).contains(tunti);
    }

    private void teeKirjoitusAsu() {

    }
}
