package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by sveinn on 25.10.2014.
 */
public interface DriverDataGateway extends RuDataAccess
{
    public List<Product> getAllProducts();
}
