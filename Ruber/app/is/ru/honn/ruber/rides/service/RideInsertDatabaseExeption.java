/*
 * @(#)RideInsertDatabaseException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.service;

/**
 * Exception that is thrown when error
 * adding Ride to database
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
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
