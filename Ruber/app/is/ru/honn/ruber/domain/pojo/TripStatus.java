/*
 * @(#)TripStatus.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;

/**
 * Enum for showing status of a trip
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public enum TripStatus
{
  COMPLETED;

  @Override
  public String toString()
  {
    return "completed";
  }
}

