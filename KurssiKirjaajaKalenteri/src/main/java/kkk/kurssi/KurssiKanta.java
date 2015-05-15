package kkk.kurssi;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mopo
 */

class KurssiKanta {

    private List<Kurssi> kurssiLista;
    private List<Kurssi> keskenOlevat;
    
    /**
     *  luonnin yhteydessä luetaan tallennetut kurssit tiedostosta ja täytetään listat
     *  
     */
    public KurssiKanta() {
        
    }
    

    /**
     *  tarkastetaan, ettei samannimistä kurssia ole jo listassa.
     *  jos saman niminen löytyy, kurssi "muokataan", eli vanha poistetaan ja lisätään
     *  uusi listaan.
     * 
     */
    public void lisaaKurssi(Kurssi kurssi) {
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

    private void poistaKurssi(String nimi) {
        for (Kurssi kurssiLista1 : kurssiLista) {
            if (kurssiLista1.getNimi().equals(nimi)) {
                kurssiLista.remove(kurssiLista1);
            }
        }
    }

    /**
     *  muokkaa listaa poistamalla vanhan ja lisäämällä uuden,
     jottei duplikaatteja olisi.
     */
    private void muokkaaKurssia(int i, Kurssi kurssi) {
        kurssiLista.remove(i);
        kurssiLista.add(kurssi);
    }

}
