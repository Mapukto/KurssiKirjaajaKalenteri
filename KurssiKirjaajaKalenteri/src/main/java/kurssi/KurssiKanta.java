
package kurssi;

import java.util.ArrayList;
import java.util.List;

class KurssiKanta {
    private List<Kurssi> kurssiLista = new ArrayList<Kurssi>();
    
    public void lisaaKurssi(Kurssi kurssi) {
        
        /*
         *  tarkastetaan, ettei samannimistä kurssia ole jo listassa.
         *  jos saman niminen löytyy, kurssi "muokataan", eli vanha poistetaan ja lisätään
         *  uusi listaan.
         * 
         */
        int i = 0;
        
        for (Kurssi listanKurssi : kurssiLista) {
            if (listanKurssi.getNimi().equals(kurssi.getNimi())) {
                muokkaaKurssia(i, kurssi);
                return;
            }
            i++;
        }
        kurssiLista.add(kurssi);
    }
    
    
    /*
     *  muokkaa listaa poistamalla vanhan ja lisäämällä uuden,
        jottei duplikaatteja olisi.
     */
    private void muokkaaKurssia(int i, Kurssi kurssi) {
        kurssiLista.remove(i);
        kurssiLista.add(kurssi);
    }
    
}
