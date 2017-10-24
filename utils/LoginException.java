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
public class LoginException extends Exception
{
    public LoginException ()
    {
        super();
    }

    public LoginException (String message)
    {
        super(message);
    }

    public LoginException (String message, Throwable cause)
    {
        super(message, cause);
    }

    public LoginException (Throwable cause)
    {
        super(cause);
    }
}
