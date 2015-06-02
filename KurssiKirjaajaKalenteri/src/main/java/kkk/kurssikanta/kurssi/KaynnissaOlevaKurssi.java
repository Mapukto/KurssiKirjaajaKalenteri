package kkk.kurssikanta.kurssi;

/**
 *
 * @author mopo
 */
public class KaynnissaOlevaKurssi extends Kurssi {
    private final AikaVaraus ajat;
    private final String nickName;
    
    /**
     * 
     * @param nimi
     * @param nickName
     * @param ajat
     */
    public KaynnissaOlevaKurssi(String nimi, String nickName, AikaVaraus ajat) {
        super(nimi);
        this.ajat = ajat;
        this.nickName = nickName;
    }
    
    public String getNickName() {
        return this.nickName;
    }
    
    public boolean onkoVarattu(int pva, int tunti) {
        return this.ajat.onkoVarattu(pva, tunti);
    }
    
    public AikaVaraus getAikaVaraukset() {
        return this.ajat;
    }
    
    /**
     *
     * @return palauttaa nimen
     */
    @Override
    public String getNimi() {
        return super.getNimi();
    }
}
