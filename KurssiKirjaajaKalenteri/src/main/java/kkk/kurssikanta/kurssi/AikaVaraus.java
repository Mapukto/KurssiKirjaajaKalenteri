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
     * luo hashmapin, jossa avaimena päivä ja arvona vastaavan päivän varattuna
     * olevat tunnit
     */
    private void teePva() {
        for (int i = 0; i < rawPvat.length; i++) {
            if (rawPvat[i].equals("ma") || rawPvat[i].equals("1")) {
                if (!aikaMap.containsKey(1)) {
                    aikaMap.put(1, new HashSet<Integer>());
                    laitaTunnit(1, rawAjat[i]);
                }
            } else if (rawPvat[i].equals("ti") || rawPvat[i].equals("2")) {
                if (!aikaMap.containsKey(2)) {
                    aikaMap.put(2, new HashSet<Integer>());
                    laitaTunnit(2, rawAjat[i]);
                }
            } else if (rawPvat[i].equals("ke") || rawPvat[i].equals("3")) {
                if (!aikaMap.containsKey(3)) {
                    aikaMap.put(3, new HashSet<Integer>());
                    laitaTunnit(3, rawAjat[i]);
                }
            } else if (rawPvat[i].equals("to") || rawPvat[i].equals("4")) {
                if (!aikaMap.containsKey(4)) {
                    aikaMap.put(4, new HashSet<Integer>());
                    laitaTunnit(4, rawAjat[i]);
                }
            } else if (rawPvat[i].equals("pe") || rawPvat[i].equals("5")) {
                if (!aikaMap.containsKey(5)) {
                    aikaMap.put(5, new HashSet<Integer>());
                    laitaTunnit(5, rawAjat[i]);
                }
            } else {
                System.out.println("Ei kelpaa");
            }
        }
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
