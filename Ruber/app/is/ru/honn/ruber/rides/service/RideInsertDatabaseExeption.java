package is.ru.honn.ruber.rides.service;

/**
 * Created by emil on 24.10.2014.
 */
public class RideInsertDatabaseExeption extends RuntimeException {
    public RideInsertDatabaseExeption()
    {
    }

    public RideInsertDatabaseExeption(String message)
    {
        super(message);
    }

    public RideInsertDatabaseExeption(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RideInsertDatabaseExeption(Throwable cause)
    {
        super(cause);
    }
}
