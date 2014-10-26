package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Price;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sveinn on 25.10.2014.
 */
public class PriceRowMapper implements RowMapper<Price>
{
    @Override
    public Price mapRow(ResultSet rs, int i) throws SQLException
    {
        return new Price(
                rs.getInt("id"),
                rs.getString("currencycode"),
                ((double) rs.getFloat("lowestimate")),
                ((double) rs.getFloat("highestimate")),
                ((double) rs.getFloat("surgemultiplier")),
                ((double) rs.getFloat("finalprice"))
        );
    }
}
