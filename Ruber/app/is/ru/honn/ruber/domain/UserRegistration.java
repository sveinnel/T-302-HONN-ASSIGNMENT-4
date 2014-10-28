/*
 * @(#)UserRegistration.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain;

import is.ru.honn.ruber.domain.pojo.User;

import java.util.Date;

/**
 * Form class for registering users
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class UserRegistration extends User
{
  protected String repeatPassword;

  public UserRegistration()
  {
  }

  public UserRegistration(int id, String username, String firstName, String lastName, String password, String email, Date registered, String repeatPassword)
  {
    super(id, username, firstName, lastName, password, email, registered);
    this.repeatPassword = repeatPassword;
  }

  public UserRegistration(String username, String firstname, String lastname, String password, String email, Date registered, String repeatPassword)
  {
    super(username, firstname, lastname, password, email, registered);
    this.repeatPassword = repeatPassword;
  }

  public String getRepeatPassword()
  {
    return repeatPassword;
  }

  public void setRepeatPassword(String repeatPassword)
  {
    this.repeatPassword = repeatPassword;
  }
}
