package kkk.kurssikanta.kurssi;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author mopo
 */
public class AikaVaraus {
    private final String[] rawPvat;
    private final String[] rawAjat;

    private final HashMap<Integer, HashSet<Integer>> aikaMap;

    public AikaVaraus(String[] pva, String[] ajat) {
        this.rawAjat = ajat;
        this.rawPvat = pva;
        aikaMap = new HashMap<>();
        teePva();
    }
    
    /**
     * luo hashmap -palasen, jossa avaimena päivä ja arvona vastaavan päivän varattuna
     * olevat tunnit
     */
    private void teePva() {
        for (int i = 0; i < rawPvat.length; i++) {
            if (rawPvat[i].equals("ma") || rawPvat[i].equals("1")) {
                if (!aikaMap.containsKey(1)) {
                    luoPva(1, i);
                }
            } else if (rawPvat[i].equals("ti") || rawPvat[i].equals("2")) {
                if (!aikaMap.containsKey(2)) {
                    luoPva(2, i);
                }
            } else if (rawPvat[i].equals("ke") || rawPvat[i].equals("3")) {
                if (!aikaMap.containsKey(3)) {
                    luoPva(3, i);
                }
            } else if (rawPvat[i].equals("to") || rawPvat[i].equals("4")) {
                if (!aikaMap.containsKey(4)) {
                    luoPva(4, i);
                }
            } else if (rawPvat[i].equals("pe") || rawPvat[i].equals("5")) {
                if (!aikaMap.containsKey(5)) {
                    luoPva(5, i);
                }
            } else {
                System.out.println("Ei kelpaa");
            }
        }
    }

    private void luoPva(int nro, int i) {
        aikaMap.put(nro, new HashSet<Integer>());
        laitaTunnit(nro, rawAjat[i]);
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

    public boolean onkoVarattu(int pva, int tunti) {
        if (!aikaMap.containsKey(pva)) {
            return false;
        }
        return aikaMap.get(pva).contains(tunti);
    }
}
