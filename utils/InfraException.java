package utils;

/**
 * A token is will always have: its own text, its classification and its line number (in case of some exception).
 * <p>
 * Created on 06/08/17 by
 * <p>
 * Caio Moraes
 * GitHub: MoraesCaio
 * Email: caiomoraes
 * <p>
 * Janyelson Oliveira
 * GitHub: janyelson
 * Email: janyelsonvictor@gmail.com
 * <p>
 * Tiago Henrique
 * Github: tiagohn
 * Email: tiagohn.cc.ufpb@gmail.com
 */
public class InfraException extends Exception
{
    public InfraException()
    {
        super();
    }

    public InfraException(String message)
    {
        super(message);
    }

    public InfraException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InfraException(Throwable cause)
    {
        super(cause);
    }
}
