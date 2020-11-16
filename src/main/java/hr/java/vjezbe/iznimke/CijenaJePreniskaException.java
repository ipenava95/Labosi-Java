package hr.java.vjezbe.iznimke;

public class CijenaJePreniskaException extends RuntimeException {
    private static final long serialVersionUID = 1451205076392043860L;

    public CijenaJePreniskaException(){super("Dogodila se pogreska u radu programa.");}

    public CijenaJePreniskaException(String poruka) {
        super(poruka);
    }

    public CijenaJePreniskaException(Throwable uzrok) {
        super(uzrok);
    }

    public CijenaJePreniskaException(String poruka, Throwable uzrok) {
        super(poruka, uzrok);
    }
}
