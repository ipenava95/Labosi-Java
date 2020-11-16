package hr.java.vjezbe.entitet;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Automobil extends Artikl implements Vozilo {
    private static final Logger logger = LoggerFactory.getLogger(Vozilo.class);
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
    public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
        if(snagaKs.compareTo(BigDecimal.valueOf(0))==1){
            if(snagaKs.compareTo(BigDecimal.valueOf(100))==-1){
                return BigDecimal.valueOf(1);
            }else if(snagaKs.compareTo(BigDecimal.valueOf(250))==-1){
                return BigDecimal.valueOf(2);
            }else if(snagaKs.compareTo(BigDecimal.valueOf(400))==-1){
                return BigDecimal.valueOf(3);
            }else if(snagaKs.compareTo(BigDecimal.valueOf(550))==-1){
                return BigDecimal.valueOf(4);
            }else return BigDecimal.valueOf(5);
        }else throw new NemoguceOdreditiGrupuOsiguranjaException("Negativna vrijednost unosa snage. Molim provjeriti!");
    }

    @Override
    public String tekstOglasa(){
        String tekstOpis = "Naslov automobila: "+getNaslov()+System.lineSeparator()+
                "Opis automobila: "+getOpis()+System.lineSeparator()+
                "Snaga automobila: "+getSnagaKs();
        String tekstOsiguranja;
        try {
            tekstOsiguranja ="Izracun osiguranja automobila: "+izracunajCijenuOsiguranja();
        } catch (NemoguceOdreditiGrupuOsiguranjaException ex){
            tekstOsiguranja ="Izracun osiguranja automobila: Negativan unos snage. Nemoguce odrediti grupu osiguranja. Molim provjeriti!";
            logger.error("Pogreška prilikom izračuna osiguranja!", ex);
        }
        String tekstCijena = "Cijena automobila: "+getCijena();
        return tekstOpis + System.lineSeparator()+ tekstOsiguranja + System.lineSeparator()+ tekstCijena;
    }
}
