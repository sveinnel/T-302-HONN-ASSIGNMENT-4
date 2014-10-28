/*
 * @(#)ProcessException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.process;

/**
 * Exception that is thrown when error in process
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class ProcessException extends Exception
{
  public ProcessException()
  {
    super();
  }

  public ProcessException(String message)
  {
    super(message);
  }

  public ProcessException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
