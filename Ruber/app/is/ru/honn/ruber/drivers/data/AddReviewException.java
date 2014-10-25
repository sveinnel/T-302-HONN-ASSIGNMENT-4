package is.ru.honn.ruber.drivers.data;

/**
 * Created by sveinn on 25.10.2014.
 */
public class AddReviewException extends Exception
{
    public AddReviewException()
    {
        super();
    }

    public AddReviewException(String message)
    {
        super(message);
    }

    public AddReviewException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
