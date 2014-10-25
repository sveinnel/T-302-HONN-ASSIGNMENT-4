package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;
import is.ruframework.data.RuData;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sveinn on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway
{
    @Override
    public List<Product> getAllProducts()
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Product> products;
        products = template.query("select * from ru_products", new DriverRowMapper());
        return products;
    }
}
