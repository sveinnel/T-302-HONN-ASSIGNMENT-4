package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.RideInsertDatabaseExeption;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * Created by emil on 24.10.2014.
 */
public class RideData extends RuData implements RideDataGateway {
    @Override
    public int addTrip(Trip trip) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_trips")
                .usingGeneratedKeyColumns("id");

    Map<String, Object> p = new HashMap<String, Object>(10);
        p.put("riderid",  trip.getRiderId());
        p.put("productid", trip.getProductId());
        p.put("requesttime", trip.getRequestTime());
        p.put("starttime", trip.getStartTime());
        p.put("endtime", trip.getEndTime());
        p.put("startlongitude", trip.getStartLongitude());
        p.put("endlongitude", trip.getEndLongitude());
        p.put("startlatitude", trip.getStartLatitude());
        p.put("endlatitude", trip.getEndLatitude());
        p.put("distance", trip.getDistance());
        p.put("completed", trip.getStatus());

        int returnKey;

        try{
            returnKey = insert.executeAndReturnKey(p).intValue();
        }catch (DataIntegrityViolationException divex){
            throw new RideInsertDatabaseExeption("Ride insert ex " + trip.getProductId());
        }

        return returnKey;



    }

    @Override
    public List<Trip> getTrips(int riderId) {
        Collection<String> trips;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());


        List<Trip> tripss = new ArrayList<Trip>();
        Trip trip;
        try{
            for(Object t : jdbcTemplate.queryForList(
                    "select * from ru_trips where riderId = '" + riderId + "'", new RideRowMapper())
            ) {
                tripss.add((Trip)t);
            }

        }catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundExeption("Trip not found exeption with rider id : " + riderId);
        }

        return null;
    }
}
