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
    
    public HashMap getAjat() {
        return aikaMap;
    }

    private void teePva() {
        for (int i = 0; i < rawPvat.length; i++) {
            switch (rawPvat[i]) {
                case "ma":
                    if (!aikaMap.containsKey(1)) {
                        aikaMap.put(1, new HashSet<Integer>());
                        laitaTunnit(1, rawAjat[i]);
                    }
                    break;
                case "ti":
                    if (!aikaMap.containsKey(2)) {
                        aikaMap.put(2, new HashSet<Integer>());
                        laitaTunnit(2, rawAjat[i]);
                    }
                    break;
                case "ke":
                    if (!aikaMap.containsKey(3)) {
                        aikaMap.put(3, new HashSet<Integer>());
                        laitaTunnit(3, rawAjat[i]);
                    }
                    break;
                case "to":
                    if (!aikaMap.containsKey(4)) {
                        aikaMap.put(4, new HashSet<Integer>());
                        laitaTunnit(4, rawAjat[i]);
                    }
                    break;
                case "pe":
                    if (!aikaMap.containsKey(5)) {
                        aikaMap.put(5, new HashSet<Integer>());
                        laitaTunnit(5, rawAjat[i]);
                    }
                    break;
            }
        }
    }

    private void laitaTunnit(int i, String rawAjat) {
        String[] ajat = rawAjat.split("-");
        
        int alku = Integer.parseInt(ajat[0]);
        int loppu = Integer.parseInt(ajat[1]);
        int erotus = loppu-alku;
        
        for (int j = 0; j < erotus; j++) {
            aikaMap.get(i).add(alku + j);
        }
    }
}
