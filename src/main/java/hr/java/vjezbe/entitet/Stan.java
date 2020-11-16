package hr.java.vjezbe.entitet;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Stan extends Artikl implements Nekretnina{
    private static final Logger logger = LoggerFactory.getLogger(Stan.class);
    private int kvadratura;

    public Stan(String naslov, String opis, BigDecimal cijena, int kvadratura) {
        super(naslov, opis, cijena);
        this.kvadratura = kvadratura;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    @Override
    public String tekstOglasa() {
        String tekstOpis = "Naslov nekretnine: "+getNaslov()+System.lineSeparator()+
                "Opis nekretnine: "+getOpis()+System.lineSeparator()+
                "Kvadratura nekretnine: "+getKvadratura();
        String tekstOsiguranja;
        try {
            tekstOsiguranja ="Porez na nekretnine: "+izracunajPorez(getCijena());
        } catch (CijenaJePreniskaException ex){
            tekstOsiguranja ="Porez na nekretnine: Cijena ne smije biti manja od 10 000 kn. Molim provjeriti!";
            logger.error("Pogreška prilikom određivanja iznosa poreza!", ex);
        }
        String tekstCijena = "Cijena nekretnine: "+getCijena();
        return tekstOpis + System.lineSeparator()+ tekstOsiguranja + System.lineSeparator()+ tekstCijena;
    }
}
