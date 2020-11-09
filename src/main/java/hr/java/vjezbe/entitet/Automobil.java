package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Automobil extends Artikl implements Vozilo {

    private BigDecimal snagaKs;

    public Automobil(String naslov, String opis, BigDecimal cijena, BigDecimal snagaKs) {
        super(naslov, opis, cijena);
        this.snagaKs = snagaKs;
    }

    public BigDecimal getSnagaKs() {
        return snagaKs;
    }

    public void setSnagaKs(BigDecimal snagaKs) {
        this.snagaKs = snagaKs;
    }

    @Override
    public BigDecimal izracunajGrupuOsiguranja() {
        if(snagaKs.compareTo(BigDecimal.valueOf(100))==-1){
            return BigDecimal.valueOf(1);
        }else if(snagaKs.compareTo(BigDecimal.valueOf(250))==-1){
            return BigDecimal.valueOf(2);
        }else if(snagaKs.compareTo(BigDecimal.valueOf(400))==-1){
            return BigDecimal.valueOf(3);
        }else if(snagaKs.compareTo(BigDecimal.valueOf(550))==-1){
            return BigDecimal.valueOf(4);
        }else return BigDecimal.valueOf(5);
    }

    @Override
    public String tekstOglasa() {
        return "Naslov automobila: "+getNaslov()+System.lineSeparator()+
                "Opis automobila: "+getOpis()+System.lineSeparator()+
                "Snaga automobila: "+getSnagaKs()+System.lineSeparator()+
                "Izracun osiguranja automobila: "+izracunajCijenuOsiguranja()+System.lineSeparator()+
                "Cijena automobila: "+getCijena();
    }
}
