/*
 * @(#)Application.java 0.1 28.Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import views.html.index;

/**
 * Returns index site
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class Application extends Controller
{
  public static Result index()
  {
     return ok(index.render(""));
  }

}
