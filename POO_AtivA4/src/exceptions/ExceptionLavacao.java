package exceptions;

/**
 *
 * @author YyY
 */
public class ExceptionLavacao extends Exception{

    /**
     * Creates a new instance of <code>ExceptionLavacao</code> without detail
     * message.
     */
    public ExceptionLavacao() {
    }

    /**
     * Constructs an instance of <code>ExceptionLavacao</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionLavacao(String msg) {
        super(msg);
    }
}
