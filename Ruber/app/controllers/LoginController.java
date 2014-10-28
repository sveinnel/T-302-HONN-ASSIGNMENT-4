/*
 * @(#)DriverController.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */

package controllers;


import is.ru.honn.ruber.domain.pojo.User;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UserService;
import play.data.*;
import play.mvc.*;

import static play.data.Form.form;

import views.html.index;
import views.html.login;

/**
 * Login Controller handles login requests
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class LoginController extends UserController
{
  final static Form<User> loginForm = form(User.class);

  public static Result blank()
  {
    return ok(login.render(loginForm));
  }

  public static Result login()
  {
    Form<User> filledForm = loginForm.bindFromRequest();

    UserService service = (UserService) userCtx.getBean("userService");

    try
    {
      User user = service.getUser(filledForm.field("username").value());
      if (!user.getPassword().equals(filledForm.field("password").value()))
      {
        // Let's throw this exception here to use the same logic for
        // unsuccessful login (both username not found and incorrect
        // password.
        throw new UserNotFoundException();
      }

      session("username", user.getUsername());
      //session("displayImg",user.get)
      session("displayName", user.getFirstName() + " " + user.getLastName());

    }
    catch (UserNotFoundException unfe)
    {
      filledForm.reject("password", "User not found or incorrect password entered.");
      return badRequest(login.render(filledForm));
    }

    if (session().get("username") != null)
    {
      return redirect("/");
    }
    else
      return redirect("/");
  }

  public static Result logout()
  {
    session().clear();
    return redirect("/");
  }
}
