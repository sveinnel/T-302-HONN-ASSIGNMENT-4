/*
 * @(#)AddReviewException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */

package is.ru.honn.ruber.drivers.data;

/**
 * Exception that is thrown when error adding review
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
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
