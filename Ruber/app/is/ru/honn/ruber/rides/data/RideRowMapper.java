/*
 * @(#)RideRowMapper.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.pojo.Trip;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Extends RowMapper
 * Used to map sql rows to object
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class RideRowMapper implements RowMapper<Trip> {

    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Trip(
                rs.getInt("id"),
                rs.getInt("productid"),
                rs.getTimestamp("requesttime"),
                rs.getTimestamp("starttime"),
                rs.getTimestamp("endtime"),
                rs.getFloat("startlongitude"),
                rs.getFloat("endlongitude"),
                rs.getFloat("startlatitude"),
                rs.getFloat("endlatitude"),
                rs.getFloat("distance"),
                rs.getBoolean("completed"),
                rs.getInt("riderid")
        );
    }
}
