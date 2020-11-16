package hr.java.vjezbe.entitet;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

import java.math.BigDecimal;

public interface Vozilo {

    default BigDecimal izracunajKw(BigDecimal snaga){
        return snaga.multiply(BigDecimal.valueOf(1.359621617));
    }

    BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;

    default BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException{
        switch (String.valueOf(izracunajGrupuOsiguranja())){
            case "1":
                return BigDecimal.valueOf(1000);
            case "2":
                return BigDecimal.valueOf(2000);
            case "3":
                return BigDecimal.valueOf(3000);
            case "4":
                return BigDecimal.valueOf(4000);
            case "5":
                return BigDecimal.valueOf(5000);
            default:
                System.out.println("Grupa osiguranja je nepostojeca. Molim provjeriti!");
                return BigDecimal.valueOf(0);
        }
    }
}
