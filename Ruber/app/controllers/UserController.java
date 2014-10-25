package controllers;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;

public class UserController extends Controller
{
    protected static ApplicationContext userCtx = new FileSystemXmlApplicationContext("/conf/UserService.xml");
    protected static ApplicationContext rideCtx = new FileSystemXmlApplicationContext("/conf/RidesService.xml");
    protected static ApplicationContext driverCtx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
}
