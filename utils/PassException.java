package utils;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class PassException extends Exception
{
    public PassException()
    {
        super();
    }

    public PassException(String message)
    {
        super(message);
    }

    public PassException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PassException(Throwable cause)
    {
        super(cause);
    }
}
