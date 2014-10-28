/*
 * @(#)UsernameExistsException.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.users.service;

/**
 * Exception that is thrown when trying
 * to add user that allready exists
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class UsernameExistsException extends RuntimeException
{
  public UsernameExistsException()
  {
  }

  public UsernameExistsException(String message)
  {
    super(message);
  }

  public UsernameExistsException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public UsernameExistsException(Throwable cause)
  {
    super(cause);
  }
}
