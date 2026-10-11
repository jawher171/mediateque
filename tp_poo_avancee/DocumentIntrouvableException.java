package tp_poo_avancee;

public class DocumentIntrouvableException extends MediathequeException {

    public DocumentIntrouvableException(String titre) {
        super("Aucun document au titre : " + titre);
    }
}
