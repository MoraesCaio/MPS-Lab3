package utils;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class PasswordException extends Exception
{
    public PasswordException()
    {
        super();
    }

    public PasswordException(String message)
    {
        super(message);
    }

    public PasswordException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PasswordException(Throwable cause)
    {
        super(cause);
    }
}
