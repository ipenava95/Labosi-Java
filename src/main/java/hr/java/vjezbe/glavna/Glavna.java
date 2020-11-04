package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Glavna {
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

    private static void unesikorisnika(Scanner scanner){
        System.out.print("Unesite broj korisnika koji zelite unijeti: "); //trazi unos
        brojKorisnika = Integer.parseInt(scanner.nextLine()); //cita unos
        korisnici = new Korisnik[brojKorisnika];
        for(int i=1;i<=brojKorisnika;i++){
            System.out.print("Unesite ime "+i+". korisnika: ");
            String ime = scanner.nextLine();
            System.out.print("Unesite prezime "+i+". korisnika: ");
            String prezime = scanner.nextLine();
            System.out.print("Unesite e-mail "+i+". korisnika: ");
            String email = scanner.nextLine();
            System.out.print("Unesite telefon "+i+". korisnika: ");
            String telefon = scanner.nextLine();
            korisnici[i-1] = new Korisnik(ime, prezime, email, telefon);
        }
    }

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
                System.out.print("Unesite naslov " + j + ". oglasa artikla: ");
                String naslov = scanner.nextLine();
                System.out.print("Unesite opis " + j + ". oglasa artikla: ");
                String opis = scanner.nextLine();
                System.out.print("Unesite cijenu " + j + ". oglasa artikla: ");
                BigDecimal cijena = new BigDecimal(scanner.nextLine());
                artikli[j-1]= new Artikl(naslov, opis, cijena);
            }
            kategorije[i-1] = new Kategorija(naziv, artikli);
        }
        System.out.print("Unesite broj artikala koji su trenutno na prodaju: ");
        brojArtikalaNaProdaju = Integer.parseInt(scanner.nextLine());
        //todo ograniciti da se moze dodati samo manje od ukupanBrojArtikala
        odabraniKorisnici = new Korisnik[brojArtikalaNaProdaju];
        odabraniArtikli = new Artikl[brojArtikalaNaProdaju];
    }

    private static void odaberiKorisnika(Scanner scanner){
        System.out.println("Odaberite korisnika: ");
        for(int i=1;i<=brojKorisnika;i++){
            System.out.println(i+". "+korisnici[i-1].getIme()+" "+korisnici[i-1].getPrezime());
        }
        System.out.println("Odabir >> ");
        odabraniKorisnik = Integer.parseInt(scanner.nextLine());
    }

    private static void odaberiKategoriju(Scanner scanner){
        System.out.println("Odaberite kategoriju: ");
        for(int i=1;i<=brojKategorija;i++){
            System.out.println(i+". "+kategorije[i-1].getNaziv());
        }
        System.out.println("Odabir >> ");
        odabranaKategorija = Integer.parseInt(scanner.nextLine());
    }

    private static void odaberiArtikl(Scanner scanner){
        System.out.println("Odaberite artikl: ");
        for(int i=1;i<=kategorije[odabranaKategorija-1].getArtikl().length;i++){
            System.out.println(i+". "+ kategorije[odabranaKategorija - 1].getArtikl()[i-1].getNaslov());
        }
        System.out.println("Odabir >> ");
        odabraniArtikl = Integer.parseInt(scanner.nextLine());
    }

    private static void ispisiArtikleNaProdaju(){
        System.out.println("Trenutno su oglasi na prodaju: ");
        for (int i=0; i<brojArtikalaNaProdaju; i++) {
            System.out.println("Naslov: "+odabraniArtikli[i].getNaslov());
            System.out.println("Opis: "+odabraniArtikli[i].getOpis());
            System.out.println("Cijena: "+odabraniArtikli[i].getCijena());
            System.out.println("Datum objave: " + LocalDate.now());
            System.out.println("Kontakt podaci: "+odabraniKorisnici[i].getIme()+" "+odabraniKorisnici[i].getPrezime()+", mail: "
                    +odabraniKorisnici[i].getEmail()+", tel: "+odabraniKorisnici[i].getTelefon());
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
