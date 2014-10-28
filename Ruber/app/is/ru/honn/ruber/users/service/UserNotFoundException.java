/*
 * @(#)ProcessException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.users.service;

/**
 * Exception that is thrown when user is
 * not found in database
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class UserNotFoundException extends RuntimeException
{
  public UserNotFoundException()
  {
  }

  public UserNotFoundException(String message)
  {
    super(message);
  }

  public UserNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public UserNotFoundException(Throwable cause)
  {
    super(cause);
  }
}
