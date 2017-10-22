package utils;

/**
 * Created by caiomoraes on 19/10/17.
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
