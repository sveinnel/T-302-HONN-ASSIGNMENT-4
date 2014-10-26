package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sveinn on 25.10.2014.
 */
public class ReviewRowmapper implements RowMapper<Review>
{
    @Override
    public Review mapRow(ResultSet rs, int i) throws SQLException
    {
        return new Review(rs.getInt("id"),
                          rs.getInt("reviewerid"),
                          rs.getInt("productid"),
                          rs.getInt("tripid"),
                          rs.getString("comment"));
    }
}
