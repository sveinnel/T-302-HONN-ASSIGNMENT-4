/*
 * @(#)TripImportProcess.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.rides.service.RidesService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * process that imports trips to database
 * from the internet
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class TripImportProcess extends RuAbstractProcess implements TripHandler
{
  RidesService ridesService;
  TripReader reader = new TripReader();
  Logger log = Logger.getAnonymousLogger();

  @Override
  public void beforeProcess()
  {
    ApplicationContext appCtx = new FileSystemXmlApplicationContext("conf/RidesService.xml");
    ridesService = (RidesService)appCtx.getBean("RidesService");
    reader.setHandler(this);
  }

  @Override
  public void startProcess()
  {
    List<Trip> trips = new ArrayList();
    try
    {
        String importURL = getProcessContext().getImportURL();
        reader.read(importURL);

    }
    catch (ProcessException e)
    {
      String message = "Error reading importfile";
      log.severe(message);
      System.exit(0);
    }
  }

  @Override
  public void afterProcess()
  {

    List<Trip> trips = ridesService.getTrips(1,0,0).getTrips();

    for(Trip trip : trips)
    {
      System.out.println(trip);
    }
  }

  @Override
  public void addTrip(Trip trip)
  {
    ridesService.addTrip( trip);
  }
}
