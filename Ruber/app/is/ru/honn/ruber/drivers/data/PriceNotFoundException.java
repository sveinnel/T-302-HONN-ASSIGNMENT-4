/*
 * @(#)PriceNotFoundException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.data;

/**
 * Exception that is thrown when
 * error getting price from database
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
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
