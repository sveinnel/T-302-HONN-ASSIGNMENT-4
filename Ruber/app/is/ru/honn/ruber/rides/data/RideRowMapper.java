package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by emil on 24.10.2014.
 */
public class RideRowMapper implements RowMapper<Trip> {

    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Trip(
                rs.getInt("id"),
                rs.getInt("productid"),
                rs.getDate("requesttime"),
                rs.getDate("starttime"),
                rs.getDate("endtime"),
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
