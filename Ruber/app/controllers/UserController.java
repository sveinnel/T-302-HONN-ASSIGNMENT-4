/*
 * @(#)UserController.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;

/**
 * User Controller handles Application Contexts
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class UserController extends Controller
{
    protected static ApplicationContext userCtx = new FileSystemXmlApplicationContext("/conf/UserService.xml");
    protected static ApplicationContext rideCtx = new FileSystemXmlApplicationContext("/conf/RidesService.xml");
    protected static ApplicationContext driverCtx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
}
