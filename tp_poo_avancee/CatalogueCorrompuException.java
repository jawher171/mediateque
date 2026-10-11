package tp_poo_avancee;

public class CatalogueCorrompuException extends MediathequeException {

    public CatalogueCorrompuException(String message, Throwable cause) {
        super(message, cause);   // on garde la cause !
    }
}
