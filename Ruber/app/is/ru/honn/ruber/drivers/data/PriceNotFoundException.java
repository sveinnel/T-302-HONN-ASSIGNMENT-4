package is.ru.honn.ruber.drivers.data;

/**
 * Created by sveinn on 25.10.2014.
 */
public class PriceNotFoundException extends Exception
{
    public PriceNotFoundException()
    {
        super();
    }

    public PriceNotFoundException(String message)
    {
        super(message);
    }

    public PriceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
