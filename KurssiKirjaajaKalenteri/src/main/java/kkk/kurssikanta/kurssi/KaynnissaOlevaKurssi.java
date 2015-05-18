/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkk.kurssikanta.kurssi;

import java.util.Map;

/**
 *
 * @author mopo
 */
public class KaynnissaOlevaKurssi extends Kurssi {
    private final Map ajat;
    
    /**
     * 
     * @param nimi
     * @param ajat
     */
    public KaynnissaOlevaKurssi(String nimi, Map ajat) {
        super(nimi);
        this.ajat = ajat;
    }
    
}
