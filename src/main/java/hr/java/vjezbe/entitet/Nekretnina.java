package hr.java.vjezbe.entitet;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

import java.math.BigDecimal;

public interface Nekretnina {
    default BigDecimal izracunajPorez(BigDecimal cijenaNekretnine){
        if (cijenaNekretnine.compareTo(BigDecimal.valueOf(10000))==1){
            return cijenaNekretnine.multiply(BigDecimal.valueOf(0.03));
        }else throw new CijenaJePreniskaException("Cijena je preniska. Molim provjeriti!");
    }
}
