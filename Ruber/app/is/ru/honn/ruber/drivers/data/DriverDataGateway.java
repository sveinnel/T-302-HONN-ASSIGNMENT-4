package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by sveinn on 25.10.2014.
 */
public interface DriverDataGateway extends RuDataAccess
{
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public List<Review> getReviewsByProductId(int productId);
    public Review addReview(int productId, int riderId, int rating, String comment) throws AddReviewException;

    Price getPriceById(int id) throws PriceNotFoundException;

    public List<Product> getProductsByDriverId(int driverid);

}
