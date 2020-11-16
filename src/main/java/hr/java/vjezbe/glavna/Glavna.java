package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Poziva sve pomoćne metode, traži unos podataka i ispisuje tekst oglasa.
 * @author svgip03
 */

public class Glavna {
    private static final Logger logger = LoggerFactory.getLogger(Glavna.class);
    private static int brojKorisnika;
    private static int brojKategorija;
    private static int brojArtikalaNaProdaju;
    private static Korisnik[] korisnici;
    private static int odabraniKorisnik;
    private static Kategorija[] kategorije;
    private static int odabranaKategorija;
    private static int odabraniArtikl;
    private static Korisnik[] odabraniKorisnici;
    private static Artikl[] odabraniArtikli;

    /**
     * Traži unos podataka o korisnicima.
     * @param scanner Scanner
     */
    private static void unesikorisnika(Scanner scanner){
        System.out.print("Unesite broj korisnika koji zelite unijeti: "); //trazi unos
        brojKorisnika = Integer.parseInt(scanner.nextLine()); //cita unos
        korisnici = new Korisnik[brojKorisnika];
        for(int i=1;i<=brojKorisnika;i++) {
            System.out.println("Unesite tip "+i+". korisnika:");
            System.out.println("1. Privatni");
            System.out.println("2. Poslovni");
            System.out.println("Odabir >>");
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    System.out.print("Unesite ime " + i + ". osobe: ");
                    String ime = scanner.nextLine();
                    System.out.print("Unesite prezime " + i + ". osobe: ");
                    String prezime = scanner.nextLine();
                    System.out.print("Unesite e-mail " + i + ". osobe: ");
                    String email1 = scanner.nextLine();
                    System.out.print("Unesite telefon " + i + ". osobe: ");
                    String telefon1 = scanner.nextLine();
                    korisnici[i - 1] = new PrivatniKorisnik(ime, prezime, email1, telefon1);
                    break;
                case 2:
                    System.out.print("Unesite naziv " + i + ". tvrtke: ");
                    String naziv = scanner.nextLine();
                    System.out.print("Unesite e-mail " + i + ". tvrtke: ");
                    String email2 = scanner.nextLine();
                    System.out.print("Unesite telefon " + i + ". tvrtke: ");
                    String telefon2 = scanner.nextLine();
                    System.out.print("Unesite web " + i + ". tvrtke: ");
                    String web = scanner.nextLine();
                    korisnici[i - 1] = new PoslovniKorisnik(email2, telefon2, naziv, web);
                    break;
                default:
                    System.out.println("Nepravilan unos! Molim izabrati 1 ili 2!");
                    i--;
                    break;
            }

        }
    }

    /**
     * Traži unos podataka o kategorijama i artiklima.
     * @param scanner Scanner
     */
    private static void unesiKategorije(Scanner scanner){
        System.out.print("Unesite broj kategorija koji zelite unijeti: ");
        brojKategorija = Integer.parseInt(scanner.nextLine());
        kategorije = new Kategorija[brojKategorija];
        int brojArtikala;
        int ukupanBrojArtikala = 0;
        for(int i=1;i<=brojKategorija;i++) {
            System.out.print("Unesite naziv " + i + ". kategorije: ");
            String naziv = scanner.nextLine();
            System.out.print("Unesite broj artikala koje zelite unijeti za unesenu kategoriju: ");
            brojArtikala = Integer.parseInt(scanner.nextLine());
            ukupanBrojArtikala = ukupanBrojArtikala + brojArtikala;
            Artikl[] artikli = new Artikl[brojArtikala];
            for (int j = 1; j <= brojArtikala; j++) {
                System.out.println("Unesite tip "+j+". artikla:");
                System.out.println("1. Usluga");
                System.out.println("2. Automobil");
                System.out.println("3. Stan");
                System.out.println("Odabir >>");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        System.out.print("Unesite naslov " + j + ". oglasa usluge: ");
                        String naslov1 = scanner.nextLine();
                        System.out.print("Unesite opis " + j + ". oglasa usluge: ");
                        String opis1 = scanner.nextLine();
                        System.out.print("Unesite cijenu " + j + ". oglasa usluge: ");
                        BigDecimal cijena1 = new BigDecimal(scanner.nextLine());
                        artikli[j - 1] = new Usluga(naslov1, opis1, cijena1);
                        break;
                    case 2:
                        System.out.print("Unesite naslov " + j + ". oglasa automobila: ");
                        String naslov2 = scanner.nextLine();
                        System.out.print("Unesite opis " + j + ". oglasa automobila: ");
                        String opis2 = scanner.nextLine();
                        System.out.print("Unesite cijenu " + j + ". oglasa automobila: ");
                        BigDecimal cijena2 = new BigDecimal(scanner.nextLine());
                        System.out.print("Unesite snagu " + j + ". oglasa automobila: ");
                        BigDecimal snaga = new BigDecimal(scanner.nextLine());
                        artikli[j - 1] = new Automobil(naslov2, opis2, cijena2, snaga);
                        break;
                    case 3:
                        System.out.print("Unesite naslov " + j + ". oglasa stana: ");
                        String naslov3 = scanner.nextLine();
                        System.out.print("Unesite opis " + j + ". oglasa stana: ");
                        String opis3 = scanner.nextLine();
                        System.out.print("Unesite kvadraturu " + j + ". oglasa stana: ");
                        int kvadratura = Integer.parseInt(scanner.nextLine());
                        System.out.print("Unesite cijenu " + j + ". oglasa stana: ");
                        BigDecimal cijena3 = new BigDecimal(scanner.nextLine());
                        artikli[j - 1] = new Stan(naslov3, opis3, cijena3, kvadratura);
                        break;
                    default:
                        System.out.println("Nepravilan unos! Molim izabrati jedan broj od ponudjenih!");
                        j--;
                        break;
                }
            }
            kategorije[i-1] = new Kategorija(naziv, artikli);
        }
        System.out.print("Unesite broj artikala koji su aktivno na prodaju: ");
        brojArtikalaNaProdaju = Integer.parseInt(scanner.nextLine());
        //todo ograniciti da se moze dodati samo manje od ukupanBrojArtikala
        odabraniKorisnici = new Korisnik[brojArtikalaNaProdaju];
        odabraniArtikli = new Artikl[brojArtikalaNaProdaju];
    }

    /**
     * Traži izbor korisnika.
     * @param scanner Scanner
     */
    private static void odaberiKorisnika(Scanner scanner){
        System.out.println("Odaberite korisnika: ");
        for(int i=1;i<=brojKorisnika;i++){
            System.out.println(i+". "+korisnici[i-1].dohvatiKontakt());
        }
        System.out.println("Odabir >> ");
        odabraniKorisnik = Integer.parseInt(scanner.nextLine());
    }

    /**
     * Traži izbor kategorije.
     * @param scanner Scanner
     */
    private static void odaberiKategoriju(Scanner scanner){
        System.out.println("Odaberite kategoriju: ");
        for(int i=1;i<=brojKategorija;i++){
            System.out.println(i+". "+kategorije[i-1].getNaziv());
        }
        System.out.println("Odabir >> ");
        odabranaKategorija = Integer.parseInt(scanner.nextLine());
    }

    /**
     * Traži izbor artikla.
     * @param scanner Scanner
     */
    private static void odaberiArtikl(Scanner scanner){
        System.out.println("Odaberite artikl: ");
        for(int i=1;i<=kategorije[odabranaKategorija-1].getArtikl().length;i++){
            System.out.println(i+". "+ kategorije[odabranaKategorija - 1].getArtikl()[i-1].getNaslov());
        }
        System.out.println("Odabir >> ");
        odabraniArtikl = Integer.parseInt(scanner.nextLine());
    }

    /**
     * Ispisuje tekst oglasa.
     */
    private static void ispisiArtikleNaProdaju(){
        System.out.println("Trenutno su oglasi na prodaju: ");
        for (int i=0; i<brojArtikalaNaProdaju; i++) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(odabraniArtikli[i].tekstOglasa());
            System.out.println("Datum objave: " + LocalDate.now());
            System.out.println("Kontakt podaci: "+odabraniKorisnici[i].dohvatiKontakt());
        }
    }

    public static void main(String[] args){
        Scanner ulaz = new Scanner(System.in); //kreira objekt
        unesikorisnika(ulaz);
        unesiKategorije(ulaz);
        for(int i=0;i<brojArtikalaNaProdaju;i++){
            odaberiKorisnika(ulaz);
            odabraniKorisnici[i]=korisnici[odabraniKorisnik-1];
            odaberiKategoriju(ulaz);
            odaberiArtikl(ulaz);
            odabraniArtikli[i]=kategorije[odabranaKategorija-1].getArtikl()[odabraniArtikl-1];
        }
        ispisiArtikleNaProdaju();
    }
}
