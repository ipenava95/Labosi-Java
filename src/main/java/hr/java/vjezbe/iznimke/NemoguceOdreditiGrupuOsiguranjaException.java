package hr.java.vjezbe.iznimke;

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception{
    private static final long serialVersionUID = 6320250778332979756L;

    public NemoguceOdreditiGrupuOsiguranjaException(){super("Dogodila se pogreska u radu sustava.S");}

    public NemoguceOdreditiGrupuOsiguranjaException(String poruka) {
        super(poruka);
    }

    public NemoguceOdreditiGrupuOsiguranjaException(Throwable uzrok) {
        super(uzrok);
    }

    public NemoguceOdreditiGrupuOsiguranjaException(String poruka, Throwable uzrok) {
        super(poruka, uzrok);
    }
}
