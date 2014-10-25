package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;
import is.ru.honn.ruber.users.service.UserService;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sveinn on 25.10.2014.
 */
public class DriverServiceData implements DriverService
{
    private Logger log = Logger.getLogger(DriverServiceData.class.getName());

    private DriverDataGateway driverDataGateway;

    public DriverServiceData(DriverDataGateway driverDataGateway)
    {
        this.driverDataGateway = driverDataGateway;
    }


    @Override
    public List<Product> getAllProducts()
    {
        return driverDataGateway.getAllProducts();
    }

    @Override
    public List<Review> getReviewsByProductId(int productId)
    {
        return driverDataGateway.getReviewsByProductId(productId);
    }
}
