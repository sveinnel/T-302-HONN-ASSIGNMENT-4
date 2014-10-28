/*
 * @(#)RidesServiceStub.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.service;


import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;

import java.util.ArrayList;
import java.util.List;

/**
 * Test Stub for RideService
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class RidesServiceStub implements RidesService
{
  //List<Trip> theTrips = new ArrayList<Trip>();
    History history = new History();
  @Override
  public void addTrip(Trip trip)
  {
   history.addTrip(trip);
  }

  @Override
  public History getTrips(int userId, int offset, int limmit)
  {
    return history;
  }
}

