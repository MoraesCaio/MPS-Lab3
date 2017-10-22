package utils;

/**
 * Created by caiomoraes on 19/10/17.
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
