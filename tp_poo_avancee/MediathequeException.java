package tp_poo_avancee;

// CHOIX : checked (extends Exception).
// Justification : l'indisponibilite d'un document est une situation METIER attendue et
// recuperable (proposer une reservation, afficher un message a l'usager). L'appelant peut
// reagir utilement : le compilateur doit donc l'obliger a traiter le cas.
// Regle appliquee uniformement a toute la hierarchie MediathequeException.
public abstract class MediathequeException extends Exception {

    protected MediathequeException(String message) {
        super(message);
    }

    protected MediathequeException(String message, Throwable cause) {
        super(message, cause);
    }
}
