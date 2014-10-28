/*
 * @(#)TripNotFoundException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.data;

/**
 * Exception that is thrown when
 * trip is not found in database
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
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
