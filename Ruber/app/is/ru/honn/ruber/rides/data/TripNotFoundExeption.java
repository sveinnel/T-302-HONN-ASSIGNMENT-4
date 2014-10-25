package is.ru.honn.ruber.rides.data;

/**
 * Created by emil on 24.10.2014.
 */
public class TripNotFoundExeption extends RuntimeException {
    public TripNotFoundExeption()
    {
    }

    public TripNotFoundExeption(String message)
    {
        super(message);
    }

    public TripNotFoundExeption(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TripNotFoundExeption(Throwable cause)
    {
        super(cause);
    }
}
