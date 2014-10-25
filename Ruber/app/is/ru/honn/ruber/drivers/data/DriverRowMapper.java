package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by sveinn on 25.10.2014.
 */
public class DriverRowMapper implements RowMapper<Product>
{

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException
    {
        return new Product(rs.getInt("id"),
                           rs.getString("description"),
                           rs.getString("displayname"),
                           rs.getInt("capacity"),
                           rs.getString("imageUrl"),
                           rs.getInt("driverid"),
                           rs.getInt("priceid"));
    }
}
